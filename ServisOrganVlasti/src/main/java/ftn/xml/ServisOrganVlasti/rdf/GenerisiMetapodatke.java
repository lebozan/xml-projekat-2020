package ftn.xml.ServisOrganVlasti.rdf;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
@Component
public class GenerisiMetapodatke {
    public Document dodajMetaPodatkeKorisniku(Document dokument) {
        Element root = dokument.getDocumentElement();

        NodeList elementi = root.getChildNodes();
        System.out.println(elementi.getLength());
        Element element;
        int count = 0;
        for (int i = 0; i < elementi.getLength()&& count < 1; i++) {
            System.out.println("aaa");
            try {
                if(elementi.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    element = (Element) elementi.item(i);
                    System.out.println(element.getNamespaceURI());
                    switch (element.getLocalName()) {

                        case "jmbg":
                            element.setAttribute("property", "voc:jmbg");
                            element.setAttribute("datatype", "xs:string");
                            ++count;
                            break;


                    }}
            } catch (Exception ignored) {
                System.out.println(ignored);
            }

        }
        return dokument;
    }}

