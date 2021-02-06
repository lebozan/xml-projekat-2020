import React from "react";
import {Button, Link, TextField} from "@material-ui/core";
import AuthService from "../../service/auth-service";
import jwtDecode from "jwt-decode";

const LogIn = (props) => {
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');



    const login = () => {
        let xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<korisnik xmlns=\"http://www.ftn.un.ac.rs/korisnik\"\n" +
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" id_korisnika=\"76204\">\n" +
            "    <korisnicko_ime>" + username + "</korisnicko_ime>\n" +
            "    <lozinka>" + password + "</lozinka>\n" +
            "    <ime></ime>\n" +
            "    <tip_korisnika></tip_korisnika>\n" +
            "    <uloga></uloga>\n" +
            "</korisnik>";

        AuthService.login(xml).then(
            (response) => {

                let korisnik = jwtDecode(response.headers.token);
                console.log(korisnik);
                checkRole(korisnik.role);
                localStorage.setItem("token", response.headers.token);

            }, (error) => {
                console.log(error);
            });

    }

    const checkRole =  (role) => {
        switch (role) {
            case "sluzbenik":
                console.log(role);
                props.history.push("/sluzbenik");
                break;
            default:
                break;
        }
    }



    return (
        <div align={'center'} style={{width:450, position: "absolute", left:'40%', marginTop: 200, borderRadius: 20, padding: 20, backgroundColor: "whitesmoke"}}>
            Enter your credentials
            <TextField style={{width:400}} id="username" label="Username" variant="filled"
                       value={username} onChange={(e)=> {setUsername(e.target.value)}}
            />
            <TextField type={'password'} style={{width:400}} id="password" label="Password" variant="filled"
                       value={password} onChange={(e)=> {setPassword(e.target.value)}}
            />
            <Link href="/register">Don't have an account? Register now!</Link>
            <br/>
            <Button style={{marginTop:10}} variant="contained" color="primary" onClick={login}>Login</Button>
        </div>
    );
};

export default LogIn;


