package ftn.xml.ServisOrganVlasti.repository;

import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.model.zahtevi.Zahtevi;
import ftn.xml.ServisOrganVlasti.util.MetadataExtractor;
import ftn.xml.ServisOrganVlasti.util.RdfDbConnectionUtils;
import ftn.xml.ServisOrganVlasti.util.XmlDbConnectionUtils;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ZahtevRepository {

    public final String ZAHTEV_COLLECTION_NAME = "/db/zahtev";
    public final String ZAHTEV_NAMED_GRAPH_URI = "/zahtev/metadata";


    public Object findZahtev(String id) {
        String collectionId = ZAHTEV_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();
        Object zahtev = null;
        try {
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            res = (XMLResource)col.getResource("zahtevi.xml");

            JAXBContext context = JAXBContext.newInstance(Zahtevi.class);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zahtevi.xsd"));
            unmarshaller.setSchema(schema);

            // convert XML file to object
            Zahtevi zahtevi = (Zahtevi) unmarshaller.unmarshal(res.getContentAsDOM());

            JAXBContext zahtevContext = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

            // create an instance of `Unmarshaller`
            Marshaller marshaller = zahtevContext.createMarshaller();

            SchemaFactory zahtevsf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema zahtevschema = zahtevsf.newSchema(new File("../xml-documents/zahtev.xsd"));
            marshaller.setSchema(zahtevschema);

            for (ZahtevZaPristupInformacijama z : zahtevi.getZahtevZaPristupInformacijama()) {
                if (z.getId().equals(id)) {
                    marshaller.marshal(z, os);
                    XMLResource xmlResource = (XMLResource) res;
                    xmlResource.setContent(os);
                    zahtev = xmlResource.getContent();

                }
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
        return zahtev;
    }

    public ZahtevZaPristupInformacijama findZahtevClass(String id) {
        String collectionId = ZAHTEV_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;

        ZahtevZaPristupInformacijama zahtev = null;
        try {
            // get the collection
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);
            col.setProperty(OutputKeys.INDENT, "yes");

            res = (XMLResource)col.getResource("zahtevi.xml");

            JAXBContext context = JAXBContext.newInstance(Zahtevi.class);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zahtevi.xsd"));
            unmarshaller.setSchema(schema);

            // convert XML file to object
            Zahtevi zahtevi = (Zahtevi) unmarshaller.unmarshal(res.getContentAsDOM());

            for (ZahtevZaPristupInformacijama z : zahtevi.getZahtevZaPristupInformacijama()) {
                if (z.getId().equals(id)) {
                    zahtev = z;
                }
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
        return zahtev;
    }

    public void saveZahtevXml(ZahtevZaPristupInformacijama zahtev) throws Exception {
        String collectionId = ZAHTEV_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;
        OutputStream os = new ByteArrayOutputStream();

        try {

            extractAndSaveMetadata();
            readZahteviMetadata();

            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);


            res = (XMLResource) col.getResource("zahtevi.xml");

            if (res == null) {
                res = (XMLResource) col.createResource("zahtevi.xml", XMLResource.RESOURCE_TYPE);
                JAXBContext jaxbContext = JAXBContext.newInstance(Zahtevi.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                Zahtevi zahtevi = new Zahtevi();
                List<ZahtevZaPristupInformacijama> lista = new ArrayList<>();

//                JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);
//
//                // create an instance of `Unmarshaller`
//                Unmarshaller unmarshaller = context.createUnmarshaller();
//
//                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//                Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
//                unmarshaller.setSchema(schema);
//
//                // convert XML file to object
//                ZahtevZaPristupInformacijama z = (ZahtevZaPristupInformacijama) unmarshaller.unmarshal(new File("src/main/resources/xmlFiles/xhtml/zahtev.xml"));
//                lista.add(z);

                zahtevi.setZahtevZaPristupInformacijama(lista);
                jaxbMarshaller.marshal(zahtevi, os);

                res.setContent(os);

                col.storeResource(res);
            }
            os = new ByteArrayOutputStream();

            // zahteve iz baze u objekat pa se doda u njega
            JAXBContext contextZahtevi = JAXBContext.newInstance(Zahtevi.class);
            Unmarshaller unmarshaller = contextZahtevi.createUnmarshaller();

            SchemaFactory sfZahtevi = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schemaZahtevi = sfZahtevi.newSchema(new File("../xml-documents/zahtevi.xsd"));
            unmarshaller.setSchema(schemaZahtevi);

            Zahtevi zahtevi = (Zahtevi) unmarshaller.unmarshal(res.getContentAsDOM());
//            JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);
            zahtevi.getZahtevZaPristupInformacijama().add(zahtev);

            Marshaller marshaller = contextZahtevi.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setSchema(schemaZahtevi);
            marshaller.marshal(zahtevi, os);

            res.setContent(os);

            col.storeResource(res);


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



    public Object getAllZahtevi() {
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;

        collectionId = "/db/zahtev";
        xqueryFilePath = "src\\main\\resources\\query\\getAllZahtevi.xqy";

        Collection col = null;
        try {

            // get the collection
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            // get an instance of xquery service
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            xqueryService.setProperty("indent", "yes");

            xqueryExpression = String.format(this.readFile(xqueryFilePath));

            // compile and execute the expression
            CompiledExpression compiledXquery = xqueryService.compile(xqueryExpression);
            ResourceSet result = xqueryService.execute(compiledXquery);

            ResourceIterator i = result.getIterator();
            Resource res = null;

            JAXBContext jaxbContext = JAXBContext.newInstance(Zahtevi.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            while (i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    XMLResource xmlResource = (XMLResource) res;
                    return xmlResource.getContent();
                } finally {

                    // don't forget to cleanup resources
                    try {
                        ((EXistResource) res).freeResources();
                    } catch (XMLDBException xe) {
                        xe.printStackTrace();
                    }
                }

            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // don't forget to cleanup
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        // promeni
        return null;

    }

    private void extractAndSaveMetadata() throws Exception {
        MetadataExtractor extractor = new MetadataExtractor();
        String xml = Files.readString(Path.of("src/main/resources/xmlFiles/xhtml/zahtev.xml"));
        InputStream in = new ByteArrayInputStream(xml.getBytes());

        OutputStream out = new FileOutputStream("src/main/resources/xmlFiles/rdf/metadata.rdf");

        extractor.extractMetadata(in, out);

        RdfDbConnectionUtils.writeMetadataToDatabase(ZAHTEV_NAMED_GRAPH_URI);
    }

    private void readZahteviMetadata() throws Exception {
        RdfDbConnectionUtils.loadMetadataFromDatabase(ZAHTEV_NAMED_GRAPH_URI);
    }

    private String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);

    }
}
