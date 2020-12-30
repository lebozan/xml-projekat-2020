package ftn.xml.ServisOrganVlasti.model.zahtev;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tekst", "mesto", "datum"})
public class MestoIDatum {


    private String tekst;
    private String mesto;
    private TDatum datum;


    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getMesto() {
        return mesto;
    }

    @XmlElement(name = "mesto", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public TDatum getDatum() {
        return datum;
    }

    @XmlElement(name = "datum", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setDatum(TDatum datum) {
        this.datum = datum;
    }
}
