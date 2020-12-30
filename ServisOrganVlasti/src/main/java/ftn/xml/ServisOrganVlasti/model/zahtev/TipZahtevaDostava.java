package ftn.xml.ServisOrganVlasti.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tekst", "vrsteDostave"})
public class TipZahtevaDostava {

    private String tekst;
    private String[] vrsteDostave;

    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String[] getVrsteDostave() {
        return vrsteDostave;
    }

    @XmlElementWrapper(name = "vrste_dostave", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    @XmlElement(name = "dostava", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setVrsteDostave(String[] vrsteDostave) {
        this.vrsteDostave = vrsteDostave;
    }
}
