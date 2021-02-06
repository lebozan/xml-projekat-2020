import React, {Component} from 'react';
import {
    Route,
} from "react-router-dom";
import CreateZalbaOdluka from "./ZalbaNaOdluku/CreateZalbaOdluka";
import CreateZalbaCutanje from "./ZalbaNaCutanje/CreateZalbaCutanje";


class SafeComponent extends Component {
    render() {
        return (
            <div>
                <main>
                    <Route component={CreateZalbaOdluka} path="/safe/createZalbaOdluka" />
                    <Route component={CreateZalbaCutanje} path="/safe/createZalbaCutanje" />
                </main>
            </div>
        );
    }
}

export default SafeComponent;
