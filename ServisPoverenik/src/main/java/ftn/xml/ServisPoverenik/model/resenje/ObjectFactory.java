//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.10 at 02:14:43 PM CET 
//


package ftn.xml.ServisPoverenik.model.resenje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.resenje package. 
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

    private final static QName _ResenjeSadrzajDonetoResenje_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "doneto_resenje");
    private final static QName _ResenjeSadrzajObrazlozenje_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "obrazlozenje");
    private final static QName _ResenjeSadrzajUvod_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "uvod");
    private final static QName _ResenjeSadrzajUvodZakonTacka_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "tacka");
    private final static QName _ResenjeSadrzajUvodZakonClan_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "clan");
    private final static QName _ResenjeSadrzajUvodZakonNazivZakona_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "naziv_zakona");
    private final static QName _ResenjeSadrzajUvodZakonStav_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "stav");
    private final static QName _ResenjeSadrzajObrazlozenjeTaksa_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "taksa");
    private final static QName _ResenjeSadrzajObrazlozenjePostupakOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "postupak_organa");
    private final static QName _ResenjeSadrzajObrazlozenjeDatumPodnosenjaZalbe_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "datum_podnosenja_zalbe");
    private final static QName _ResenjeSadrzajObrazlozenjeOdlukaOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "odluka_organa");
    private final static QName _ResenjeSadrzajObrazlozenjeRazlogZalbe_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "razlog_zalbe");
    private final static QName _ResenjeSadrzajObrazlozenjeTrazilacInformacija_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "trazilac_informacija");
    private final static QName _ResenjeZaglavljeBrojResenja_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "broj_resenja");
    private final static QName _ResenjeZaglavljeDatumResenja_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "datum_resenja");
    private final static QName _ResenjeZaglavljeNazivResenja_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "naziv_resenja");
    private final static QName _ResenjeSadrzajDonetoResenjeOdluka_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "odluka");
    private final static QName _ResenjeSadrzajDonetoResenjeTekst_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "tekst");
    private final static QName _ResenjeSadrzajUvodNazivUstanove_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "naziv_ustanove");
    private final static QName _ResenjeSadrzajUvodAdresaUstanove_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "adresa_ustanove");
    private final static QName _ResenjeSadrzajUvodDatumZalbe_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "datum_zalbe");
    private final static QName _ResenjeSadrzajUvodZakon_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "zakon");
    private final static QName _ResenjeSadrzajUvodNazivOrgana_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "naziv_organa");
    private final static QName _ResenjeSadrzajUvodPodnosilac_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "podnosilac");
    private final static QName _ResenjeSadrzaj_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "sadrzaj");
    private final static QName _ResenjePoverenik_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "poverenik");
    private final static QName _ResenjeZaglavlje_QNAME = new QName("http://www.ftn.uns.ac.rs/resenje", "zaglavlje");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.resenje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj }
     * 
     */
    public Resenje.Sadrzaj createResenjeSadrzaj() {
        return new Resenje.Sadrzaj();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Obrazlozenje }
     * 
     */
    public Resenje.Sadrzaj.Obrazlozenje createResenjeSadrzajObrazlozenje() {
        return new Resenje.Sadrzaj.Obrazlozenje();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Uvod }
     * 
     */
    public Resenje.Sadrzaj.Uvod createResenjeSadrzajUvod() {
        return new Resenje.Sadrzaj.Uvod();
    }

    /**
     * Create an instance of {@link Resenje.Zaglavlje }
     * 
     */
    public Resenje.Zaglavlje createResenjeZaglavlje() {
        return new Resenje.Zaglavlje();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.DonetoResenje }
     * 
     */
    public Resenje.Sadrzaj.DonetoResenje createResenjeSadrzajDonetoResenje() {
        return new Resenje.Sadrzaj.DonetoResenje();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija }
     * 
     */
    public Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija createResenjeSadrzajObrazlozenjeTrazilacInformacija() {
        return new Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe }
     * 
     */
    public Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe createResenjeSadrzajObrazlozenjeRazlogZalbe() {
        return new Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Obrazlozenje.Taksa }
     * 
     */
    public Resenje.Sadrzaj.Obrazlozenje.Taksa createResenjeSadrzajObrazlozenjeTaksa() {
        return new Resenje.Sadrzaj.Obrazlozenje.Taksa();
    }

    /**
     * Create an instance of {@link Resenje.Sadrzaj.Uvod.Zakon }
     * 
     */
    public Resenje.Sadrzaj.Uvod.Zakon createResenjeSadrzajUvodZakon() {
        return new Resenje.Sadrzaj.Uvod.Zakon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.DonetoResenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "doneto_resenje", scope = Resenje.Sadrzaj.class)
    public JAXBElement<Resenje.Sadrzaj.DonetoResenje> createResenjeSadrzajDonetoResenje(Resenje.Sadrzaj.DonetoResenje value) {
        return new JAXBElement<Resenje.Sadrzaj.DonetoResenje>(_ResenjeSadrzajDonetoResenje_QNAME, Resenje.Sadrzaj.DonetoResenje.class, Resenje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Obrazlozenje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "obrazlozenje", scope = Resenje.Sadrzaj.class)
    public JAXBElement<Resenje.Sadrzaj.Obrazlozenje> createResenjeSadrzajObrazlozenje(Resenje.Sadrzaj.Obrazlozenje value) {
        return new JAXBElement<Resenje.Sadrzaj.Obrazlozenje>(_ResenjeSadrzajObrazlozenje_QNAME, Resenje.Sadrzaj.Obrazlozenje.class, Resenje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Uvod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "uvod", scope = Resenje.Sadrzaj.class)
    public JAXBElement<Resenje.Sadrzaj.Uvod> createResenjeSadrzajUvod(Resenje.Sadrzaj.Uvod value) {
        return new JAXBElement<Resenje.Sadrzaj.Uvod>(_ResenjeSadrzajUvod_QNAME, Resenje.Sadrzaj.Uvod.class, Resenje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "tacka", scope = Resenje.Sadrzaj.Uvod.Zakon.class)
    public JAXBElement<String> createResenjeSadrzajUvodZakonTacka(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodZakonTacka_QNAME, String.class, Resenje.Sadrzaj.Uvod.Zakon.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "clan", scope = Resenje.Sadrzaj.Uvod.Zakon.class)
    public JAXBElement<String> createResenjeSadrzajUvodZakonClan(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodZakonClan_QNAME, String.class, Resenje.Sadrzaj.Uvod.Zakon.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "naziv_zakona", scope = Resenje.Sadrzaj.Uvod.Zakon.class)
    public JAXBElement<String> createResenjeSadrzajUvodZakonNazivZakona(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodZakonNazivZakona_QNAME, String.class, Resenje.Sadrzaj.Uvod.Zakon.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "stav", scope = Resenje.Sadrzaj.Uvod.Zakon.class)
    public JAXBElement<String> createResenjeSadrzajUvodZakonStav(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodZakonStav_QNAME, String.class, Resenje.Sadrzaj.Uvod.Zakon.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Obrazlozenje.Taksa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "taksa", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<Resenje.Sadrzaj.Obrazlozenje.Taksa> createResenjeSadrzajObrazlozenjeTaksa(Resenje.Sadrzaj.Obrazlozenje.Taksa value) {
        return new JAXBElement<Resenje.Sadrzaj.Obrazlozenje.Taksa>(_ResenjeSadrzajObrazlozenjeTaksa_QNAME, Resenje.Sadrzaj.Obrazlozenje.Taksa.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "postupak_organa", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<String> createResenjeSadrzajObrazlozenjePostupakOrgana(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajObrazlozenjePostupakOrgana_QNAME, String.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "datum_podnosenja_zalbe", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<XMLGregorianCalendar> createResenjeSadrzajObrazlozenjeDatumPodnosenjaZalbe(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ResenjeSadrzajObrazlozenjeDatumPodnosenjaZalbe_QNAME, XMLGregorianCalendar.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "odluka_organa", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<String> createResenjeSadrzajObrazlozenjeOdlukaOrgana(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajObrazlozenjeOdlukaOrgana_QNAME, String.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "razlog_zalbe", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe> createResenjeSadrzajObrazlozenjeRazlogZalbe(Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe value) {
        return new JAXBElement<Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe>(_ResenjeSadrzajObrazlozenjeRazlogZalbe_QNAME, Resenje.Sadrzaj.Obrazlozenje.RazlogZalbe.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "trazilac_informacija", scope = Resenje.Sadrzaj.Obrazlozenje.class)
    public JAXBElement<Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija> createResenjeSadrzajObrazlozenjeTrazilacInformacija(Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija value) {
        return new JAXBElement<Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija>(_ResenjeSadrzajObrazlozenjeTrazilacInformacija_QNAME, Resenje.Sadrzaj.Obrazlozenje.TrazilacInformacija.class, Resenje.Sadrzaj.Obrazlozenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "broj_resenja", scope = Resenje.Zaglavlje.class)
    public JAXBElement<String> createResenjeZaglavljeBrojResenja(String value) {
        return new JAXBElement<String>(_ResenjeZaglavljeBrojResenja_QNAME, String.class, Resenje.Zaglavlje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "datum_resenja", scope = Resenje.Zaglavlje.class)
    public JAXBElement<XMLGregorianCalendar> createResenjeZaglavljeDatumResenja(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ResenjeZaglavljeDatumResenja_QNAME, XMLGregorianCalendar.class, Resenje.Zaglavlje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "naziv_resenja", scope = Resenje.Zaglavlje.class)
    public JAXBElement<String> createResenjeZaglavljeNazivResenja(String value) {
        return new JAXBElement<String>(_ResenjeZaglavljeNazivResenja_QNAME, String.class, Resenje.Zaglavlje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "odluka", scope = Resenje.Sadrzaj.DonetoResenje.class)
    public JAXBElement<String> createResenjeSadrzajDonetoResenjeOdluka(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajDonetoResenjeOdluka_QNAME, String.class, Resenje.Sadrzaj.DonetoResenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "tekst", scope = Resenje.Sadrzaj.DonetoResenje.class)
    public JAXBElement<String> createResenjeSadrzajDonetoResenjeTekst(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajDonetoResenjeTekst_QNAME, String.class, Resenje.Sadrzaj.DonetoResenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "naziv_ustanove", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<String> createResenjeSadrzajUvodNazivUstanove(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodNazivUstanove_QNAME, String.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "adresa_ustanove", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<String> createResenjeSadrzajUvodAdresaUstanove(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodAdresaUstanove_QNAME, String.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "datum_zalbe", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<XMLGregorianCalendar> createResenjeSadrzajUvodDatumZalbe(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ResenjeSadrzajUvodDatumZalbe_QNAME, XMLGregorianCalendar.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj.Uvod.Zakon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "zakon", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<Resenje.Sadrzaj.Uvod.Zakon> createResenjeSadrzajUvodZakon(Resenje.Sadrzaj.Uvod.Zakon value) {
        return new JAXBElement<Resenje.Sadrzaj.Uvod.Zakon>(_ResenjeSadrzajUvodZakon_QNAME, Resenje.Sadrzaj.Uvod.Zakon.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "naziv_organa", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<String> createResenjeSadrzajUvodNazivOrgana(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodNazivOrgana_QNAME, String.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "podnosilac", scope = Resenje.Sadrzaj.Uvod.class)
    public JAXBElement<String> createResenjeSadrzajUvodPodnosilac(String value) {
        return new JAXBElement<String>(_ResenjeSadrzajUvodPodnosilac_QNAME, String.class, Resenje.Sadrzaj.Uvod.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Sadrzaj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "sadrzaj", scope = Resenje.class)
    public JAXBElement<Resenje.Sadrzaj> createResenjeSadrzaj(Resenje.Sadrzaj value) {
        return new JAXBElement<Resenje.Sadrzaj>(_ResenjeSadrzaj_QNAME, Resenje.Sadrzaj.class, Resenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "poverenik", scope = Resenje.class)
    public JAXBElement<String> createResenjePoverenik(String value) {
        return new JAXBElement<String>(_ResenjePoverenik_QNAME, String.class, Resenje.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resenje.Zaglavlje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/resenje", name = "zaglavlje", scope = Resenje.class)
    public JAXBElement<Resenje.Zaglavlje> createResenjeZaglavlje(Resenje.Zaglavlje value) {
        return new JAXBElement<Resenje.Zaglavlje>(_ResenjeZaglavlje_QNAME, Resenje.Zaglavlje.class, Resenje.class, value);
    }

}
