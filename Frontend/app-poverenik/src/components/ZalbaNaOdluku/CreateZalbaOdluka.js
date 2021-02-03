import React from "react"
import ZalbaOdluka from "./ZalbaOdluka";
import ZalbaOdlukaService from "../../service/zalbaOdluka-service";


const CreateZalbaOdluka = () => {

    const createZalbaOdlukaXml = (data) => {
        console.log(data);
        let xml = ''
        xml += '<?xml version="1.0" encoding="UTF-8"?>\n' +
            '<zalba_na_odluku xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\n' +
            '    xmlns = "http://www.ftn.uns.ac.rs/zalbaOdluka"\n' +
            '    xmlns:pred="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/predicate/">\n'
        xml += '    <zaglavlje>\n' +
            '        <naslov>\n' +
            '            ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ\n' +
            '            ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ\n' +
            '        </naslov>\n' +
            '        <primalac> \n' +
            '            Повереникy за информације од јавног значаја и заштиту података о личности\n' +
            '        </primalac>\n' +
            '        <adresa_primaoca>\n' +
            '            Адреса за пошту: Београд, Булевар краља Александрa бр. 15\n' +
            '        </adresa_primaoca>\n' +
            '    </zaglavlje>\n'

        xml += '    <zalba_sadrzaj>\n' +
            '        Жалбa\n' +
            '        <podnosilac_zalbe>\n' +
            '            <ime>'+ data.ime + '</ime>\n' +
            '            <prezime>'+ data.prezime + '</prezime>\n' +
            '            <adresa_podnosioca>\n'+
            '                <ulica>'+ data.ulicaPodnosioca + '</ulica>\n' +
            '                <broj>'+ data.brojUlicePodnosioca + '</broj>\n' +
            '                <grad>'+ data.gradPodnosioca + '</grad>\n' +
            '            </adresa_podnosioca>\n' +
            '        </podnosilac_zalbe>\n' +
            '        против решења-закључка \n' +
            '        <naziv_organa_vlasti>'+ data.nazivOrgana + '</naziv_organa_vlasti>\n' +
            '        Број\n' +
            '        <broj_zalbe>'+ data.brojZalbe + '</broj_zalbe>\n' +
            '        од\n' +
            '        <godina>'+ data.godina + '</godina>\n' +
            '        године.\n'

        xml += '        <paragrafi>   \n' +
            '            <paragraf_podaci>\n' +
            '                Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) ,\n' +
            '                супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана \n' +
            '                <datum>'+ data.datumPodnosenja + '</datum>\n' +
            '                године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ\n' +
            '                информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим\n' +
            '                <razlog>'+ data.razlog + '</razlog>\n' +
            '                јер није заснована на Закону о слободном приступу информацијама од јавног значаја.\n' +
            '            </paragraf_podaci>\n' +
            '            <paragraf>\n' +
            '                На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  \n' +
            '                поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.\n' +
            '            </paragraf>\n' +
            '            <paragraf>\n' +
            '                Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о \n' +
            '                слободном приступу информацијама од јавног значаја\n' +
            '            </paragraf>\n' +
            '        </paragrafi>\n'


        console.log(xml);
        ZalbaOdlukaService.postZalbaOdluka(xml)
            .then(res => {
                console.log(res);
            })
            .catch(error => {
                console.log(error);
            })

    }

    return (
        <div>
            <ZalbaOdluka sendZalbaOdlukaData={createZalbaOdlukaXml}/>
        </div>

    );

}

export default CreateZalbaOdluka;