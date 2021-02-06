import React from "react";
import PortalContext from "../../context/portal-context";



class Obavestenje extends React.Component {
    static contextType = PortalContext;
    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {
        return (
            <PortalContext.Consumer>
                { context => (
                    <div class="main-container">
                        <h1>Obavestenje</h1>
                    </div>
                )}
            </PortalContext.Consumer>
        )
    }
};

export default Obavestenje;