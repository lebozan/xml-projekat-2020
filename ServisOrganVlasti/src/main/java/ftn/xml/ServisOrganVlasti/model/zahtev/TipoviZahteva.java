package ftn.xml.ServisOrganVlasti.model.zahtev;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"tipZahteva", "tipZahtevaDostava"})
public class TipoviZahteva {

    private String[] tipZahteva;
    private TipZahtevaDostava tipZahtevaDostava;

    public String[] getTipZahteva() {
        return tipZahteva;
    }

    @XmlElement(name = "tip_zahteva", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTipZahteva(String[] tipZahteva) {
        this.tipZahteva = tipZahteva;
    }

    public TipZahtevaDostava getTipZahtevaDostava() {
        return tipZahtevaDostava;
    }

    @XmlElement(name = "tip_zahteva_dostava", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setTipZahtevaDostava(TipZahtevaDostava tipZahtevaDostava) {
        this.tipZahtevaDostava = tipZahtevaDostava;
    }
}
