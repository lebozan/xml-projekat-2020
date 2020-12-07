package ftn.xml.XmlProjekat.parser;

import ftn.xml.XmlProjekat.model.zahtev.*;
import ftn.xml.XmlProjekat.model.zahtev.Zaglavlje;
import ftn.xml.XmlProjekat.model.zalbanaodluku.*;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
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

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
        unmarshaller.setSchema(schema);

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


        zahtevZaPristupInformacijama.setZaglavlje(new Zaglavlje(new Organ("naziv", "sediste")));

        zahtevZaPristupInformacijama.setNaslov("naslov dokumenta");

        String[] tipoviZahteva = new String[3];
        tipoviZahteva[0] = "tip z1";
        tipoviZahteva[1] = "tip z2";
        tipoviZahteva[2] = "tip z3";

        String[] vrsteDostave = new String[4];
        vrsteDostave[0] = "tip dostave 1";
        vrsteDostave[1] = "tip dostave 2";
        vrsteDostave[2] = "tip dostave 3";
        vrsteDostave[3] = "tip dostave 4";

        zahtevZaPristupInformacijama.setSadrzaj(new Sadrzaj("tekst",
                new TipoviZahteva(tipoviZahteva, new TipZahtevaDostava("tekst", vrsteDostave)),
                new InformacijeOZahtevu("tekst", "opis zahteva")));


        zahtevZaPristupInformacijama.setInformacijeTrazioca(
                new InformacijeTrazioca("ime", "prezime", "adresa", "kontakt", "potpis"));


        zahtevZaPristupInformacijama.setMestoIDatum(new MestoIDatum("tekst", "mesto",
                new TDatum("дана", "01", "05", "2020", "године")));


        String[] fusnote = new String[3];
        fusnote[0] = "* У кућици означити која законска права на приступ информацијама желите да остварите.";
        fusnote[1] = "** У кућици означити начин достављања копије докумената.";
        fusnote[2] = "*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.";

        zahtevZaPristupInformacijama.setFusnote(fusnote);


        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
        marshaller.setSchema(schema);


        // convert user object to XML file
        marshaller.marshal(zahtevZaPristupInformacijama, file);
    }

    public static void ReadXmlZalbaNaOdluku(String filePath) throws Exception {

        // XML file path
        File xml = new File(filePath);

        // create an instance of `JAXBContext`
        JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);

        // create an instance of `Unmarshaller`
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // convert XML file to object
        ZalbaNaOdluku ZalbaNaOdluku = (ZalbaNaOdluku) unmarshaller.unmarshal(xml);

        // print object
        System.out.println(ZalbaNaOdluku);

    }

    public static void WriteXmlZalbaNaOdluku() throws Exception {
        // create XML file
        File file = new File("src/main/resources/TestZalbaNaOdluku.xml");

        // create an instance of `JAXBContext`
        JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);

        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();

        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ZalbaNaOdluku ZalbaNaOdluku = new ZalbaNaOdluku();

        // Popunjavanje zaglavlja
        ZalbaZaglavlje z = new ZalbaZaglavlje();
        z.setNaslov("naslov");
        z.setPrimalac("primalac");
        z.setAdresaPrimaoca("adresaPrimaoca");
        ZalbaNaOdluku.setZaglavlje(z);

        // Popunjavanje sadrzaja zalbe
        TAdresa adr = new TAdresa("ulica1", "21","Novi Sad");
        TPodnosilacZalbe pz = new TPodnosilacZalbe("Ivko","Ivic",adr);
        Paragrafi pf = new Paragrafi();
        String[] paragraf = new String[3];
        paragraf[0] = "На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.";
        paragraf[1] = "Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.";
        ParagrafPodaci pd = new ParagrafPodaci("1.1.2021","dugacak tekst");
        pf.setParagraf(paragraf);
        pf.setParagrafPodaci(pd);
        Podaci po = new Podaci("ime","prezime","mesto",adr,"danMesec","godina","drugi podaci i kontakt","potpis");
        ZalbaSadrzaj zs = new ZalbaSadrzaj(pz,"naziv organa vlasti", "1001","2021",pf,po);

        ZalbaNaOdluku.setZalbaSadrzaj(zs);

        // Popunjavanje napomena
        String[] napomene = new String[2];
        napomene[0] = "У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити. Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.";
        napomene[1] = "Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.";
        ZalbaNaOdluku.setNapomene(napomene);

        // convert user object to XML file
        marshaller.marshal(ZalbaNaOdluku, file);
    }
}
