package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organ {

    private String nazivOrgana;

    private String sedisteOrgana;

    public String getNazivOrgana() {
        return nazivOrgana;
    }

    @XmlElement(name = "naziv_organa")
    public void setNazivOrgana(String nazivOrgana) {
        this.nazivOrgana = nazivOrgana;
    }

    public String getSedisteOrgana() {
        return sedisteOrgana;
    }

    @XmlElement(name = "sediste_organa")
    public void setSedisteOrgana(String sedisteOrgana) {
        this.sedisteOrgana = sedisteOrgana;
    }
}
