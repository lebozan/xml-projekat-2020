package ftn.xml.ServisOrganVlasti.model.zalbanaodluku;

import javax.xml.bind.annotation.XmlElement;

public class Paragrafi {
    
    private ParagrafPodaci paragrafPodaci;
    private String[] paragraf;

    public ParagrafPodaci getParagrafPodaci() {
        return paragrafPodaci;
    }

    @XmlElement(name = "paragraf_podaci")
    public void setParagrafPodaci(ParagrafPodaci paragrafPodaci) {
        this.paragrafPodaci = paragrafPodaci;
    }

    public String[] getParagraf() {
        return paragraf;
    }

    @XmlElement(name = "paragraf")
    public void setParagraf(String[] paragraf) {
        this.paragraf = paragraf;
    }
}
