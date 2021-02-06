import React from "react"
import ZahtevService from '../../service/zahtev-service';
import RenderZahtev from "./RenderZahtev";
import jwtDecode from "jwt-decode";

const CreateZahtev = () => {

    const createZahtevXml = (data) => {
        console.log(data);
        let xml = ''
        xml += '<?xml version="1.0" encoding="UTF-8"?>\n' +
            '<zahtev xmlns:pred="http://www.ftn.uns.ac.rs/rdf/zahtev/predicate/"\n' +
            ' xmlns="http://www.ftn.uns.ac.rs/zahtev"\n' +
            ' xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">\n'

        xml += "<zaglavlje>\n" +
            "<naziv_organa>" + data.nazivOrgana + "</naziv_organa>\n"

        xml += "<sediste_organa>" + data.sedisteOrgana + "</sediste_organa>" +
            "</zaglavlje>\n" +
            '<sadrzaj>\n' +
            '<tipovi_zahteva>\n';

        if (data.tipZahteva[0]) {
            xml += '            <tip_zahteva odabran="true">obavestenje da li poseduje trazenu informaciju</tip_zahteva>\n';
        } else {
            xml += '            <tip_zahteva>obavestenje da li poseduje trazenu informaciju</tip_zahteva>\n';
        }
        if (data.tipZahteva[1]) {
            xml += '            <tip_zahteva odabran="true">uvid u dokument koji sadrzi trazenu informaciju</tip_zahteva>\n';
        } else {
            xml += '            <tip_zahteva>uvid u dokument koji sadrzi trazenu informaciju</tip_zahteva>\n';
        }
        if (data.tipZahteva[2]) {
            xml += '            <tip_zahteva odabran="true">kopiju dokumenta koji sadrzi trazenu informaciju</tip_zahteva>\n';
        } else {
            xml += '            <tip_zahteva>kopiju dokumenta koji sadrzi trazenu informaciju</tip_zahteva>\n';
        }
        if (data.tipZahteva[3]) {
            xml += '            <tip_zahteva_dostava odabran="true">dostavljanje kopije dokumenta koji sadrzi trazenu informaciju:**</tip_zahteva_dostava>\n';
        } else {
            xml += '            <tip_zahteva_dostava>dostavljanje kopije dokumenta koji sadrzi trazenu informaciju:**</tip_zahteva_dostava>\n';
        }
        if (data.tipDostave[0]) {
            xml += '            <dostava odabrana="true">postom</dostava>\n';
        } else {
            xml += '            <dostava>postom</dostava>\n';
        }
        if (data.tipDostave[1]) {
            xml += '            <dostava odabrana="true">elektronskom postom</dostava>\n';
        } else {
            xml += '            <dostava>elektronskom postom</dostava>\n';
        }
        if (data.tipDostave[2]) {
            xml += '            <dostava odabrana="true">faksom</dostava>\n';
        } else {
            xml += '            <dostava>faksom</dostava>\n';
        }
        if (data.tipDostave[3]) {
            xml += '            <dostava odabrana="true">na drugi nacim:*** ' + data.customDostava + '</dostava>\n';
        } else {
            xml += '            <dostava>na drugi nacim:*** ' + data.customDostava + '</dostava>\n';
        }
        let user = jwtDecode(localStorage.getItem('tokenOrganVlasti'));
        xml +=
            '        </tip_zahteva_dostava>\n' +
            '     </tipovi_zahteva>\n' +
            '     <opis>' + data.zahtevInfo + '</opis>\n' +
            '    </sadrzaj>\n'

        let datum = new Date();
        xml += '    <trazilac\n' +
            '        <ime>' + user.ime + '</ime>\n' +
            '        <prezime>'+ user.prezime + '</prezime>\n' +
            '        <adresa>Adresa 123</adresa>\n' +
            '        <kontakt_podaci>064-123123</kontakt_podaci>\n' +
            '    </trzilac>\n' +
            '    <mesto_i_datum>\n' +
            '        <mesto>Pozarevac</mesto>\n' +
            '        <datum>\n' +
            '            <dan>'+ datum.getDate() + '.</dan>\n' +
            '            <mesec>'+ datum.getMonth() + 1 + '.</mesec>\n' +
            '            <godina>'+ datum.getFullYear() + '.</godina>\n' +
            '        </datum>\n' +
            '    </mesto_i_datum>\n' +
            '</zahtev>'

        console.log(xml);
        ZahtevService.postZahtev(xml)
            .then(res => {
                console.log(res);
            }, error => {
                console.log(error);
            });
    }

    return (
        <div>
            <RenderZahtev sendZahtevData={createZahtevXml}/>
        </div>

    );
}

export default CreateZahtev;
