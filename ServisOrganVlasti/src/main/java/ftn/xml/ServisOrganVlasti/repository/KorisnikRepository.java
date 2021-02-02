package ftn.xml.ServisOrganVlasti.repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnici;
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
    private ExistConnection connection;

    @Autowired
    GenerisiMetapodatke generator;

    @Autowired
    DomUtil dom;

    public void saveUser(Korisnik k) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IOException, XMLDBException, JAXBException {
        Collection col = null;
        String targetNamespace = "http://www.ftn.un.ac.rs/korisnici";
        try {
            XMLResourcesDB resourcesDb = this.connection.run("korisnici.xml");

            col = resourcesDb.getCollection();
            XMLResource res = resourcesDb.getXmlResource();
            System.out.println(col);


            StringWriter sw = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(Korisnik.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(k, sw);
            String xmlFragment = sw.toString();
            String xmlStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            xmlFragment = xmlFragment.replace(xmlStart, "");
            System.out.println(xmlFragment);

            XUpdateQueryService service = (XUpdateQueryService) col.getService("XUpdateQueryService", "1.0");
            service.setProperty("indent", "yes");

            String contextPath = "/korisnici";
            long mods = service.updateResource("korisnici.xml",
                    String.format(XUpdateTemplate.append(targetNamespace), contextPath, xmlFragment));
            System.out.println("[INFO] " + mods + " modifications processed.");
        } finally {
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

    }



    public Korisnici getAllKorisnici() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, XMLDBException, JAXBException {
        System.out.println("[INFO] " + KorisnikRepository.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;

        System.out.println("[INFO] Using defaults.");
        collectionId = "/db/sample/library";
        xqueryFilePath = ".//src//main//java//resources//query//getAllKorisnici.xqy";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- xQuery file path: " + xqueryFilePath);


        XMLResourcesDB resourcesDb = this.connection.run("korisnici.xml");

        Collection col = null;

        try {

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = resourcesDb.getCollection();

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
    }





    public Korisnik login(String username)
            throws IOException, XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {

        System.out.println("[INFO] " + KorisnikRepository.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;


        System.out.println("[INFO] Using defaults.");
        collectionId = "/db/sample/library";
        xqueryFilePath = ".//src//main//java//resources//query//query-log.xqy";


        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- xQuery file path: " + xqueryFilePath);

        XMLResourcesDB resourcesDb = this.connection.run("korisnici.xml");


        Collection col = null;

        try {

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = resourcesDb.getCollection();

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
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            while(i.hasMoreResources()) {

                try {
                    res = i.nextResource();
                    XMLResource xmlResource = (XMLResource)res;
                    Korisnik k = (Korisnik)unmarshaller.unmarshal(xmlResource.getContentAsDOM());
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



    private Document dodajMetaPodatke(Document doktument) {
        generator.dodajMetaPodatkeKorisniku(doktument);

        return doktument;
    }



    private String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);

    }


    public Korisnik getUserById(String idOsiguranika) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, XMLDBException {
        //vracamo korisnika po id-u

        System.out.println("[INFO] " + KorisnikRepository.class.getSimpleName());

        // initialize collection and document identifiers
        String collectionId = null;
        String xqueryFilePath = null, xqueryExpression = null;

        System.out.println("[INFO] Using defaults.");
        collectionId = "/db/sample/library";
        xqueryFilePath = ".//src//main//ftn.xml.ServisOrganVlasti//resources//query//getUserById.xqy";

        System.out.println("\t- collection ID: " + collectionId);
        System.out.println("\t- xQuery file path: " + xqueryFilePath);

        XMLResourcesDB resourcesDb = this.connection.run("korisnici.xml");

        Collection col = null;

        try {

            // get the collection
            System.out.println("[INFO] Retrieving the collection: " + collectionId);
            col = resourcesDb.getCollection();

            // get an instance of xquery service
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            xqueryService.setProperty("indent", "yes");

            // read xquery
            System.out.println("[INFO] Invoking XQuery service for: " + xqueryFilePath);

            xqueryExpression = String.format(this.readFile(xqueryFilePath), idOsiguranika);
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

    }
}
