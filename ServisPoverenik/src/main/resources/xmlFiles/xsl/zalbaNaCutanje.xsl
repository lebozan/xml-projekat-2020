<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:z="http://www.ftn.uns.ac.rs/zalbanacutanje" version="1.0">
    <xsl:template match="/">
        <z:zalbaCutanje>
            <z:zaglavlje>ZALBA KADA ORGAN VLASTI NIJE POSTUPIO/nije postupio u celosti/
                PO ZAHTEVU TUZIOCA U ZAKONSKOM ROKU (CUTANJE UPRAVE)
                <z:primalac>
                    <z:naziv_primaoca> Povereniku za informacije od javnog znacaja i zastitu podataka o licnosti</z:naziv_primaoca>
                    <z:adresa_primaoca>
                        <z:mesto>Beograd</z:mesto>
                        <z:ulica>Bulevar kralja Aleksandra</z:ulica>
                        <z:broj>15</z:broj>
                        <z:postanski_broj>11000</z:postanski_broj>
                    </z:adresa_primaoca>
                </z:primalac>
                U skladu sa clanom 22. Zakona o slobodnom pristupu informacijama od javnog znacaja podnosim:
            </z:zaglavlje>
            <z:sadrzaj>
                <z:predmet about="http://www.ftn.uns.ac.rs/rdf/azlbacutanje/organ">
                    <z:naziv_predmeta>ZALBU</z:naziv_predmeta>
                    protiv
                    <z:naziv_organa property="pred:naziv_organa" datatype="xsi:string">
                        <xsl:value-of select="z:zalbaCutanje/z:sadrzaj/z:predmet/z:naziv_organa[text()]"></xsl:value-of>
                    </z:naziv_organa>
                </z:predmet>
                <z:razlozi_podnsenja>
                    zbog toga sto organ vlasti:
                    <z:tipovi_razloga>
                        <xsl:for-each select="z:zalbaCutanje/z:sadrzaj/z:razlozi_podnsenja/z:tipovi_razloga/z:tip_razloga">
                            <xsl:variable name="odabran" select="@odabran"></xsl:variable>
                            <z:tip_razloga>
                                <xsl:if test="$odabran != ''">
                                    <xsl:attribute name="odabran">
                                        <xsl:value-of select="$odabran"></xsl:value-of>
                                    </xsl:attribute>
                                </xsl:if>
                                <xsl:value-of select="text()"></xsl:value-of>
                            </z:tip_razloga>
                        </xsl:for-each>
                    </z:tipovi_razloga>
                </z:razlozi_podnsenja>
                <z:izjava about="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/podacizahtev">
                    po mom zahtevu za slobodan pristup informacijama od javnog znacaja koji sam podneo tom organu dana
                    <z:datum_podnosenja>
                        <xsl:value-of select="z:zalbaCutanje/z:sadrzaj/z:izjava/z:datum_podnosenja[text()]"></xsl:value-of>
                    </z:datum_podnosenja>
                    godine, a koji sam trazio//la da mi se u skladu sa Zakonom o
                    slobodnom pristupu informacijama od javnog znacaja omoguci uvid-kopija dokumenta koji sadrzi informacije o/u vezi sa:
                    <z:podaci_o_zahtevu property="pred:podaci_o_zahtevu" datatype="xsi:string">
                        <xsl:value-of select="z:zalbaCutanje/z:sadrzaj/z:izjava/z:podaci_o_zahtevu[text()]"></xsl:value-of>
                    </z:podaci_o_zahtevu>
                    Na osnovu iznetog, predlazem da Poverenik uvazi moju zalbu i omoguci mi pristup trazenoj/im informajici/ma.
                    Kao dokaz, uz zalbu dostavljam kopiju zahteva sa dokazom o predaji organu vlasti.
                    Napomena: Kod zalbe zbog nepostupanju po zahtevu u celosti, treba priloziti i dobijeni odgvor organa vlasti.
                </z:izjava>
            </z:sadrzaj>
            <z:podnosilac>
                <z:podnosilac_tuzbe>
                    <z:adresa>
                        <z:mesto>
                            <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:adresa/z:mesto[text()]"></xsl:value-of>
                        </z:mesto>
                        <z:ulica>
                            <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:adresa/z:ulica[text()]"></xsl:value-of>
                        </z:ulica>
                        <z:broj>
                            <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:adresa/z:broj[text()]"></xsl:value-of>
                        </z:broj>
                        <z:postanski_broj>
                            <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:adresa/z:postanski_broj[text()]"></xsl:value-of>
                        </z:postanski_broj>
                    </z:adresa>
                    <z:ime>
                        <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:ime[text()]"></xsl:value-of>
                    </z:ime>
                    <z:prezime>
                        <xsl:value-of select="z:zalbaCutanje/z:podnosilac/z:podnosilac_tuzbe/z:prezime[text()]"></xsl:value-of>
                    </z:prezime>
                </z:podnosilac_tuzbe>
            </z:podnosilac>
            <z:mesto_i_datum>
                U<z:mesto>VEB Servisu</z:mesto>, dana <z:datum_zalbe>
                <xsl:value-of select="z:zalbaCutanje/z:mesto_i_datum/z:datum_zalbe[text()]"></xsl:value-of>
            </z:datum_zalbe> godine
            </z:mesto_i_datum>
        </z:zalbaCutanje>
    </xsl:template>
</xsl:stylesheet>