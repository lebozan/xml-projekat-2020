package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Zaglavlje {


    private Organ organ;

    public Organ getOrgan() {
        return organ;
    }

    @XmlElement(name = "organ")
    public void setOrgan(Organ organ) {
        this.organ = organ;
    }
}
