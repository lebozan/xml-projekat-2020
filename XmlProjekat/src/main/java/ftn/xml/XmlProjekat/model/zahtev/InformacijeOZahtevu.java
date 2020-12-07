package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tekst", "opisZahteva"})
public class InformacijeOZahtevu {

    private String tekst;
    private String opisZahteva;

    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getOpisZahteva() {
        return opisZahteva;
    }

    @XmlElement(name = "opis_zahteva", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setOpisZahteva(String opisZahteva) {
        this.opisZahteva = opisZahteva;
    }
}
