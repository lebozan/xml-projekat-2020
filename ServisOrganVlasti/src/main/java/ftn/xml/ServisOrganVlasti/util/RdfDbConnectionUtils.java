package ftn.xml.ServisOrganVlasti.util;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;


public class RdfDbConnectionUtils {

    static public class ConnectionProperties {

        public String endpoint;
        public String dataset;

        public String queryEndpoint;
        public String updateEndpoint;
        public String dataEndpoint;


        public ConnectionProperties(Properties props) {
            super();
            dataset = props.getProperty("conn.dataset").trim();
            endpoint = props.getProperty("conn.endpoint").trim();

            queryEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.query").trim());
            updateEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.update").trim());
            dataEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.data").trim());

            System.out.println("[INFO] Parsing connection properties:");
            System.out.println("[INFO] Query endpoint: " + queryEndpoint);
            System.out.println("[INFO] Update endpoint: " + updateEndpoint);
            System.out.println("[INFO] Graph store endpoint: " + dataEndpoint);
        }
    }

    /**
     * Read the configuration properties for the example.
     *
     * @return the configuration object
     */
    public static ConnectionProperties loadProperties() throws IOException {
        String propsName = "rdf.properties";

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
        return ftn.xml.ServisOrganVlasti.util.RdfDbConnectionUtils.class.getClassLoader().getResourceAsStream(fileName);
    }


    public static void writeMetadataToDatabase(String namedGraphUri) throws Exception {
        ConnectionProperties conn = loadProperties();

        System.out.println("[INFO] Loading triples from an RDF/XML to a model...");

        // RDF triples which are to be loaded into the model
        String rdfFilePath = "src/main/resources/xmlFiles/rdf/metadata.rdf";

        // Creates a default model
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Rendering model as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

//        UpdateRequest drop = UpdateFactory.create();
//        drop.add(SparqlUtil.dropAll());
//
//        UpdateProcessor dropProcessor = UpdateExecutionFactory.createRemote(drop, conn.updateEndpoint);
//        dropProcessor.execute();

        // Creating the first named graph and updating it with RDF data
        System.out.println("[INFO] Writing the triples to a named graph \"" + namedGraphUri + "\".");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + namedGraphUri, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();

    }

    public static void loadMetadataFromDatabase(String namedGraphUri) throws Exception{
        ConnectionProperties conn = loadProperties();

        // Querying the first named graph with a simple SPARQL query
        System.out.println("[INFO] Selecting the triples from the named graph \"" + namedGraphUri + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + namedGraphUri, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        while(results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next() ;
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);
            }
            System.out.println();
        }

        System.out.println("[INFO] End.");

    }


}
