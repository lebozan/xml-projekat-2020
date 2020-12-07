package ftn.xml.XmlProjekat.model.zalbanaodluku;

import javax.xml.bind.annotation.XmlElement;

public class ParagrafPodaci {
    private String datum;
    private String razlog;

    public String getDatum() {
        return datum;
    }

    @XmlElement(name = "datum")
    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getRazlog() {
        return razlog;
    }

    @XmlElement(name = "razlog")
    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }
}
