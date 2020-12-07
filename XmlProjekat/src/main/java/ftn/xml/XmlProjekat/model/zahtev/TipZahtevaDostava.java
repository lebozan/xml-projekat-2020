package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipZahtevaDostava {

    private String tekst;
    private String[] vrsteDostave;

    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String[] getVrsteDostave() {
        return vrsteDostave;
    }

    @XmlElementWrapper(name = "vrste_dostave")
    @XmlElement(name = "dostava")
    public void setVrsteDostave(String[] vrsteDostave) {
        this.vrsteDostave = vrsteDostave;
    }
}
