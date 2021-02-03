<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:z="http://www.ftn.uns.ac.rs/zahtev" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Zahtev</title>
                <style type="text/css">
                    body {
                        text-align: center;
                    }
                </style>
            </head>
            <body>
                <p>
                    Naziv i sediste organa kome se upucuje zahtev:
                    <xsl:value-of
                            select="z:zahtev_za_pristup_informacijama/z:zaglavlje/z:organ/z:naziv_organa[text()]"
                    />,
                    <xsl:value-of
                            select="z:zahtev_za_pristup_informacijama/z:zaglavlje/z:organ/z:sediste_organa[text()]"
                    />
                </p>
                <h2>Zahtev</h2>
                <h4>za pristup informaciji od javnog znacaja</h4>
                <br/>
                <p>Na osnovu clana 15. st. 1. Zakona o slobodnom pristupu informacijama od javnog znacaja ("Sluzbeni glasnik RS", br. 120/04, 54/07, 104/09 i 36/10), od gore navedenog organa zahtevam:*</p>

                <div id="zahtevi">
                    <table style="border: 1px">
                        <tr>
                            <th>Odabran</th>
                            <th>Tip dostave</th>
                        </tr>
                        <xsl:for-each select="z:zahtev_za_pristup_informacijama/z:sadrzaj/z:tipovi_zahteva/z:tip_zahteva">
                            <tr>
                                <td>
                                    (<xsl:if test="@odabran='true'">*</xsl:if>)
                                </td>
                                <td>
                                    <xsl:value-of select="text()"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <td>
                                (<xsl:if test="z:zahtev_za_pristup_informacijama/z:sadrzaj/z:tipovi_zahteva/z:tip_zahteva_dostava[@odabran]='true'">*</xsl:if>)
                            </td>
                            <td>
                                <xsl:value-of
                                        select="z:zahtev_za_pristup_informacijama/z:sadrzaj/z:tipovi_zahteva/z:tip_zahteva_dostava/text()"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div id="dostave">
                    <table style="border: 1px">
                        <tr>
                            <th>Odabrana</th>
                            <th>Tip dostave</th>
                        </tr>
                        <xsl:for-each select="z:zahtev_za_pristup_informacijama/z:sadrzaj/z:tipovi_zahteva/z:tip_zahteva_dostava/z:vrste_dostave/z:dostava">
                            <tr>
                                <td>(<xsl:if test="@odabrana='true'">*</xsl:if>)</td>
                                <td>
                                    <xsl:value-of select="text()"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </table>

                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>