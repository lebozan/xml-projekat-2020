package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement(name="zahtev_za_pristup_informacijama", namespace = "http://www.ftn.uns.ac.rs/zahtev")
@XmlType(propOrder = {"zaglavlje", "naslov", "sadrzaj", "informacijeTrazioca", "mestoIDatum", "fusnote"})
public class ZahtevZaPristupInformacijama {


    private Zaglavlje zaglavlje;
    private String naslov;
    private Sadrzaj sadrzaj;
    private InformacijeTrazioca informacijeTrazioca;
    private MestoIDatum mestoIDatum;
    private String[] fusnote;


    public Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    @XmlElement(name = "zaglavlje", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setZaglavlje(Zaglavlje zaglavlje) {
        this.zaglavlje = zaglavlje;
    }

    public String getNaslov() {
        return naslov;
    }

    @XmlElement(name = "naslov", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    @XmlElement(name = "sadrzaj", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setSadrzaj(Sadrzaj sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public InformacijeTrazioca getInformacijeTrazioca() {
        return informacijeTrazioca;
    }

    @XmlElement(name = "informacije_trazioca", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setInformacijeTrazioca(InformacijeTrazioca informacijeTrazioca) {
        this.informacijeTrazioca = informacijeTrazioca;
    }

    public MestoIDatum getMestoIDatum() {
        return mestoIDatum;
    }

    @XmlElement(name = "mesto_i_datum", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setMestoIDatum(MestoIDatum mestoIDatum) {
        this.mestoIDatum = mestoIDatum;
    }

    public String[] getFusnote() {
        return fusnote;
    }

    @XmlElementWrapper(name = "fusnote", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    @XmlElement(name = "fusnota", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setFusnote(String[] fusnote) {
        this.fusnote = fusnote;
    }
}
