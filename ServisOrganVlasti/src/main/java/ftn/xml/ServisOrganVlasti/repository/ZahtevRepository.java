package ftn.xml.ServisOrganVlasti.repository;

import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import ftn.xml.ServisOrganVlasti.util.XmlDbConnectionUtils;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

@Repository
public class ZahtevRepository {


    public boolean saveZahtev(String documentId) {
        String collectionId = "/db/zahtev";
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
            marshaller.setSchema(schema);

            ZahtevZaPristupInformacijama zahtev = JAXBReader.writeZahtevXml(documentId);
            // marshal the contents to an output stream
            marshaller.marshal(zahtev, os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

            //don't forget to cleanup
            if (res != null) {
                try {
                    ((EXistResource) res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return true;
    }


    public Object findZahtev(String documentId) {
        String collectionId = "/db/zahtev";
        Collection col = null;
        XMLResource res = null;

        Object test = null;
        ZahtevZaPristupInformacijama zahtev = null;
        try {
            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            System.out.println("[INFO] Retrieving the document: " + documentId);
            res = (XMLResource)col.getResource(documentId);

            if(res == null) {
                System.out.println("[WARNING] Document '" + documentId + "' can not be found!");
            } else {
                JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

                // create an instance of `Unmarshaller`
                Unmarshaller unmarshaller = context.createUnmarshaller();

                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
                unmarshaller.setSchema(schema);

                // convert XML file to object
                zahtev = (ZahtevZaPristupInformacijama) unmarshaller.unmarshal(res.getContentAsDOM());
                test = res.getContent();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //don't forget to clean up!

            if(res != null) {
                try {
                    ((EXistResource)res).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }

            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return test;
    }

}
