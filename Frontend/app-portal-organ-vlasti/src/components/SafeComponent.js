import React, {Component} from 'react';
import {
    Route, Switch,
} from "react-router-dom";
import CreateZahtev from "./Zahtev/CreateZahtev";
import Sluzbenik from "./Sluzbenik/Sluzbenik";
import AddObavestenje from "./Sluzbenik/Obavestenje/AddObavestenje";


class SafeComponent extends Component {
    render() {
        return (
            <div>
                <main>
                    <Route component={CreateZahtev} exact path='/safe/createZahtev'/>
                    <Route component={CreateZahtev} path="/safe/createZahtev" />
                    <Route component={Sluzbenik} path="/safe/sluzbenik" />
                    <Route component={AddObavestenje} path="/safe/addObavestenje" />
                </main>
            </div>
        );
    }
}

export default SafeComponent;
