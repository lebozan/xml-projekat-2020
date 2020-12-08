package ftn.xml.XmlProjekat.util;

import jdk.internal.org.xml.sax.ErrorHandler;
import jdk.internal.org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Document;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;


import org.springframework.stereotype.Component;

import java.io.*;
@Component
public class DOMParser  implements ErrorHandler {
    Logger logger = LoggerFactory.getLogger(DOMParser.class);


    public Document buildDocument(String xmlResource, String schemaPath) throws SAXException,
            ParserConfigurationException, IOException, org.xml.sax.SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler((org.xml.sax.ErrorHandler) this);

        Document document;

        InputStream targetStream = new ByteArrayInputStream(xmlResource.getBytes());
        document = builder.parse(targetStream);

        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory sFactory = SchemaFactory.newInstance(language);
            schema = sFactory.newSchema(new File(schemaPath));
        } catch (Exception e) {
            logger.error("Error parsing schema!");
            logger.trace(e.toString());
        }

        assert schema != null;
        Validator validator = schema.newValidator();
        validator.setErrorHandler((org.xml.sax.ErrorHandler) this);

        validator.validate(new DOMSource(document));
        if (document != null)
            logger.info("File parsed with no errors.");
        return document;
    }

    public String DOMToXML(Document document) throws TransformerException {
        StringWriter sw = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(document), new StreamResult(sw));
        return sw.toString();


    }

    @Override
    public void warning(jdk.internal.org.xml.sax.SAXParseException e) throws SAXException {
        logger.error("Error with parsing.");
        logger.trace(e.toString());
    }

    @Override
    public void error(jdk.internal.org.xml.sax.SAXParseException e) throws SAXException {
        logger.error("Error with parsing.");
        logger.trace(e.toString());
        throw e;
    }

    @Override
    public void fatalError(jdk.internal.org.xml.sax.SAXParseException e) throws SAXException {
        logger.error("Error with parsing.");
        logger.trace(e.toString());
        throw e;
    }
}
