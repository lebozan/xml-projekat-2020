package ftn.xml.XmlProjekat.model.zalbanaodluku;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="zalba_na_odluku")
public class ZalbaNaOdluku {
    
    private ZalbaZaglavlje zaglavlje;
    private ZalbaSadrzaj zalbaSadrzaj;
    private String[] napomene;


    public ZalbaZaglavlje getZaglavlje() {
        return zaglavlje;
    }

    @XmlElement(name = "zaglavlje")
    public void setZaglavlje(ZalbaZaglavlje zaglavlje) {
        this.zaglavlje = zaglavlje;
    }

    public ZalbaSadrzaj getZalbaSadrzaj() {
        return zalbaSadrzaj;
    }

    @XmlElement(name = "zalba_sadrzaj")
    public void setZalbaSadrzaj(ZalbaSadrzaj zalbaSadrzaj) {
        this.zalbaSadrzaj = zalbaSadrzaj;
    }

    public String[] getNapomene() {
        return napomene;
    }

    @XmlElementWrapper(name = "napomene")
    @XmlElement(name = "napomena")
    public void setNapomene(String[] napomene) {
        this.napomene = napomene;
    }
}
