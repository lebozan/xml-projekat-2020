package ftn.xml.ServisPoverenik.model.zalbanaodluku;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "zalbaNaOdluku"
})
@XmlRootElement(name = "zalbeNaOdluku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZalbeNaOdluku {

    @XmlElement(namespace = "http://www.ftn.un.ac.rs/zalbaNaOdluku")
    protected List<ZalbaNaOdluku> zalbaNaOdluku;

    
    public List<ZalbaNaOdluku> getZalbaNaOdluku() {
        if (zalbaNaOdluku == null) {
            zalbaNaOdluku = new ArrayList<ZalbaNaOdluku>();
        }
        return this.zalbaNaOdluku;
    }

}