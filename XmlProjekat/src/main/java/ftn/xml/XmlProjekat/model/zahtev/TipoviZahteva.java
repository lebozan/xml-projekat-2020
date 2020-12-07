package ftn.xml.XmlProjekat.model.zahtev;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoviZahteva {

    private String[] tipZahteva;
    private TipZahtevaDostava tipZahtevaDostava;

    public String[] getTipZahteva() {
        return tipZahteva;
    }

    @XmlElement(name = "tip_zahteva")
    public void setTipZahteva(String[] tipZahteva) {
        this.tipZahteva = tipZahteva;
    }

    public TipZahtevaDostava getTipZahtevaDostava() {
        return tipZahtevaDostava;
    }

    @XmlElement(name = "tip_zahteva_dostava")
    public void setTipZahtevaDostava(TipZahtevaDostava tipZahtevaDostava) {
        this.tipZahtevaDostava = tipZahtevaDostava;
    }
}
