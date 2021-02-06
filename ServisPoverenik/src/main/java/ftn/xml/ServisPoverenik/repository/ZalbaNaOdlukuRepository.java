package ftn.xml.ServisPoverenik.repository;

import ftn.xml.ServisPoverenik.model.resenje.Resenje;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbeNaOdluku;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku.Napomene;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku.Zaglavlje;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku.ZalbaSadrzaj;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku.ZalbaSadrzaj.Paragrafi;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku.ZalbaSadrzaj.Paragrafi.ParagrafPodaci;
import ftn.xml.ServisPoverenik.util.JAXBReader;
import ftn.xml.ServisPoverenik.util.XUpdateTemplate;
import ftn.xml.ServisPoverenik.util.XmlDbConnectionUtils;
//import rdf.domuti;
//import rdf.generisimetapodatke
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XUpdateQueryService;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ZalbaNaOdlukuRepository {

    private final String ZALBA_ODLUKA_COLLECTION_NAME = "/db/zalbaNaOdluku";

    public boolean saveZalbaNaOdluku(ZalbaNaOdluku zo){

        Collection col = null;
        OutputStream os = new ByteArrayOutputStream();
        String targetNamespace = "http://www.ftn.un.ac.rs/zalbaNaOdluku";

        try {
            
            col = XmlDbConnectionUtils.getOrCreateCollection("/db/ZalbeNaOdluku");
            XMLResource res = (XMLResource) col.getResource("ZalbeNaOdluku.xml");

            if (res == null) {
                res = (XMLResource) col.createResource("ZalbeNaOdluku.xml", XMLResource.RESOURCE_TYPE);
                JAXBContext jaxbContext = JAXBContext.newInstance(ZalbeNaOdluku.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//                ZalbeNaOdluku zalbenaodluku = new ZalbeNaOdluku();
//                List<ZalbaNaOdluku> lista = new ArrayList<>();
//                ZalbaNaOdluku prvi = new ZalbaNaOdluku();
//                //TODO: postaviti sve atribute zalbe
//                Zaglavlje z = new Zaglavlje();
//                z.setNaslov("ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ");
//                z.setPrimalac("Повереникy за информације од јавног значаја и заштиту података о личности");
//                z.setAdresaPrimaoca("Адреса за пошту: Београд, Булевар краља Александрa бр. 15");
//                prvi.setZaglavlje(z);
//                Napomene n = new Napomene();
//                prvi.setNapomene(n);
//                ZalbaSadrzaj zs = new ZalbaSadrzaj();
//                // NASTAVI POPUNJAVANJE ILI IZMENI
//                Paragrafi p = new Paragrafi();
//
//                lista.add(prvi);
                zalbenaodluku.setZalbaNaOdluku(lista);
                jaxbMarshaller.marshal(zalbenaodluku, os);

                res.setContent(os);

                col.storeResource(res);
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(ZalbaNaOdluku.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(documentId, os);

            res.setContent(os);

            String xmlFragment = os.toString();
            String xmlStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            xmlFragment = xmlFragment.replace(xmlStart, "");
            System.out.println(xmlFragment);

            XUpdateQueryService service = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            service.setProperty("indent", "yes");

            String contextPath = "/ZalbeNaOdluku";
            System.out.println(String.format(XUpdateTemplate.append(targetNamespace), contextPath, xmlFragment));
            long mods = service.updateResource("ZalbeNaOdluku.xml", String.format(XUpdateTemplate.append(targetNamespace), contextPath, xmlFragment));

            System.out.println("[INFO] " + mods + " modifications processed.");
        }

        return true;
    }


    public void saveZalbaNaOdlukuXml(String documentId, String xml) throws Exception {
        String collectionId = ZALBA_ODLUKA_COLLECTION_NAME;
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
            JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zalbanaodluku-schema.xsd"));
            marshaller.setSchema(schema);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);

            // convert XML file to object
            StringReader reader = new StringReader(xml);
            ZalbaNaOdluku zalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(reader);
            // marshal the contents to an output stream
            marshaller.marshal(zalbaNaOdluku, os);

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

    public Object findZalbaNaOdluku(String documentId) {
        String collectionId = ZALBA_ODLUKA_COLLECTION_NAME;
        Collection col = null;
        XMLResource res = null;

        Object test = null;
        ZalbaNaOdluku zalbaNaOdluku = null;
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
//                JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
//
//                // create an instance of `Unmarshaller`
//                Unmarshaller unmarshaller = context.createUnmarshaller();
//
//                SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//                Schema schema = sf.newSchema(new File("../xml-documents/zalbanaodluku-schema.xsd"));
//                unmarshaller.setSchema(schema);
//
//                // convert XML file to object
//                zalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(res.getContentAsDOM());
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
