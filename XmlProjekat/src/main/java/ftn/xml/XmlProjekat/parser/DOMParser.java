package ftn.xml.XmlProjekat.parser;

import ftn.xml.XmlProjekat.model.zahtev.*;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

@Component
public class DOMParser {

    public static void ReadXmlFile(String filePath) throws Exception {

        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        Node zaglavlje = doc.getElementsByTagName("zaglavlje").item(0);


        NodeList nodeList = doc.getElementsByTagName("datum");
//
//
//        TDatum datum = (TDatum) nodeList.item(0);
//        datum.setDan("5");
//        datum.setMesec("12");
//        datum.setGodina("2020");


//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        // for pretty print
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//
//        // write to console or file
//        StreamResult console = new StreamResult(System.out);
//        StreamResult file = new StreamResult(new File("resources/test.xml"));
//
//        // write data
//        transformer.transform(new DOMSource(doc), file);
    }

    public static void ReadXmlJaxb(String filePath) throws Exception {

        // XML file path
        File xml = new File(filePath);

        // create an instance of `JAXBContext`
        JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

        // create an instance of `Unmarshaller`
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // convert XML file to object
        ZahtevZaPristupInformacijama zahtevZaPristupInformacijama = (ZahtevZaPristupInformacijama) unmarshaller.unmarshal(xml);

        // print object
        System.out.println(zahtevZaPristupInformacijama);

    }

    public static void WriteXmlJaxb() throws Exception {
        // create XML file
        File file = new File("src/main/resources/test.xml");

        // create an instance of `JAXBContext`
        JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();

        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ZahtevZaPristupInformacijama zahtevZaPristupInformacijama = new ZahtevZaPristupInformacijama();


        String[] fusnote = new String[3];
        fusnote[0] = "1";
        fusnote[1] = "1";
        fusnote[2] = "1";

        zahtevZaPristupInformacijama.setFusnote(fusnote);


        zahtevZaPristupInformacijama.setMestoIDatum(new MestoIDatum("tekst", "mesto",
                new TDatum("dana", "01", "05", "2020", "godine")));

        zahtevZaPristupInformacijama.setInformacijeTrazioca(
                new InformacijeTrazioca("ime", "prezime", "adresa", "kontakt", "potpis"));

        String[] tipoviZahteva = new String[3];
        tipoviZahteva[0] = "tip z1";
        tipoviZahteva[1] = "tip z2";
        tipoviZahteva[2] = "tip z3";

        String[] vrsteDostave = new String[4];
        vrsteDostave[0] = "tip dostave 1";
        vrsteDostave[1] = "tip dostave 2";
        vrsteDostave[2] = "tip dostave 3";
        vrsteDostave[2] = "tip dostave 4";

        zahtevZaPristupInformacijama.setSadrzaj(new Sadrzaj("tekst",
                new TipoviZahteva(tipoviZahteva, new TipZahtevaDostava("tekst", vrsteDostave)),
                new InformacijeOZahtevu("tekst", "opis zahteva")));

        zahtevZaPristupInformacijama.setNaslov("naslov dokumenta");

        zahtevZaPristupInformacijama.setZaglavlje(new Zaglavlje(new Organ("naziv", "sediste")));


        // convert user object to XML file
        marshaller.marshal(zahtevZaPristupInformacijama, file);
    }
}
