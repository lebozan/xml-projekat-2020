package ftn.xml.ServisOrganVlasti.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import ftn.xml.ServisOrganVlasti.model.korisnici.Korisnici;
import ftn.xml.ServisOrganVlasti.model.korisnici.ObjectFactory;
import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.rdf.DomUtil;
import ftn.xml.ServisOrganVlasti.rdf.GenerisiMetapodatke;
import ftn.xml.ServisOrganVlasti.util.*;
import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.CompiledExpression;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XQueryService;
import org.xmldb.api.modules.XUpdateQueryService;


@Repository
public class KorisnikRepository {


    @Autowired
    GenerisiMetapodatke generator;

    @Autowired
    DomUtil dom;

    public boolean saveUser(Korisnik korisnik) {
        Collection col = null;
        OutputStream os = new ByteArrayOutputStream();
        String targetNamespace = "http://www.ftn.un.ac.rs/korisnici";

        Korisnik postojeci = getUserById(korisnik.getIdKorisnika());
        if (postojeci != null) {
            return false;
        }
        try {
//            XMLResourcesDB resourcesDb = this.connection.run("korisnici.xml");

            col = XmlDbConnectionUtils.getOrCreateCollection("/db/organVlastiKorisnici");
            XMLResource res = (XMLResource) col.getResource("korisnici.xml");

            if (res == null) {
                res = (XMLResource) col.createResource("korisnici.xml", XMLResource.RESOURCE_TYPE);
                JAXBContext jaxbContext = JAXBContext.newInstance(Korisnici.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                Korisnici korisnici = new Korisnici();
                List<Korisnik> lista = new ArrayList<>();
                Korisnik prvi = new Korisnik();
                prvi.setIdKorisnika("1");
                prvi.setKorisnickoIme("korisnik");
                prvi.setIme("Nikola Tesla");
                prvi.setLozinka("Lozinka");
                prvi.setTipKorisnika("korisnik");
                prvi.setUloga("gradjanin");
                lista.add(prvi);
                korisnici.setKorisnik(lista);
                jaxbMarshaller.marshal(korisnici, os);

                res.setContent(os);

                col.storeResource(res);
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            os = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(korisnik, os);

            res.setContent(os);

            String xmlFragment = os.toString();
            String xmlStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            xmlFragment = xmlFragment.replace(xmlStart, "");
            System.out.println(xmlFragment);

            XUpdateQueryService service = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            service.setProperty("indent", "yes");

            String contextPath = "/korisnici";
            System.out.println(String.format(XUpdateTemplate.append(targetNamespace), contextPath, xmlFragment));
            long mods = service.updateResource("korisnici.xml", String.format(XUpdateTemplate.append(targetNamespace), contextPath, xmlFragment));

            System.out.println("[INFO] " + mods + " modifications processed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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



    public Korisnici getAllKorisnici() {
        System.out.println("[INFO] " + KorisnikRepository.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;

        System.out.println("[INFO] Using defaults.");
        collectionId = "/db/organVlastiKorisnici";
        xqueryFilePath = "src\\main\\resources\\query\\getAllKorisnici.xqy";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- xQuery file path: " + xqueryFilePath);



        Collection col = null;

        try {

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            // get an instance of xquery service
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            xqueryService.setProperty("indent", "yes");

            // read xquery
            System.out.println("[INFO] Invoking XQuery service for: " + xqueryFilePath);

            xqueryExpression = String.format(this.readFile(xqueryFilePath));
            System.out.println(xqueryExpression);

            // compile and execute the expression
            CompiledExpression compiledXquery = xqueryService.compile(xqueryExpression);
            ResourceSet result = xqueryService.execute(compiledXquery);

            // handle the results
            System.out.println("[INFO] Handling the results... ");

            ResourceIterator i = result.getIterator();
            Resource res = null;

            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnici.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            while (i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    XMLResource xmlResource = (XMLResource) res;
                    Korisnici p = (Korisnici) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                    return p;
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



    public Korisnik login(String username) {

        // initialize collection and document identifiers
        String collectionId = "/db/organVlastiKorisnici";
        String xqueryFilePath = null, xqueryExpression = null;
        xqueryFilePath = "ServisOrganVlasti/src/main/resources/query/query-log.xqy";

        Collection col = null;

        try {

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            // get an instance of xquery service
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            xqueryService.setProperty("indent", "yes");

            // read xquery
            System.out.println("[INFO] Invoking XQuery service for: " + xqueryFilePath);
            xqueryExpression = String.format(this.readFile(xqueryFilePath), username);
            System.out.println(xqueryExpression);

            // compile and execute the expression
            CompiledExpression compiledXquery = xqueryService.compile(xqueryExpression);
            ResourceSet result = xqueryService.execute(compiledXquery);

            // handle the results
            System.out.println("[INFO] Handling the results... ");

            ResourceIterator i = result.getIterator();
            Resource res = null;

            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("ServisOrganVlasti/src/main/resources/seme/korisnik.xsd"));
            unmarshaller.setSchema(schema);


            while(i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    XMLResource xmlResource = (XMLResource)res;
                    Korisnik k = (Korisnik) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                    return k;
                } finally {

                    // don't forget to cleanup resources
                    try {
                        ((EXistResource)res).freeResources();
                    } catch (XMLDBException xe) {
                        xe.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // don't forget to cleanup
            if(col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }
        return null;

    }



    private String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);

    }


    public Korisnik getUserById(String id) {
        //vracamo korisnika po id-u

        System.out.println("[INFO] " + KorisnikRepository.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;

        collectionId = "/db/organVlastiKorisnici";
        xqueryFilePath = "src/main/resources/query/getUserById.xqy";

        Collection col = null;

        try {

            // get the collection
            col = XmlDbConnectionUtils.getOrCreateCollection(collectionId);

            // get an instance of xquery service
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            xqueryService.setProperty("indent", "yes");


            xqueryExpression = String.format(this.readFile(xqueryFilePath), id);
            System.out.println(xqueryExpression);

            // compile and execute the expression
            CompiledExpression compiledXquery = xqueryService.compile(xqueryExpression);
            ResourceSet result = xqueryService.execute(compiledXquery);

            ResourceIterator i = result.getIterator();
            Resource res = null;

            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            while (i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    XMLResource xmlResource = (XMLResource) res;
                    Korisnik l = (Korisnik) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                    return l;
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

        return null;
    }
}
