import React from "react";
import PortalContext from "../../context/portal-context";



class AddObavestenje extends React.Component {
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
                        <h1>AddObavestenje</h1>
                    </div>
                )}
            </PortalContext.Consumer>
        )
    }
};

export default AddObavestenje;