package ftn.xml.ServisOrganVlasti.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tekst", "tipoviZahteva", "informacijeOZahtevu"})
public class Sadrzaj {

    private String tekst;
    private TipoviZahteva tipoviZahteva;
    private InformacijeOZahtevu informacijeOZahtevu;


    public String getTekst() {
        return tekst;
    }

    @XmlElement(name = "tekst", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public TipoviZahteva getTipoviZahteva() {
        return tipoviZahteva;
    }

    @XmlElement(name = "tipovi_zahteva", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTipoviZahteva(TipoviZahteva tipoviZahteva) {
        this.tipoviZahteva = tipoviZahteva;
    }

    public InformacijeOZahtevu getInformacijeOZahtevu() {
        return informacijeOZahtevu;
    }

    @XmlElement(name = "informacije_o_zahtevu", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setInformacijeOZahtevu(InformacijeOZahtevu informacijeOZahtevu) {
        this.informacijeOZahtevu = informacijeOZahtevu;
    }
}
