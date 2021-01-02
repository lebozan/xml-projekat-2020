package ftn.xml.ServisOrganVlasti.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"nazivOrgana", "sedisteOrgana"})
public class Organ {

    private String nazivOrgana;

    private String sedisteOrgana;

    public String getNazivOrgana() {
        return nazivOrgana;
    }

    @XmlElement(name = "naziv_organa", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setNazivOrgana(String nazivOrgana) {
        this.nazivOrgana = nazivOrgana;
    }

    public String getSedisteOrgana() {
        return sedisteOrgana;
    }

    @XmlElement(name = "sediste_organa", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setSedisteOrgana(String sedisteOrgana) {
        this.sedisteOrgana = sedisteOrgana;
    }
}
