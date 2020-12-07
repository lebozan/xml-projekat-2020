package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement(name="zahtev_za_pristup_informacijama")
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

    @XmlElement(name = "zaglavlje")
    public void setZaglavlje(Zaglavlje zaglavlje) {
        this.zaglavlje = zaglavlje;
    }

    public String getNaslov() {
        return naslov;
    }

    @XmlElement(name = "naslov")
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    @XmlElement(name = "sadrzaj")
    public void setSadrzaj(Sadrzaj sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public InformacijeTrazioca getInformacijeTrazioca() {
        return informacijeTrazioca;
    }

    @XmlElement(name = "informacije_trazioca")
    public void setInformacijeTrazioca(InformacijeTrazioca informacijeTrazioca) {
        this.informacijeTrazioca = informacijeTrazioca;
    }

    public MestoIDatum getMestoIDatum() {
        return mestoIDatum;
    }

    @XmlElement(name = "mesto_i_datum")
    public void setMestoIDatum(MestoIDatum mestoIDatum) {
        this.mestoIDatum = mestoIDatum;
    }

    public String[] getFusnote() {
        return fusnote;
    }

    @XmlElementWrapper(name = "fusnote")
    @XmlElement(name = "fusnota")
    public void setFusnote(String[] fusnote) {
        this.fusnote = fusnote;
    }
}
