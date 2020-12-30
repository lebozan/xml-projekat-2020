package ftn.xml.ServisOrganVlasti.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tekstDan", "dan", "mesec", "godina", "tekstGodina"})
public class TDatum {

    private String tekstDan;
    private String dan;
    private String mesec;
    private String godina;
    private String tekstGodina;


    public String getTekstDan() {
        return tekstDan;
    }

    @XmlElement(name = "tekst_dan", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekstDan(String tekstDan) {
        this.tekstDan = tekstDan;
    }

    public String getDan() {
        return dan;
    }

    @XmlElement(name = "dan", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getMesec() {
        return mesec;
    }

    @XmlElement(name = "mesec", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getGodina() {
        return godina;
    }

    @XmlElement(name = "godina", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getTekstGodina() {
        return tekstGodina;
    }

    @XmlElement(name = "tekst_godina", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekstGodina(String tekstGodina) {
        this.tekstGodina = tekstGodina;
    }
}
