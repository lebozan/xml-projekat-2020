import * as React from "react";
import PoverenikContext from '../../context/poverenik-context'

import { Navbar, Nav, NavDropdown, Form, FormControl, Button } from "react-bootstrap";


import "./Navigation.css";
import {Link} from "react-router-dom";

class Navigation extends React.Component {
    static contextType = PoverenikContext;

    render() {
            
        return (
            
        <PoverenikContext.Consumer>
            {context => (
                <Navbar bg="light" expand="lg">
                <Navbar.Brand href="#home">Servis poverenika</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                  <Nav className="mr-auto">
                    <Nav.Link href="#home">Home</Nav.Link>
                      <Nav.Link href="/safe/createZalbaCutanje">Zalba na cutanje</Nav.Link>
                      <Nav.Link href="/safe/createZalbaOdluka">Zalba na odluku</Nav.Link>
                    <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                      <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                      <NavDropdown.Divider />
                      <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                    </NavDropdown>
                  </Nav>
                    <Link to="/login" className="ml-auto">
                        <Button variant="outline-primary">LogIn</Button>
                    </Link>
                </Navbar.Collapse>
              </Navbar>
            )}
        </PoverenikContext.Consumer>
        );
        
    }
};

export default Navigation;


