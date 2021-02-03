import React from 'react';
import {Button, TextField} from "@material-ui/core";

const ZalbaOdluka = (props) => {
    const [ime, setIme] = React.useState('');
    const [prezime, setPrezime] = React.useState('');
    const [ulicaPodnosioca, setUlicaPodnosioca] = React.useState('');
    const [brojUlicePodnosioca, setBrojUlicePodnosioca] = React.useState('');
    const [gradPodnosioca, setGradPodnosioca] = React.useState('');
    const [nazivOrgana, setNazivOrgana] = React.useState('');
    const [brojZalbe, setBrojZalbe] = React.useState('');
    const [godina, setGodina] = React.useState('');
    const [datumPodnosenja, setDatumPodnosenja] = React.useState('');
    const [razlog, setRazlog] = React.useState('');
    const [drugiKontakt, setDrugiKontakt] = React.useState('');

    return(
        <React.Fragment>
            <div align={'center'} style={{marginTop:20}}>
                <h2> ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                    ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ
                </h2>
                <h4>Поверенику за информације од јавног значаја и заштиту података о личности
                    Адреса за пошту: Београд, Булевар краља Александрa бр. 15
                </h4>
            </div>
            <div align={'center'} style={{marginTop:20}}>
                <h4>Ж А Л Б А</h4>
                <TextField required id="ime" label="Ime podnosioca" variant="outlined"
                           value={ime}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setIme(e.target.value)}}
                />
                <TextField required id="prezime" label="Prezime podnosioca" variant="outlined"
                           value={prezime}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setPrezime(e.target.value)}}
                />
                <TextField required id="ulicaPodnosioca" label="Adresa-ulica" variant="outlined"
                           value={ulicaPodnosioca}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setUlicaPodnosioca(e.target.value)}}
                />
                <TextField required id="broj" label="Adresa-broj" variant="outlined"
                           value={brojUlicePodnosioca}
                           style={{marginLeft:20, minWidth:100}}
                           onChange={(e) => {setBrojUlicePodnosioca(e.target.value)}}
                />
                <TextField required id="grad" label="Adresa-grad" variant="outlined"
                           value={gradPodnosioca}
                           style={{marginLeft:20, minWidth:150}}
                           onChange={(e) => {setGradPodnosioca(e.target.value)}}
                />
                <p>(Име, презиме, односно назив, адреса и седиште жалиоца)</p>
                <p>против решења-закључка</p>
                <TextField required id="nazivOrgana" label="Naziv organa" variant="outlined"
                           value={nazivOrgana}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setNazivOrgana(e.target.value)}}
                />
                <p>(назив органа који је донео одлуку)</p>
                <p> Број жалбe и година</p>
                <TextField required id="brojZalbe" label="Broj zalbe" variant="outlined"
                           value={brojZalbe}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setBrojZalbe(e.target.value)}}
                />
                <TextField required id="godina" label="Godina" variant="outlined"
                           value={godina}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setGodina(e.target.value)}}
                />
            </div>

            <div>
                <p>Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана </p>
                <TextField required id="datumPodnosenja" label="Datum podnosenja zahteva" variant="outlined"
                           value={datumPodnosenja}
                           style={{marginLeft:20, minWidth:50}}
                           onChange={(e) => {setDatumPodnosenja(e.target.value)}}
                />
                <p>године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим</p>
                <TextField id="razlog" label="razlog" variant="outlined" multiline rows={3}
                           value={razlog}
                           style={{marginLeft:20, minWidth:1000}}
                           onChange={(e) => {setRazlog(e.target.value)}}
                />
                <p>јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.
                    Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.
                </p>
            </div>
            <div>
                <p>други подаци за контакт</p>
                <TextField id="drugiKontakt" label="Drugi podaci za kontakt" variant="outlined"
                           value={drugiKontakt}
                           style={{marginLeft:20, minWidth:50}}
                           onChange={(e) => {setDrugiKontakt(e.target.value)}}
                />
                <Button
                    variant="contained"
                    color="primary"
                    onClick={() => {
                        const data = {
                            ime:ime,
                            prezime:prezime,
                            ulicaPodnosioca:ulicaPodnosioca,
                            brojUlicePodnosioca:brojUlicePodnosioca,
                            gradPodnosioca:gradPodnosioca,
                            nazivOrgana:nazivOrgana,
                            brojZalbe:brojZalbe,
                            godina:godina,
                            datumPodnosenja:datumPodnosenja,
                            razlog:razlog,
                            drugiKontakt:drugiKontakt
                        }
                        props.sendZalbaOdlukaData(data);
                    }}
                >
                    Primary
                </Button>
            </div>

        </React.Fragment>
    );

};

export default ZalbaOdluka;