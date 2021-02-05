package ftn.xml.ServisPoverenik.model.zalbanaodluku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@XmlType(name = "podaci", propOrder = {
        "ime",
        "prezime",
        "datum_podnosenja",
        "drugi_podaci_kontakt",
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Podaci {

    private String ime;
    private String prezime;
    private String datum_podnosenja;
    private String drugi_podaci_kontakt;

    public String getIme() {
        return ime;
    }

    @XmlElement(name = "ime")
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @XmlElement(name = "prezime")
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    public String getDatumPodnosenja() {
        return datum_podnosenja;
    }

    @XmlElement(name = "datum_podnosenja")
    public void setDatumPodnosenja(String datumPodnosenja) {
        this.datum_podnosenja = datumPodnosenja;
    }


    public String getDrugiPodaciKontakt() {
        return drugiPodaciKontakt;
    }

    @XmlElement(name = "drugi_podaci_kontakt")
    public void setDrugiPodaciKontakt(String drugiPodaciKontakt) {
        this.drugiPodaciKontakt = drugiPodaciKontakt;
    }

}
