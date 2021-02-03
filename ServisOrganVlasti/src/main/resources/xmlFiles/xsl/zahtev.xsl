<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:z="http://www.ftn.uns.ac.rs/zahtev" version="1.0">
    <xsl:template match="/">
        <z:zahtev_za_pristup_informacijama>
            <z:zaglavlje>
                <z:organ>
                    <z:naziv_organa>
                        <xsl:value-of select="z:zahtev/z:zaglavlje/z:naziv_organa"></xsl:value-of>
                    </z:naziv_organa>
                    <z:sediste_organa>
                        <xsl:value-of select="z:zahtev/z:zaglavlje/z:sediste_organa"></xsl:value-of>
                    </z:sediste_organa>
                </z:organ>
            </z:zaglavlje>
            <z:naslov>
                Zahtev
                za pristup informacijama od javnog značaja
            </z:naslov>
            <z:sadrzaj>
                На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*
                <z:tipovi_zahteva>
                    <xsl:for-each select="z:zahtev/z:sadrzaj/z:tip_zahteva">
                        <z:tip_zahteva>
                            <xsl:value-of select="text()"></xsl:value-of>
                        </z:tip_zahteva>
                    </xsl:for-each>
                    <z:tip_zahteva_dostava>достављање копије документа који садржи тражену информацију:**
                        <z:vrste_dostave>
                            <xsl:for-each
                                    select="z:zahtev/z:sadrzaj/z:tip_zahteva_dostava/z:dostava"
                            >
                                <z:dostava>
                                    <xsl:value-of select="text()"></xsl:value-of>
                                </z:dostava>
                            </xsl:for-each>
                        </z:vrste_dostave>
                    </z:tip_zahteva_dostava>
                </z:tipovi_zahteva>
                <z:informacije_o_zahtevu>
                    Овај захтев се односи на следеће информације:
                    <z:opis_zahteva>
                        <xsl:value-of select="z:zahtev/z:sadrzaj/z:opis[text()]"></xsl:value-of>
                    </z:opis_zahteva>
                </z:informacije_o_zahtevu>
            </z:sadrzaj>
            <z:informacije_trazioca>
                <z:ime>
                    <xsl:value-of select="z:zahtev/z:trazilac/z:ime[text()]"></xsl:value-of>
                </z:ime>
                <z:prezime>
                    <xsl:value-of select="z:zahtev/z:trazilac/z:prezime[text()]"></xsl:value-of>
                </z:prezime>
                <z:adresa>
                    <xsl:value-of select="z:zahtev/z:trazilac/z:adresa[text()]"></xsl:value-of>
                </z:adresa>
                <z:kontakt_podaci>
                    <xsl:value-of select="z:zahtev/z:trazilac/z:kontakt_podaci[text()]"></xsl:value-of>
                </z:kontakt_podaci>
            </z:informacije_trazioca>
            <z:mesto_i_datum>
                <z:mesto>
                    <xsl:value-of select="z:zahtev/z:mesto_i_datum/z:mesto[text()]"></xsl:value-of>
                </z:mesto>
                <z:datum>
                    <z:dan>
                        <xsl:value-of select="z:zahtev/z:mesto_i_datum/z:datum/z:dan"></xsl:value-of>
                    </z:dan>
                    <z:mesec>
                        <xsl:value-of select="z:zahtev/z:mesto_i_datum/z:datum/z:mesec"></xsl:value-of>
                    </z:mesec>
                    <z:godina>
                        <xsl:value-of select="z:zahtev/z:mesto_i_datum/z:datum/z:godina"></xsl:value-of>
                    </z:godina>
                </z:datum>
            </z:mesto_i_datum>
            <z:fusnote>
                <z:fusnota>* У кућици означити која законска права на приступ информацијама желите да остварите.</z:fusnota>
                <z:fusnota>** У кућици означити начин достављања копије докумената.</z:fusnota>
                <z:fusnota>*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.</z:fusnota>
            </z:fusnote>
        </z:zahtev_za_pristup_informacijama>
    </xsl:template>
</xsl:stylesheet>