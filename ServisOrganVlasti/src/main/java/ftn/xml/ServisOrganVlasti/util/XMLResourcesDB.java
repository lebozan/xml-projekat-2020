package ftn.xml.ServisOrganVlasti.util;

import org.xmldb.api.base.Collection;
import org.xmldb.api.modules.XMLResource;

public class XMLResourcesDB {
    private Collection collection;
    private XMLResource xmlResource;

    public XMLResourcesDB() {

    }

    public XMLResourcesDB(Collection collection, XMLResource xmlResource) {
        this.collection = collection;
        this.xmlResource = xmlResource;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public XMLResource getXmlResource() {
        return xmlResource;
    }

    public void setXmlResource(XMLResource xmlResource) {
        this.xmlResource = xmlResource;
    }
}
