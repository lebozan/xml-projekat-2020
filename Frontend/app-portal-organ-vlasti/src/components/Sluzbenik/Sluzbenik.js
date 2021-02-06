import React from "react";
import PortalContext from "../../context/portal-context";
import "./Sluzbenik.css";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
import { SluzbenikService } from "../../service/sluzbenik-service.js";



class Sluzbenik extends React.Component {
    static contextType = PortalContext;
    constructor(props) {
        super(props);
        this.state = { zahtevi: ""};
    }

    componentDidMount() {
        this.getZahtevi()
    }

    getZahtevi = () => {
        SluzbenikService.getZahtevi().then(
            (_zahtevi) => {
                let XMLParser = require('react-xml-parser');

                let xml = new XMLParser().parseFromString(_zahtevi);

                this.setState({zahtevi: _zahtevi});
            }
        )
    }

    render() {
        return (
            <PortalContext.Consumer>
                { context => (
                    <div className="main-container container">
                        <h1>Sluzbenik</h1>
                        <Link to="/safe/addObavestenje" >
                            <Button>Dodaj obavestenje</Button>
                        </Link>
                        <Button className="mt-5" onClick={this.getZahtevi}>Daj sve</Button>
                        {this.state.zahtevi}
                    </div>
                )}
            </PortalContext.Consumer>
        )
    }
};

export default Sluzbenik;