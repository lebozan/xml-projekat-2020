package ftn.xml.XmlProjekat.model.zahtev;


import javax.xml.bind.annotation.XmlElement;

public class MestoIDatum {


    private String tekst;
    private String mesto;
    private TDatum datum;


    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getMesto() {
        return mesto;
    }

    @XmlElement(name = "mesto")
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public TDatum getDatum() {
        return datum;
    }

    @XmlElement(name = "datum")
    public void setDatum(TDatum datum) {
        this.datum = datum;
    }
}
