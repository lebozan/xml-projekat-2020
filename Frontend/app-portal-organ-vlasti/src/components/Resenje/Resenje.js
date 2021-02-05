import React from 'react';
import {Button, TextField} from "@material-ui/core";

const Resenje = (props) => {
    const [brojZahteva, setBrojZahteva] = React.useState('');
    const [trazilacInformacija, setTrazilacInformacija] = React.useState('');
    const [datumPodnosenjaZalbe, setDatumPodnosenjaZalbe] = React.useState('');

    return(
        <React.Fragment>
            <div align={'center'} style={{marginTop:20}}>
                <h2> РЕШЕЊЕ </h2>
                <p>одбија се захтев: </p>
                <TextField required id="brojZahteva" label="Broj zahteva" variant="outlined"
                           value={brojZahteva}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setBrojZahteva(e.target.value)}}
                />
            </div>
            <div align={'center'} style={{marginTop:20}}>
                <h4>О б р а з л о ж е њ е</h4>
                <TextField required id="trazilacInformacija" label="Trazilac informacija" variant="outlined"
                           value={trazilacInformacija}
                           style={{marginLeft:20, minWidth:250}}
                           onChange={(e) => {setTrazilacInformacija(e.target.value)}}
                />
                <TextField required id="datumPodnosenja" label="Datum podnosenja zalbe" variant="outlined"
                           value={datumPodnosenjaZalbe}
                           style={{marginLeft:20, minWidth:50}}
                           onChange={(e) => {setDatumPodnosenjaZalbe(e.target.value)}}
                />
            </div>

            //TODO:dovrsi page

        </React.Fragment>
    );

};

export default Resenje;