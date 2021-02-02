import React from "react";
import { Route, Switch } from "react-router-dom";

import Navigation from './Navigation/Navigation'
import Home from "./Home/Home";
import LogIn from "./LogIn/LogIn";
import CreateZahtev from "./Zahtev/CreateZahtev";



const Root = () => {
    // path radi tako sto prepozna dio i ako samo pocinje sa tim onda ga ucita, ako hocemo bas tacan tajh path moramo da stavimo exact
    //primjer kad ne stavljamo exact je ako imamo path komponente koja se nalazi u komponenti npr. /about/our-team
    //ako ne stavimo switch i dvije budu match, pokazace ih sve, a ako ima switch onda prikazje prvu koja bude match pocevsi odozgo
    return (
        <div>
            <Navigation />
            <Switch>
                <Route component={Home} exact path="/" /> 
                <Route component={Home} exact path="/home" /> 
                <Route component={LogIn} exact path="/logIn" />
                <Route component={CreateZahtev} path="/createZahtev" />
            </Switch>
        </div>
    );
};

export default Root;
