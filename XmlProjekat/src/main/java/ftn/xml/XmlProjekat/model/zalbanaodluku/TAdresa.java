package ftn.xml.XmlProjekat.model.zalbanaodluku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAdresa {
    private String ulica;
    private String broj;
    private String grad;

    public String getUlica() {
        return ulica;
    }

    @XmlElement(name = "ulica")
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    @XmlElement(name = "broj")
    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getGrad() {
        return grad;
    }

    @XmlElement(name = "grad")
    public void setGrad(String grad) {
        this.grad = grad;
    }
}
