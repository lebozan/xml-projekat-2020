import React, {Component} from 'react';
import {
    Route,
} from "react-router-dom";
import CreateZahtev from "./Zahtev/CreateZahtev";


class SafeComponent extends Component {
    render() {
        return (
            <div>
                <main>
                    <Route component={CreateZahtev} exact path={'/safe/createZahtev'}></Route>
                </main>
            </div>
        );
    }
}

export default SafeComponent;
