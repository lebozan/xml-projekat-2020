import React from "react"
import ZalbaCutanje from "./ZalbaCutanje";
import ZalbaCutanjeService from "../../service/zalbaCutanje-service";

const CreateZalbaCutanje = () => {

    const createZalbaCutanjeXml = (data) => {
        console.log(data);
        let xml = ''
        xml += '<?xml version="1.0" encoding="UTF-8"?>\n' +
            '<zalbaCutanje xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\n' +
            '    xmlns="http://www.ftn.uns.ac.rs/zalbanacutanje"\n' +
            '    xmlns:pred="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/predicate/">\n'

        xml += '    <zaglavlje>\n' +
            '        ZALBA KADA ORGAN VLASTI NIJE POSTUPIO/nije postupio u celosti/\n' +
            '         PO ZAHTEVU TUZIOCA U ZAKONSKOM ROKU (CUTANJE UPRAVE)\n' +
            '        <primalac>\n' +
            '            <naziv_primaoca>Povereniku za informacije od javnog znacaja i zastitu podataka o licnosti</naziv_primaoca>\n' +
            '            <adresa_primaoca>\n' +
            '                <mesto>Beograd</mesto>\n' +
            '                <ulica>Bulevar kralja Aleksandra</ulica>\n' +
            '                <broj>15</broj>\n' +
            '                <postanski_broj>11000</postanski_broj>\n' +
            '            </adresa_primaoca>\n' +
            '        </primalac>\n' +
            '       U skladu sa clanom 22. Zakona o slobodnom pristupu informacijama od javnog znacaja podnosim:\n' +
            '    </zaglavlje>\n'
        //TODO: Tip razloga treba da se dobije kroz datu sa front page-a ; mozda treba remodelovati xml
        //TODO: Proveri da li u <predmet> treb da stoji about= ; kao i property/datatype u <naziv_organa>
        xml += '    <sadrzaj>\n' +
            '        <predmet about="http://www.ftn.uns.ac.rs/rdf/azlbacutanje/organ">\n' +
            '            <naziv_predmeta>ZALBU</naziv_predmeta>\n' +
            '                            protiv\n' +
            '            <naziv_organa property="pred:naziv_organa" datatype="xsi:string">'+ data.nazivOrgana + '</naziv_organa>\n' +
            '        </predmet>\n' +
            '        <razlozi_podnsenja>\n' +
            '            zbog toga sto organ vlasti:\n' +
            '            <tipovi_razloga>\n' +
            '                <tip_razloga>nije postupio</tip_razloga>\n' +
            '                <tip_razloga>nije potupio u celosti</tip_razloga>\n' +
            '                <tip_razloga>u zakonskom roku</tip_razloga>\n' +
            '            </tipovi_razloga>\n' +
            '        </razlozi_podnsenja>\n'

        xml += '        <izjava about="http://www.ftn.uns.ac.rs/rdf/zalbacutanje/podacizahtev">\n' +
            '            po mom zahtevu za slobodan pristup informacijama od javnog znacaja koji sam podneo tom organu dana\n' +
            '            <datum_podnosenja>'+ data.datumPodnosenja + '</datum_podnosenja>godine, a koji sam trazio//la da mi se u skladu sa Zakonom o \n' +
            '            slobodnom pristupu informacijama od javnog znacaja omoguci uvid-kopija dokumenta koji sadrzi informacije o/u vezi sa:\n' +
            '            <podaci_o_zahtevu property="pred:podaci_o_zahtevu" datatype="xsi:string">'+ data.podaciOZahtevu + '</podaci_o_zahtevu>\n' +
            '            Na osnovu iznetog, predlazem da Poverenik uvazi moju zalbu i omoguci mi pristup trazenoj/im informajici/ma.\n' +
            '            Kao dokaz, uz zalbu dostavljam kopiju zahteva sa dokazom o predaji organu vlasti.\n' +
            '            Napomena: Kod zalbe zbog nepostupanju po zahtevu u celosti, treba priloziti i dobijeni odgvor organa vlasti.\n' +
            '        </izjava>\n' +
            '    </sadrzaj>\n'

        //TODO: izmeniti ovaj deo ; i ovaj deo u xml-u takodje  --- broj racuna,potpis i mesto ne treba; datum da se uzme datum requesta sa fronta
        xml += '    <podnosilac>\n' +
            '        <podnosilac_tuzbe xsi:type="TFizicko_lice">\n' +
            '            <broj_racuna>000-0000000000000-00</broj_racuna>\n' +
            '            <adresa>\n' +
            '                <mesto>'+ data.gradPodnosioca + '</mesto>\n' +
            '                <ulica>'+ data.ulicaPodnosioca + '</ulica>\n' +
            '                <broj>'+ data.brojUlicePodnosioca + '</broj>\n' +
            '                <postanski_broj>'+ data.postanskiBroj + '</postanski_broj>\n' +
            '            </adresa>\n' +
            '            <ime>'+ data.ime + '</ime>\n' +
            '            <prezime>'+ data.prezime + '</prezime>\n' +
            '        </podnosilac_tuzbe>\n' +
            '        <potpis></potpis>\n' +
            '    </podnosilac>\n' +
            '    <mesto_i_datum>\n' +
            '        U<mesto>Prizrenu</mesto>, dana <datum_zalbe>2010-05-10</datum_zalbe>godine\n' +
            '    </mesto_i_datum>    \n' +
            '</zalbaCutanje>'

        console.log(xml);
        ZalbaCutanjeService.postZalbaCutanje(xml)
            .then(res => {
                console.log(res);
            })
            .catch(error => {
                console.log(error);
            })

    }

    return (
        <div>
            <ZalbaCutanje sendZalbaOdlukaData={createZalbaCutanjeXml}/>
        </div>

    );

}

export default CreateZalbaCutanje;