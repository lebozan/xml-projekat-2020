package ftn.xml.ServisPoverenik.model.zalbanaodluku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;


@XmlType(name = "ZalbaSadrzaj", propOrder = {
        "podnosilacZalbe",
        "naziv_organa_vlasti",
        "broj_zalbe",
        "godina",
        "paragrafi",
        "podaci"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZalbaSadrzaj {
    
    private TPodnosilacZalbe podnosilacZalbe;
    private String naziv_organa_vlasti;
    private String broj_zalbe;
    private String godina;
    private Paragrafi paragrafi;
    private Podaci podaci;

    public TPodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    @XmlElement(name = "podnosilac_zalbe")
    public void setPodnosilacZalbe(TPodnosilacZalbe podnosilacZalbe) {
        this.podnosilacZalbe = podnosilacZalbe;
    }

    public String getNazivOrganaVlasti() {
        return naziv_organa_vlasti;
    }

    @XmlElement(name = "naziv_organa_vlasti")
    public void setNazivOrganaVlasti(String naziv_organa_vlasti) {
        this.naziv_organa_vlasti = naziv_organa_vlasti;
    }

    public String getBrojZalbe() {
        return broj_zalbe;
    }

    @XmlElement(name = "broj_zalbe")
    public void setBrojZalbe(String broj_zalbe) {
        this.broj_zalbe = broj_zalbe;
    }

    public String getGodina() {
        return godina;
    }

    @XmlElement(name = "godina")
    public void setGodina(String godina) {
        this.godina = godina;
    }

    public Paragrafi getParagrafi(){
        return paragrafi;
    }

    @XmlElement(name = "paragrafi")
    public void setParagrafi(Paragrafi paragrafi) {
        this.paragrafi = paragrafi;
    }

    public Podaci getPodaci(){
        return podaci;
    }

    @XmlElement(name = "podaci")
    public void setPodaci(Podaci podaci) {
        this.podaci = podaci;
    }
}
