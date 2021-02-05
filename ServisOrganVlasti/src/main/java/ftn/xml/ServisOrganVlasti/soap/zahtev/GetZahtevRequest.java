package ftn.xml.ServisOrganVlasti.soap.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"id"}
)
@XmlRootElement(
        name = "getZahtevRequest"
)
public class GetZahtevRequest {
    @XmlElement(
            required = true
    )
    protected String id;

    public GetZahtevRequest() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String value) {
        this.id = value;
    }
}