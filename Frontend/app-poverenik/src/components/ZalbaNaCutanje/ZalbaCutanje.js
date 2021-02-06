import React from 'react';
import {Button, FormControlLabel, TextField, Checkbox} from "@material-ui/core";

const ZalbaCutanje = (props) => {
    const [nazivOrgana, setNazivOrgana] = React.useState('');
    const [datumPodnosenja, setDatumPodnosenja] = React.useState('');
    const [podaciOZahtevu, setPodaciOZahtevu] = React.useState('');
    const [ime, setIme] = React.useState('');
    const [prezime, setPrezime] = React.useState('');
    const [ulicaPodnosioca, setUlicaPodnosioca] = React.useState('');
    const [brojUlicePodnosioca, setBrojUlicePodnosioca] = React.useState('');
    const [gradPodnosioca, setGradPodnosioca] = React.useState('');
    const [postanskiBroj, setPostanskiBroj] = React.useState('');
    const [checkedTip1, setCheckedTip1] = React.useState(false);
    const [checkedTip2, setCheckedTip2] = React.useState(false);
    const [checkedTip3, setCheckedTip3] = React.useState(false);

    const isTipSelected = (index) => {
        if (index === 1) {
            setCheckedTip1(!checkedTip1);
            setCheckedTip2(false);
            setCheckedTip3(false);
        } else if (index === 2) {
            setCheckedTip2(!checkedTip2);
            setCheckedTip1(false);
            setCheckedTip3(false);
        } else if (index === 3) {
            setCheckedTip3(!checkedTip3);
            setCheckedTip1(false);
            setCheckedTip2(false);
        }
    }

    return(
        <React.Fragment>
            <div align={'center'} style={{marginTop:20}}>
                <h2> ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ
                    ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                </h2>
                <h4>Повереникy за информације од јавног значаја и заштиту података о личности
                    Адреса за пошту:  Београд, Булевар краља Александрa бр. 15
                </h4>
            </div>
            <div align={'center'} style={{marginTop:20}}>
                <p>У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:</p>
                <h4>Ж А Л Б У</h4>
                <h5>против</h5>
                <TextField required id="nazivOrgana" label="Назив органа" variant="outlined"
                           value={nazivOrgana}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setNazivOrgana(e.target.value)}}
                />
                <p>(навести назив органа)</p>
                <p>због тога што орган власти:</p>
                <FormControlLabel
                    key={'formcontrollabel ' + 1}
                    control={
                        <Checkbox
                            key={1}
                            checked={checkedTip1}
                            onChange={() => {isTipSelected(1);}}
                            name={"nijePostupio"}
                            color="primary"
                        />
                    }
                    label={"није поступио"}
                />

                <FormControlLabel
                    key={'formcontrollabel ' + 2}
                    control={
                        <Checkbox
                            key={2}
                            checked={checkedTip2}
                            onChange={() => {isTipSelected(2);}}
                            name={"nijePostupioUCelosti"}
                            color="primary"
                        />
                    }
                    label={"није поступио у целости"}
                />

                <FormControlLabel
                    key={'formcontrollabel ' + 3}
                    control={
                        <Checkbox
                            key={3}
                            checked={checkedTip3}
                            onChange={() => {isTipSelected(3);}}
                            name={"uZakonskomRoku"}
                            color="primary"
                        />
                    }
                    label={"у законском року"}
                />

                <TextField required id="datumPodnosenja" label="Датум подношења захтева" variant="outlined"
                           value={datumPodnosenja}
                           style={{marginLeft:20, minWidth:50}}
                           onChange={(e) => {setDatumPodnosenja(e.target.value)}}
                />
                <p>(навести податке о захтеву и информацији/ама)</p>
                <TextField id="PodaciOZahtevu" label="Подаци о захтеву" variant="outlined" multiline rows={3}
                           value={podaciOZahtevu}
                           style={{marginLeft:20, minWidth:1000}}
                           onChange={(e) => {setPodaciOZahtevu(e.target.value)}}
                />
            </div>
            <div align={'center'} style={{marginTop:20}}>
                <TextField required id="ime" label="Име подносиоца" variant="outlined"
                           value={ime}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setIme(e.target.value)}}
                />
                <TextField required id="prezime" label="Презиме подносиоца" variant="outlined"
                           value={prezime}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setPrezime(e.target.value)}}
                />
                <TextField required id="grad" label="Адреса-град" variant="outlined"
                           value={gradPodnosioca}
                           style={{marginLeft:20, minWidth:150}}
                           onChange={(e) => {setGradPodnosioca(e.target.value)}}
                />
                <TextField required id="ulicaPodnosioca" label="Адреса-улица" variant="outlined"
                           value={ulicaPodnosioca}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setUlicaPodnosioca(e.target.value)}}
                />
                <TextField required id="broj" label="Адреса-број" variant="outlined"
                           value={brojUlicePodnosioca}
                           style={{marginLeft:20, minWidth:100}}
                           onChange={(e) => {setBrojUlicePodnosioca(e.target.value)}}
                />
                <TextField id="postanskiBroj" label="Поштански број" variant="outlined"
                           value={postanskiBroj}
                           style={{marginLeft:20, minWidth:100}}
                           onChange={(e) => {setPostanskiBroj(e.target.value)}}
                />
            </div>

            <div align={'center'} style={{marginTop:20}}>
                <Button
                    variant="contained"
                    color="primary"
                    onClick={() => {
                        const data = {
                            ime:ime,
                            prezime:prezime,
                            razlogZalbe:[checkedTip1, checkedTip2, checkedTip3],
                            ulicaPodnosioca:ulicaPodnosioca,
                            brojUlicePodnosioca:brojUlicePodnosioca,
                            gradPodnosioca:gradPodnosioca,
                            postanskiBroj:postanskiBroj,
                            nazivOrgana:nazivOrgana,
                            datumPodnosenja:datumPodnosenja,
                            podaciOZahtevu:podaciOZahtevu
                        }
                        props.sendZalbaOdlukaData(data);
                    }}
                >
                    Поднеси
                </Button>
            </div>
        </React.Fragment>
    );

};

export default ZalbaCutanje;