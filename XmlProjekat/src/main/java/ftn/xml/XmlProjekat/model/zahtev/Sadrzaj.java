package ftn.xml.XmlProjekat.model.zahtev;

import javax.xml.bind.annotation.XmlElement;

public class Sadrzaj {

    private String tekst;

    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
