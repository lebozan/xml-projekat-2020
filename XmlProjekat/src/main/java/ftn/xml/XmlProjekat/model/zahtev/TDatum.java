package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TDatum {

    private String tekstDan;
    private String dan;
    private String mesec;
    private String godina;
    private String tekstGodina;


    public String getTekstDan() {
        return tekstDan;
    }

    @XmlElement(name = "tekst_dan")
    public void setTekstDan(String tekstDan) {
        this.tekstDan = tekstDan;
    }

    public String getDan() {
        return dan;
    }

    @XmlElement(name = "dan")
    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getMesec() {
        return mesec;
    }

    @XmlElement(name = "mesec")
    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getGodina() {
        return godina;
    }

    @XmlElement(name = "godina")
    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getTekstGodina() {
        return tekstGodina;
    }

    @XmlElement(name = "tekst_godina")
    public void setTekstGodina(String tekstGodina) {
        this.tekstGodina = tekstGodina;
    }
}
