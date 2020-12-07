package ftn.xml.XmlProjekat.model.zalbanaodluku;

import javax.xml.bind.annotation.XmlElement;

public class TPodnosilacZalbe {
    private String ime;
    private String prezime;
    private TAdresa adresaPodnosioca;

    public String getIme() {
        return ime;
    }

    @XmlElement(name = "ime")
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @XmlElement(name = "prezime")
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public TAdresa getAdresaPodnosioca() {
        return adresaPodnosioca;
    }

    @XmlElement(name = "adresa_podnosioca")
    public void setAdresaPodnosioca(TAdresa adresaPodnosioca) {
        this.adresaPodnosioca = adresaPodnosioca;
    }
}
