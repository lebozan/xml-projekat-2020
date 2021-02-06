package ftn.xml.ServisPoverenik.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Configuration
public class ZalbaNaOdlukuXSLTransformer {

    private static DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public ZahtevXSLTransformer() {
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);
    }

    private org.w3c.dom.Document buildDocument(String xml) {

        org.w3c.dom.Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            InputStream targetStream = new ByteArrayInputStream(xml.getBytes());
            document = builder.parse(targetStream);

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;

        }

        return document;
    }


    public void generateXML(String xml) throws FileNotFoundException {

        try {

            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File("src/main/resources/xmlFiles/xsl/zalbaNaOdluku.xsl"));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(xml));
            StreamResult result = new StreamResult(new FileOutputStream("src/main/resources/xmlFiles/xhtml/zalbaNaOdluku.xml"));
            transformer.transform(source, result);


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


}
