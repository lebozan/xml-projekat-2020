package ftn.xml.ServisOrganVlasti.repository;

import ftn.xml.ServisOrganVlasti.model.zalbanacutanje.ZalbaCutanje;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import ftn.xml.ServisOrganVlasti.util.MetadataExtractor;
import ftn.xml.ServisOrganVlasti.util.RdfDbConnectionUtils;
import ftn.xml.ServisOrganVlasti.util.XmlDbConnectionUtils;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

@Repository
public class ZalbaNaCutanjeRepository {

    private final String ZALBA_CUTANJE_COLLECTION_NAME = "/db/zalbaNaCutanje";
    public final String ZALBA_CUTANJE_NAMED_GRAPH_URI = "/zalbacutanje/metadata";

    public boolean saveZalbaNaCutanje(String documentId) {
        String collectionId = ZALBA_CUTANJE_COLLECTION_NAME;
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
            JAXBContext context = JAXBContext.newInstance(ZalbaCutanje.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zalbanacutanje.xsd"));
            marshaller.setSchema(schema);

            // samo privremeno
            ZalbaCutanje zalbaCutanje = JAXBReader.writeZalbaNaCutanjeXml(documentId);

            // marshal the contents to an output stream
            marshaller.marshal(zalbaCutanje, os);

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

    public Object findZalbaNaCutanje(String documentId) {

        String collectionId = ZALBA_CUTANJE_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;
        Object test = null;
        ZalbaCutanje zalbaCutanje = null;

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
//                JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

                // create an instance of `Unmarshaller`
//                Unmarshaller unmarshaller = context.createUnmarshaller();
//
//                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//                Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
//                unmarshaller.setSchema(schema);

                // convert XML file to object
//                zalbaCutanje = (ZalbaCutanje) unmarshaller.unmarshal(res.getContentAsDOM());
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

    public void saveZalbaNaCutanjeXml(String documentId, String xml) throws Exception {
        String collectionId = ZALBA_CUTANJE_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            extractAndSaveMetadata(documentId, xml);
            readZahteviMetadata();

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            /*
             *  create new XMLResource with a given id
             *  an id is assigned to the new resource if left empty (null)
             */
            System.out.println("[INFO] Inserting the document: " + documentId);
            res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);

            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(ZalbaCutanje.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zalbanacutanje.xsd"));
            marshaller.setSchema(schema);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);

            // convert XML file to object
            StringReader reader = new StringReader(xml);
            ZalbaCutanje zalbaCutanje = (ZalbaCutanje) unmarshaller.unmarshal(reader);
            // marshal the contents to an output stream
            marshaller.marshal(zalbaCutanje, os);

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

    private void extractAndSaveMetadata(String documentId, String xml) throws Exception {
        MetadataExtractor extractor = new MetadataExtractor();
        InputStream in = new ByteArrayInputStream(xml.getBytes());

        OutputStream out = new FileOutputStream("src/main/resources/xmlFiles/rdf/" + documentId + ".rdf");

        extractor.extractMetadata(in, out);

        RdfDbConnectionUtils.writeMetadataToDatabase(ZALBA_CUTANJE_NAMED_GRAPH_URI);
        System.out.println(ZALBA_CUTANJE_NAMED_GRAPH_URI);
        out.close();
        File metadata = new File("src/main/resources/xmlFiles/rdf/" + documentId + ".rdf");
        metadata.delete();
    }

    private void readZahteviMetadata() throws Exception {
        RdfDbConnectionUtils.loadMetadataFromDatabase(ZALBA_CUTANJE_NAMED_GRAPH_URI);
    }


}
