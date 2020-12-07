package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sadrzaj {

    private String tekst;
    private TipoviZahteva tipoviZahteva;
    private InformacijeOZahtevu informacijeOZahtevu;


    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public TipoviZahteva getTipoviZahteva() {
        return tipoviZahteva;
    }

    @XmlElement(name = "tipovi_zahteva")
    public void setTipoviZahteva(TipoviZahteva tipoviZahteva) {
        this.tipoviZahteva = tipoviZahteva;
    }

    public InformacijeOZahtevu getInformacijeOZahtevu() {
        return informacijeOZahtevu;
    }

    @XmlElement(name = "informacije_o_zahtevu")
    public void setInformacijeOZahtevu(InformacijeOZahtevu informacijeOZahtevu) {
        this.informacijeOZahtevu = informacijeOZahtevu;
    }
}
