<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:z="http://www.ftn.uns.ac.rs/zalbaNaOdluku" version="1.0">
    <xsl:template match="/">
        <z:zalba_na_odluku>
            <z:zaglavlje>
                <z:naslov>ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                    ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ</z:naslov>
                <z:primalac>Повереникy за информације од јавног значаја и заштиту података о личности</z:primalac>
                <z:adresa_primaoca>Адреса за пошту: Београд, Булевар краља Александрa бр. 15</z:adresa_primaoca>
            </z:zaglavlje>
            <z:zalba_sadrzaj>
                Жалбa
                <z:podnosilac_zalbe>
                    <z:ime>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podnosilac_zalbe/z:ime[text()]"></xsl:value-of>
                    </z:ime>
                    <z:prezime>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podnosilac_zalbe/z:prezime[text()]"></xsl:value-of>
                    </z:prezime>
                    <z:adresa_podnosioca>
                        <z:ulica>
                            <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podnosilac_zalbe/z:adresa_podnosioca/z:ulica[text()]"></xsl:value-of>
                        </z:ulica>
                        <z:broj>
                            <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podnosilac_zalbe/z:adresa_podnosioca/z:broj[text()]"></xsl:value-of>
                        </z:broj>
                        <z:grad>
                            <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podnosilac_zalbe/z:adresa_podnosioca/z:grad[text()]"></xsl:value-of>
                        </z:grad>
                    </z:adresa_podnosioca>
                </z:podnosilac_zalbe>
                против решења-закључка
                <z:naziv_organa_vlasti>
                    <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:naziv_organa_vlasti[text()]"></xsl:value-of>
                </z:naziv_organa_vlasti>
                Број
                <z:broj_resenja>
                    <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:broj_resenja[text()]"></xsl:value-of>
                </z:broj_resenja>
                од
                <z:godina>
                    <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:godina[text()]"></xsl:value-of>
                </z:godina>
                године.
                <z:paragrafi>
                    <z:paragraf_podaci>
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) ,
                        супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана
                        <z:datum>
                            <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:paragrafi/z:paragraf_podaci/z:datum[text()]"></xsl:value-of>
                        </z:datum>
                        године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ
                        информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим
                        <z:razlog>
                            <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:paragrafi/z:paragraf_podaci/z:razlog[text()]"></xsl:value-of>
                        </z:razlog>
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    </z:paragraf_podaci>
                    <z:paragraf>На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,
                        поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.</z:paragraf>
                    <z:paragraf> Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о
                        слободном приступу информацијама од јавног значаја</z:paragraf>
                </z:paragrafi>
                <z:podaci>
                    <z:ime>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podaci/z:ime[text()]"></xsl:value-of>
                    </z:ime>
                    <z:prezime>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podaci/z:prezime[text()]"></xsl:value-of>
                    </z:prezime>
                    дана
                    <z:datum_podnosenja>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podaci/z:datum_podnosenja[text()]"></xsl:value-of>
                    </z:datum_podnosenja>
                    године
                    <z:drugi_podaci_kontakt>
                        <xsl:value-of select="z:zalba_na_odluku/z:zalba_sadrzaj/z:podaci/z:drugi_podaci_kontakt[text()]"></xsl:value-of>
                    </z:drugi_podaci_kontakt>
                </z:podaci>
            </z:zalba_sadrzaj>
            <z:napomene>
                Напомена:
                <z:napomena>
                    У жалби се мора навести одлука која се побија (решење, закључак, обавештење),
                    назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе
                    у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                    Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.
                </z:napomena>
                <z:napomena>
                    Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој
                    предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.
                </z:napomena>
            </z:napomene>
        </z:zalba_na_odluku>
    </xsl:template>      
</xsl:stylesheet>