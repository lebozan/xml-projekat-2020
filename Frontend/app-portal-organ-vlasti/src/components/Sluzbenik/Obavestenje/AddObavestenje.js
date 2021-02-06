import React from "react";
import PortalContext from "../../../context/portal-context";
import { DateTime } from "react-datetime-bootstrap";


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
                    <div class="main-container add-obav">
                        <h2>Obavestenje</h2>
                        <div className="mt-5">
                            <span>Izaberite dan</span>
                            <DateTime pickerOptions={{format:"LL"}} value="2017-04-20"/>
                            <span>Izaberite vreme</span>
                            <DateTime pickerOptions={{format:"LTS"}}/>
                        </div>

                    </div>
                )}
            </PortalContext.Consumer>
        )
    }
};

export default AddObavestenje;