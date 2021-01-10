package ftn.xml.ServisPoverenik.repository;

import ftn.xml.ServisPoverenik.model.resenje.Resenje;
import ftn.xml.ServisPoverenik.model.zalbanacutanje.ZalbaCutanje;
import ftn.xml.ServisPoverenik.util.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.xml.sax.SAXException;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Repository
public class ResenjeRepository {

    private final String RESENJE_COLLECTION_NAME = "/db/resenje";
    private final String RESENJE_NAMED_GRAPH_URI = "/resenja/metadata";

    public boolean saveResenje(String documentId) {

        return false;
    }

    private void extractAndSaveMetadata(String xml) throws Exception {
        MetadataExtractor extractor = new MetadataExtractor();
        InputStream in = new ByteArrayInputStream(xml.getBytes());

        OutputStream out = new FileOutputStream("src/main/resources/xmlFiles/rdf/metadataTest.rdf");

        extractor.extractMetadata(in, out);

        RdfDbConnectionUtils.writeMetadataToDatabase(RESENJE_NAMED_GRAPH_URI);
    }

    private void readResenjaMetadata() throws Exception {
        RdfDbConnectionUtils.loadMetadataFromDatabase(RESENJE_NAMED_GRAPH_URI);
    }

    public void saveResenjeXml(String documentId, String xml) throws Exception {
        String collectionId = RESENJE_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            extractAndSaveMetadata(xml);
            readResenjaMetadata();

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(Resenje.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/resenje.xsd"));
            marshaller.setSchema(schema);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);

            // convert XML file to object
            StringReader reader = new StringReader(xml);
            Resenje resenje = (Resenje) unmarshaller.unmarshal(reader);
            // marshal the contents to an output stream
            marshaller.marshal(resenje, os);

            // link the stream to the XML resource
            res.setContent(os);
            System.out.println("[INFO] Storing the document: " + res.getId());

            col.storeResource(res);
            System.out.println("[INFO] Done.");



        } catch (Exception e) {
            e.printStackTrace();
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
    }

    public Object findResenje(String documentId) {
        Object resenje = null;

        try {
//            resenje = JAXBReader.writeResenjeXml(documentId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resenje;
    }



}
