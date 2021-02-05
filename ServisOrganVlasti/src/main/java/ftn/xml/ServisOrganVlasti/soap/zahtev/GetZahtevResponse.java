package ftn.xml.ServisOrganVlasti.soap.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"zahtevZaPristupInformacijama"}
)
@XmlRootElement(
        name = "getZahtevResponse"
)
public class GetZahtevResponse {
    @XmlElement(
            name = "zahtev_za_pristup_informacijama",
            namespace = "http://www.ftn.uns.ac.rs/zahtev",
            required = true
    )
    protected ZahtevZaPristupInformacijama zahtevZaPristupInformacijama;

    public GetZahtevResponse() {
    }

    public ZahtevZaPristupInformacijama getZahtevZaPristupInformacijama() {
        return this.zahtevZaPristupInformacijama;
    }

    public void setZahtevZaPristupInformacijama(ZahtevZaPristupInformacijama value) {
        this.zahtevZaPristupInformacijama = value;
    }

}