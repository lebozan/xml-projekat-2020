package ftn.xml.ServisPoverenik.util;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.modules.CollectionManagementService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XmlDbConnectionUtils {
    private static String connectionUri = "xmldb:exist://%1$s:%2$s/exist/xmlrpc";

    static public class ConnectionProperties {

        public String host;
        public int port = -1;
        public String user;
        public String password;
        public String driver;
        public String uri;

        public ConnectionProperties(Properties props) {
            super();

            user = props.getProperty("conn.user").trim();
            password = props.getProperty("conn.password").trim();

            host = props.getProperty("conn.host").trim();
            port = Integer.parseInt(props.getProperty("conn.port"));

            uri = String.format(connectionUri, host, port);

            driver = props.getProperty("conn.driver").trim();
        }
    }

    public static ConnectionProperties loadProperties() throws IOException {
        String propsName = "exist.properties";

        InputStream propsStream = openStream(propsName);
        if (propsStream == null)
            throw new IOException("Could not read properties " + propsName);

        Properties props = new Properties();
        props.load(propsStream);

        return new ConnectionProperties(props);
    }

    /**
     * Read a resource for an example.
     *
     * @param fileName
     *            the name of the resource
     * @return an input stream for the resource
     * @throws IOException
     */
    public static InputStream openStream(String fileName) throws IOException {
        return XmlDbConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static Collection getOrCreateCollection(String collectionUri) throws Exception {
        return getOrCreateCollection(collectionUri, 0);
    }

    private static Collection getOrCreateCollection(String collectionUri, int pathSegmentOffset) throws Exception {

        ConnectionProperties conn = loadProperties();

        Class cl = Class.forName(conn.driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        Collection col = DatabaseManager.getCollection(conn.uri + collectionUri, conn.user, conn.password);

        // create the collection if it does not exist
        if(col == null) {

            if(collectionUri.startsWith("/")) {
                collectionUri = collectionUri.substring(1);
            }

            String pathSegments[] = collectionUri.split("/");

            if(pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for(int i = 0; i <= pathSegmentOffset; i++) {
                    path.append("/" + pathSegments[i]);
                }

                Collection startCol = DatabaseManager.getCollection(conn.uri + path, conn.user, conn.password);

                if (startCol == null) {

                    // child collection does not exist

                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(conn.uri + parentPath, conn.user, conn.password);

                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");

                    System.out.println("[INFO] Creating the collection: " + pathSegments[pathSegmentOffset]);
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);

                    col.close();
                    parentCol.close();

                } else {
                    startCol.close();
                }
            }
            return getOrCreateCollection(collectionUri, ++pathSegmentOffset);
        } else {
            return col;
        }
    }
}
