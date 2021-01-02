package ftn.xml.ServisOrganVlasti.model.zalbanaodluku;

import javax.xml.bind.annotation.XmlElement;

public class ZalbaZaglavlje {
    
    private String naslov;
    private String primalac;
    private String adresaPrimaoca;

    public String getNaslov() {
        return naslov;
    }

    @XmlElement(name = "naslov")
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPrimalac() {
        return primalac;
    }

    @XmlElement(name = "primalac")
    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getAdresaPrimaoca() {
        return adresaPrimaoca;
    }

    @XmlElement(name = "adresa_primaoca")
    public void setAdresaPrimaoca(String adresaPrimaoca) {
        this.adresaPrimaoca = adresaPrimaoca;
    }
}
