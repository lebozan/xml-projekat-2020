package ftn.xml.ServisPoverenik.model.zalbanaodluku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;


@XmlType(name = "ParagrafPodaci", propOrder = {
    "datum",
    "razlog"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParagrafPodaci {
    private String datum;
    private String razlog;

    public String getDatum() {
        return datum;
    }

    @XmlElement(name = "datum")
    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getRazlog() {
        return razlog;
    }

    @XmlElement(name = "razlog")
    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }
}
