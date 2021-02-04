import React from "react"
import ZahtevService from '../../service/zahtev-service';
import RenderZahtev from "./RenderZahtev";

const CreateZahtev = () => {

    const createZahtevXml = (data) => {
        console.log(data);
        let xml = ''
        xml += '<?xml version="1.0" encoding="UTF-8"?>\n' +
            '<zahtev_za_pristup_informacijama xmlns:pred="http://www.ftn.uns.ac.rs/rdf/zahtev/predicate/"\n' +
            ' xmlns="http://www.ftn.uns.ac.rs/zahtev"\n' +
            ' xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n'

        xml += "<zaglavlje>\n" +
            "<organ>\n" +
            "<naziv_organa>" + data.nazivOrgana + "</naziv_organa>\n"

        xml += "<sediste_organa>" + data.sedisteOrgana + "</sediste_organa>" +
            "</organ>\n" +
            "</zaglavlje>\n"

        xml += '    <naslov>\n' +
            '        З А Х Т Е В\n' +
            '        за приступ информацији од јавног значаја\n' +
            '    </naslov>\n' +
            '    <sadrzaj>\n' +
            '        <tekst>На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*</tekst>'

        xml += '<tipovi_zahteva>\n' +
            '            <tip_zahteva>обавештење да ли поседује тражену информацију</tip_zahteva>\n' +
            '            <tip_zahteva>увид у документ који садржи тражену информацију</tip_zahteva>\n' +
            '            <tip_zahteva>копију документа који садржи тражену информацију</tip_zahteva>\n' +
            '            <tip_zahteva_dostava>\n' +
            '                <tekst>достављање копије документа који садржи тражену информацију:**</tekst>\n' +
            '                <vrste_dostave>\n' +
            '                    <dostava>поштом</dostava>\n' +
            '                    <dostava>електронском поштом</dostava>\n' +
            '                    <dostava>факсом</dostava>\n' +
            '                    <dostava>на други начин:***</dostava>\n' +
            '                </vrste_dostave>\n' +
            '            </tip_zahteva_dostava>\n' +
            '        </tipovi_zahteva>' +
            '        <informacije_o_zahtevu>\n' +
            '            <tekst>Овај захтев се односи на следеће информације:</tekst>\n' +
            '            <opis_zahteva>' + data.zahtevInfo + '</opis_zahteva>\n' +
            '        </informacije_o_zahtevu>' +
            '    </sadrzaj>\n'

        xml += '    <informacije_trazioca about="http://www.ftn.uns.ac.rs/rdf/resenje/trazilac">\n' +
            '        <ime property="pred:ime" datatype="xsi:string">ime0</ime>\n' +
            '        <prezime property="pred:prezime" datatype="xsi:string">prezime0</prezime>\n' +
            '        <adresa property="pred:adresa" datatype="xsi:string">adresa0</adresa>\n' +
            '        <kontakt_podaci property="pred:kontakt" datatype="xsi:string">kontakt_podaci0</kontakt_podaci>\n' +
            '        <potpis>potpis0</potpis>\n' +
            '    </informacije_trazioca>\n' +
            '    <mesto_i_datum>\n' +
            '        <tekst>tekst1</tekst>\n' +
            '        <mesto>Pozarevac</mesto>\n' +
            '        <datum>\n' +
            '            <tekst_dan>дана</tekst_dan>\n' +
            '            <dan>1.</dan>\n' +
            '            <mesec>2.</mesec>\n' +
            '            <godina>2021.</godina>\n' +
            '            <tekst_godina>године</tekst_godina>\n' +
            '        </datum>\n' +
            '    </mesto_i_datum>\n' +
            '    <fusnote>\n' +
            '        <fusnota>* У кућици означити која законска права на приступ информацијама желите да остварите.</fusnota>\n' +
            '        <fusnota>** У кућици означити начин достављања копије докумената.</fusnota>\n' +
            '        <fusnota>*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.</fusnota>\n' +
            '    </fusnote>\n' +
            '</zahtev_za_pristup_informacijama>'

        console.log(xml);
        ZahtevService.postZahtev(xml)
            .then(res => {
                console.log(res);
            })
            .catch(error => {
                console.log(error);
            })
    }

    return (
        <div>
            <RenderZahtev sendZahtevData={createZahtevXml}/>
        </div>

    );
}

export default CreateZahtev;
