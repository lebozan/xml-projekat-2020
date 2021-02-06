import * as React from "react";
import PortalContext from '../../context/portal-context'
import { Navbar, Button } from "react-bootstrap";


import "./Navigation.css";
import { Link } from "react-router-dom";

class Navigation extends React.Component {
    static contextType = PortalContext;


    render() {
            
        return (
            
        <PortalContext.Consumer>
            {context => (
                <Navbar bg="light" expand="lg">
                <Navbar.Brand href="home">Portal - Pristup javnim informacijama</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                  {/* <Nav className="mr-auto">
                    <Nav.Link href="#home">Home</Nav.Link>
                    <Nav.Link href="#link">Link</Nav.Link>
                    <Nav.Link href="safe/createZahtev">Zahtev</Nav.Link>
                    <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                      <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                      <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                      <NavDropdown.Divider />
                      <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                    </NavDropdown>
                  </Nav> */}
                  <Link to="/login" className="ml-auto">
                    <Button variant="outline-primary">LogIn</Button>
                  </Link>
                </Navbar.Collapse>
              </Navbar>
            )}
        </PortalContext.Consumer>
        );
        
    }
};

export default Navigation;


