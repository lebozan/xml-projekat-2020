//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.03 at 09:16:20 PM CET 
//


package ftn.xml.ServisOrganVlasti.model.zahtev;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.zahtev package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TDatumGodina_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "godina");
    private final static QName _TDatumDan_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "dan");
    private final static QName _TDatumMesec_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "mesec");
    private final static QName _ZahtevZaPristupInformacijamaMestoIDatumMesto_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "mesto");
    private final static QName _ZahtevZaPristupInformacijamaMestoIDatumDatum_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "datum");
    private final static QName _ZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahtevaDostava_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "tip_zahteva_dostava");
    private final static QName _ZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahteva_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "tip_zahteva");
    private final static QName _TInformacijeOZahtevuOpisZahteva_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "opis_zahteva");
    private final static QName _ZahtevZaPristupInformacijamaFusnoteFusnota_QNAME = new QName("http://www.ftn.uns.ac.rs/zahtev", "fusnota");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.zahtev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama }
     * 
     */
    public ZahtevZaPristupInformacijama createZahtevZaPristupInformacijama() {
        return new ZahtevZaPristupInformacijama();
    }

    /**
     * Create an instance of {@link TDostava }
     * 
     */
    public TDostava createTDostava() {
        return new TDostava();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.InformacijeTrazioca }
     * 
     */
    public ZahtevZaPristupInformacijama.InformacijeTrazioca createZahtevZaPristupInformacijamaInformacijeTrazioca() {
        return new ZahtevZaPristupInformacijama.InformacijeTrazioca();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Sadrzaj }
     * 
     */
    public ZahtevZaPristupInformacijama.Sadrzaj createZahtevZaPristupInformacijamaSadrzaj() {
        return new ZahtevZaPristupInformacijama.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva }
     * 
     */
    public ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva createZahtevZaPristupInformacijamaSadrzajTipoviZahteva() {
        return new ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Zaglavlje }
     * 
     */
    public ZahtevZaPristupInformacijama.Zaglavlje createZahtevZaPristupInformacijamaZaglavlje() {
        return new ZahtevZaPristupInformacijama.Zaglavlje();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.MestoIDatum }
     * 
     */
    public ZahtevZaPristupInformacijama.MestoIDatum createZahtevZaPristupInformacijamaMestoIDatum() {
        return new ZahtevZaPristupInformacijama.MestoIDatum();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Fusnote }
     * 
     */
    public ZahtevZaPristupInformacijama.Fusnote createZahtevZaPristupInformacijamaFusnote() {
        return new ZahtevZaPristupInformacijama.Fusnote();
    }

    /**
     * Create an instance of {@link TInformacijeOZahtevu }
     * 
     */
    public TInformacijeOZahtevu createTInformacijeOZahtevu() {
        return new TInformacijeOZahtevu();
    }

    /**
     * Create an instance of {@link TDatum }
     * 
     */
    public TDatum createTDatum() {
        return new TDatum();
    }

    /**
     * Create an instance of {@link TDostava.Dostava }
     * 
     */
    public TDostava.Dostava createTDostavaDostava() {
        return new TDostava.Dostava();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.InformacijeTrazioca.Ime }
     * 
     */
    public ZahtevZaPristupInformacijama.InformacijeTrazioca.Ime createZahtevZaPristupInformacijamaInformacijeTraziocaIme() {
        return new ZahtevZaPristupInformacijama.InformacijeTrazioca.Ime();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.InformacijeTrazioca.Prezime }
     * 
     */
    public ZahtevZaPristupInformacijama.InformacijeTrazioca.Prezime createZahtevZaPristupInformacijamaInformacijeTraziocaPrezime() {
        return new ZahtevZaPristupInformacijama.InformacijeTrazioca.Prezime();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.InformacijeTrazioca.Adresa }
     * 
     */
    public ZahtevZaPristupInformacijama.InformacijeTrazioca.Adresa createZahtevZaPristupInformacijamaInformacijeTraziocaAdresa() {
        return new ZahtevZaPristupInformacijama.InformacijeTrazioca.Adresa();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.InformacijeTrazioca.KontaktPodaci }
     * 
     */
    public ZahtevZaPristupInformacijama.InformacijeTrazioca.KontaktPodaci createZahtevZaPristupInformacijamaInformacijeTraziocaKontaktPodaci() {
        return new ZahtevZaPristupInformacijama.InformacijeTrazioca.KontaktPodaci();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava }
     * 
     */
    public ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava createZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahtevaDostava() {
        return new ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava();
    }

    /**
     * Create an instance of {@link ZahtevZaPristupInformacijama.Zaglavlje.Organ }
     * 
     */
    public ZahtevZaPristupInformacijama.Zaglavlje.Organ createZahtevZaPristupInformacijamaZaglavljeOrgan() {
        return new ZahtevZaPristupInformacijama.Zaglavlje.Organ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "godina", scope = TDatum.class)
    public JAXBElement<String> createTDatumGodina(String value) {
        return new JAXBElement<String>(_TDatumGodina_QNAME, String.class, TDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "dan", scope = TDatum.class)
    public JAXBElement<String> createTDatumDan(String value) {
        return new JAXBElement<String>(_TDatumDan_QNAME, String.class, TDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "mesec", scope = TDatum.class)
    public JAXBElement<String> createTDatumMesec(String value) {
        return new JAXBElement<String>(_TDatumMesec_QNAME, String.class, TDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "mesto", scope = ZahtevZaPristupInformacijama.MestoIDatum.class)
    public JAXBElement<String> createZahtevZaPristupInformacijamaMestoIDatumMesto(String value) {
        return new JAXBElement<String>(_ZahtevZaPristupInformacijamaMestoIDatumMesto_QNAME, String.class, ZahtevZaPristupInformacijama.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDatum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "datum", scope = ZahtevZaPristupInformacijama.MestoIDatum.class)
    public JAXBElement<TDatum> createZahtevZaPristupInformacijamaMestoIDatumDatum(TDatum value) {
        return new JAXBElement<TDatum>(_ZahtevZaPristupInformacijamaMestoIDatumDatum_QNAME, TDatum.class, ZahtevZaPristupInformacijama.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "tip_zahteva_dostava", scope = ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.class)
    public JAXBElement<ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava> createZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahtevaDostava(ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava value) {
        return new JAXBElement<ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava>(_ZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahtevaDostava_QNAME, ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.TipZahtevaDostava.class, ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "tip_zahteva", scope = ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.class)
    public JAXBElement<String> createZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahteva(String value) {
        return new JAXBElement<String>(_ZahtevZaPristupInformacijamaSadrzajTipoviZahtevaTipZahteva_QNAME, String.class, ZahtevZaPristupInformacijama.Sadrzaj.TipoviZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "opis_zahteva", scope = TInformacijeOZahtevu.class)
    public JAXBElement<String> createTInformacijeOZahtevuOpisZahteva(String value) {
        return new JAXBElement<String>(_TInformacijeOZahtevuOpisZahteva_QNAME, String.class, TInformacijeOZahtevu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zahtev", name = "fusnota", scope = ZahtevZaPristupInformacijama.Fusnote.class)
    public JAXBElement<String> createZahtevZaPristupInformacijamaFusnoteFusnota(String value) {
        return new JAXBElement<String>(_ZahtevZaPristupInformacijamaFusnoteFusnota_QNAME, String.class, ZahtevZaPristupInformacijama.Fusnote.class, value);
    }

}
