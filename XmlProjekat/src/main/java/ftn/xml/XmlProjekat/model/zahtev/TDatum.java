package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TDatum {


    private String dan;
    private String mesec;
    private String godina;


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
}
