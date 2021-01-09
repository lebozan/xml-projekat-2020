//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.08 at 09:04:51 AM CET 
//


package ftn.xml.ServisPoverenik.model.zalbanacutanje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.zalbanacutanje package. 
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

    private final static QName _ZalbaCutanjeSadrzajIzjavaPodaciOZahtevu_QNAME = new QName("http://www.ftn.uns.ac.rs/zalbanacutanje", "podaci_o_zahtevu");
    private final static QName _ZalbaCutanjeSadrzajIzjavaPredlog_QNAME = new QName("http://www.ftn.uns.ac.rs/zalbanacutanje", "predlog");
    private final static QName _ZalbaCutanjeSadrzajIzjavaDatumPodnosenja_QNAME = new QName("http://www.ftn.uns.ac.rs/zalbanacutanje", "datum_podnosenja");
    private final static QName _ZalbaCutanjeSadrzajIzjavaTekst_QNAME = new QName("http://www.ftn.uns.ac.rs/zalbanacutanje", "tekst");
    private final static QName _TRazlogTipRazloga_QNAME = new QName("http://www.ftn.uns.ac.rs/zalbanacutanje", "tip_razloga");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.zalbanacutanje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaCutanje }
     * 
     */
    public ZalbaCutanje createZalbaCutanje() {
        return new ZalbaCutanje();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj }
     * 
     */
    public ZalbaCutanje.Sadrzaj createZalbaCutanjeSadrzaj() {
        return new ZalbaCutanje.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Zaglavlje }
     * 
     */
    public ZalbaCutanje.Zaglavlje createZalbaCutanjeZaglavlje() {
        return new ZalbaCutanje.Zaglavlje();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.MestoPodnosenja }
     * 
     */
    public ZalbaCutanje.MestoPodnosenja createZalbaCutanjeMestoPodnosenja() {
        return new ZalbaCutanje.MestoPodnosenja();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.DatumZalbe }
     * 
     */
    public ZalbaCutanje.DatumZalbe createZalbaCutanjeDatumZalbe() {
        return new ZalbaCutanje.DatumZalbe();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TRazlog }
     * 
     */
    public TRazlog createTRazlog() {
        return new TRazlog();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Predmet }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Predmet createZalbaCutanjeSadrzajPredmet() {
        return new ZalbaCutanje.Sadrzaj.Predmet();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.RazloziPodnsenja }
     * 
     */
    public ZalbaCutanje.Sadrzaj.RazloziPodnsenja createZalbaCutanjeSadrzajRazloziPodnsenja() {
        return new ZalbaCutanje.Sadrzaj.RazloziPodnsenja();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Izjava }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Izjava createZalbaCutanjeSadrzajIzjava() {
        return new ZalbaCutanje.Sadrzaj.Izjava();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Zaglavlje.Primalac }
     * 
     */
    public ZalbaCutanje.Zaglavlje.Primalac createZalbaCutanjeZaglavljePrimalac() {
        return new ZalbaCutanje.Zaglavlje.Primalac();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", name = "podaci_o_zahtevu", scope = ZalbaCutanje.Sadrzaj.Izjava.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajIzjavaPodaciOZahtevu(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajIzjavaPodaciOZahtevu_QNAME, String.class, ZalbaCutanje.Sadrzaj.Izjava.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", name = "predlog", scope = ZalbaCutanje.Sadrzaj.Izjava.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajIzjavaPredlog(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajIzjavaPredlog_QNAME, String.class, ZalbaCutanje.Sadrzaj.Izjava.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", name = "datum_podnosenja", scope = ZalbaCutanje.Sadrzaj.Izjava.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaCutanjeSadrzajIzjavaDatumPodnosenja(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ZalbaCutanjeSadrzajIzjavaDatumPodnosenja_QNAME, XMLGregorianCalendar.class, ZalbaCutanje.Sadrzaj.Izjava.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", name = "tekst", scope = ZalbaCutanje.Sadrzaj.Izjava.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajIzjavaTekst(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajIzjavaTekst_QNAME, String.class, ZalbaCutanje.Sadrzaj.Izjava.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", name = "tip_razloga", scope = TRazlog.class)
    public JAXBElement<String> createTRazlogTipRazloga(String value) {
        return new JAXBElement<String>(_TRazlogTipRazloga_QNAME, String.class, TRazlog.class, value);
    }

}
