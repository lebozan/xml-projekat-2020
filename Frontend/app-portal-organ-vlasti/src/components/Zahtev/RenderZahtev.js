import React from 'react';
import {Button, Checkbox, FormControlLabel, TextField} from "@material-ui/core";

const tipoviZahteva = ["Obaveštenje da li poseduje traženu informaciju", "Uvid u dokument koji sadrži traženu infomaciju",
    "Kopiju dokumenta koji sadrži traženu informaciju", "Dostavljanje kopije dokumenta koji sadrži traženu informaciju"];
const tipoviDostave = ["poštom", "elektronskom poštom", "faksom", "na drugi način***:"];

const RenderZahtev = (props) => {
    const [nazivOrgana, setNazivOrgana] = React.useState('');
    const [sedisteOrgana, setSedisteOrgana] = React.useState('');
    const [checkedTip1, setCheckedTip1] = React.useState(false);
    const [checkedTip2, setCheckedTip2] = React.useState(false);
    const [checkedTip3, setCheckedTip3] = React.useState(false);
    const [checkedTip4, setCheckedTip4] = React.useState(false);
    const [checkDostava1, setCheckDostava1] = React.useState(false);
    const [checkDostava2, setCheckDostava2] = React.useState(false);
    const [checkDostava3, setCheckDostava3] = React.useState(false);
    const [checkDostava4, setCheckDostava4] = React.useState(false);
    const [customDostava, setCustomDostava] = React.useState('');
    const [zahtevInfo, setZahtevInfo] = React.useState('');

    const isTipSelected = (index) => {
        if (index === 1) {
            setCheckedTip1(!checkedTip1);
            setCheckedTip2(false);
            setCheckedTip3(false);
            setCheckedTip4(false);
        } else if (index === 2) {
            setCheckedTip2(!checkedTip2);
            setCheckedTip1(false);
            setCheckedTip3(false);
            setCheckedTip4(false);
        } else if (index === 3) {
            setCheckedTip3(!checkedTip3);
            setCheckedTip1(false);
            setCheckedTip2(false);
            setCheckedTip4(false);
        } else if (index === 4) {
            setCheckedTip4(!checkedTip4);
            setCheckedTip1(false);
            setCheckedTip2(false);
            setCheckedTip3(false);
        }
    }

    const isDostavaSelected = (index) => {
        if (index === 1) {
            setCheckDostava1(!checkDostava1);
            setCheckDostava2(false);
            setCheckDostava3(false);
            setCheckDostava4(false);
        } else if (index === 2) {
            setCheckDostava2(!checkDostava2);
            setCheckDostava1(false);
            setCheckDostava3(false);
            setCheckDostava4(false);
        } else if (index === 3) {
            setCheckDostava3(!checkDostava3);
            setCheckDostava1(false);
            setCheckDostava2(false);
            setCheckDostava4(false);
        } else if (index === 4) {
            setCheckDostava4(!checkDostava4);
            setCheckDostava1(false);
            setCheckDostava2(false);
            setCheckDostava3(false);
        }
    }


    return (
        <React.Fragment>
            <div align={'center'} style={{marginTop:20}}>

                <p>Uneti naziv i sediste organa kome se zahtev upucuje:</p>
                <TextField id="naziv" label="Naziv organa" variant="outlined"
                           value={nazivOrgana}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setNazivOrgana(e.target.value)}}
                />
                <TextField id="naziv" label="Sediste organa " variant="outlined"
                           value={sedisteOrgana}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setSedisteOrgana(e.target.value)}}
                />

                <h2>Zahtev</h2>
                <h4>za pristup informacijama od javnog znacaja</h4>
                <p>На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*</p>
            </div>

            <div align={'left'} style={{marginLeft:50, alignContent:'center', maxWidth:400}}>
                <FormControlLabel
                    key={'formcontrollabel ' + 1}
                    control={
                        <Checkbox
                            key={1}
                            checked={checkedTip1}
                            onChange={() => {isTipSelected(1);}}
                            name={tipoviZahteva[0]}
                            color="primary"
                        />
                    }
                    label={tipoviZahteva[0]}
                />

                <FormControlLabel
                    key={'formcontrollabel ' + 2}
                    control={
                        <Checkbox
                            key={2}
                            checked={checkedTip2}
                            onChange={() => {isTipSelected(2);}}
                            name={tipoviZahteva[1]}
                            color="primary"
                        />
                    }
                    label={tipoviZahteva[1]}
                />

                <FormControlLabel
                    key={'formcontrollabel ' + 3}
                    control={
                        <Checkbox
                            key={3}
                            checked={checkedTip3}
                            onChange={() => {isTipSelected(3);}}
                            name={tipoviZahteva[2]}
                            color="primary"
                        />
                    }
                    label={tipoviZahteva[2]}
                />

                <FormControlLabel
                    key={'formcontrollabel ' + 4}
                    control={
                        <Checkbox
                            key={4}
                            checked={checkedTip4}
                            onChange={() => {isTipSelected(4);}}
                            name={tipoviZahteva[3]}
                            color="primary"
                        />
                    }
                    label={tipoviZahteva[3]}
                />
            </div>
            {checkedTip4 ?
                <div align={'left'} style={{marginLeft:100}}>
                    <FormControlLabel
                        key={'formcontrollabel ' + 5}
                        control={
                            <Checkbox
                                key={5}
                                checked={checkDostava1}
                                onChange={() => {isDostavaSelected(1);}}
                                name={tipoviDostave[0]}
                                color="primary"
                            />
                        }
                        label={tipoviDostave[0]}
                    />
                    <FormControlLabel
                        key={'formcontrollabel ' + 6}
                        control={
                            <Checkbox
                                key={6}
                                checked={checkDostava2}
                                onChange={() => {isDostavaSelected(2);}}
                                name={tipoviDostave[1]}
                                color="primary"
                            />
                        }
                        label={tipoviDostave[1]}
                    />
                    <FormControlLabel
                        key={'formcontrollabel ' + 7}
                        control={
                            <Checkbox
                                key={7}
                                checked={checkDostava3}
                                onChange={() => {isDostavaSelected(3);}}
                                name={tipoviDostave[2]}
                                color="primary"
                            />
                        }
                        label={tipoviDostave[2]}
                    />
                    <FormControlLabel
                        key={'formcontrollabel ' + 8}
                        control={
                            <Checkbox
                                key={8}
                                checked={checkDostava4}
                                onChange={() => {isDostavaSelected(4);}}
                                name={tipoviDostave[3]}
                                color="primary"
                            />
                        }
                        label={tipoviDostave[3]}
                    />
                    <TextField id="customDostava" label="Uneti način dostave" variant="outlined"
                               value={customDostava}
                               disabled={!checkDostava4}
                               onChange={(e) => {setCustomDostava(e.target.value)}}
                    />
                </div>
                : null}

            <div align={'center'}>
                <TextField
                    id="zahtevInfo"
                    label="Navesti precizan opis informacije koja se trazi"
                    multiline
                    rows={2}
                    variant="outlined"
                    fullWidth
                    value={zahtevInfo}
                    onChange={(e) => {setZahtevInfo(e.target.value)}}
                    style={{maxWidth:1300, marginTop:50, marginBottom:50}}
                />
            </div>
            <Button
                style={{left:'50%', marginBottom:50}}
                variant="contained"
                color="primary"
                onClick={() => {
                    const data = {
                        nazivOrgana:nazivOrgana,
                        sedisteOrgana:sedisteOrgana,
                        zahtevInfo:zahtevInfo,
                        tipZahteva:[checkedTip1, checkedTip2, checkedTip3, checkedTip4],
                        tipDostave:[checkDostava1, checkDostava2, checkDostava3, checkDostava4],
                        customDostava: customDostava,
                    }
                    props.sendZahtevData(data);
                }}
            >
                Submit
            </Button>

        </React.Fragment>

    );
};

export default RenderZahtev;
