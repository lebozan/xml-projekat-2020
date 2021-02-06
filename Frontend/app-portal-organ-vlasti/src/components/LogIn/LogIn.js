import React from "react";
import {Button, Link, TextField} from "@material-ui/core";
import AuthService from "../../service/auth-service";
import jwtDecode from "jwt-decode";

const LogIn = () => {
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');

    const login = () => {
        let xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<korisnik xmlns=\"http://www.ftn.un.ac.rs/korisnik\"\n" +
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "    <korisnicko_ime>" + username + "</korisnicko_ime>\n" +
            "    <lozinka>" + password + "</lozinka>\n" +
            "    <ime></ime>\n" +
            "    <tip_korisnika></tip_korisnika>\n" +
            "    <uloga></uloga>\n" +
            "</korisnik>";

        AuthService.login(xml).then(
            (response) => {
                console.log(jwtDecode(response.headers.token));
                localStorage.setItem("tokenOrganVlasti", response.headers.token);

            }, (error) => {
                console.log(error);
            });
    }

    return (
        <div align={'center'} style={{width:450, position: "absolute", left:'40%', marginTop: 200, borderRadius: 20, padding: 20, backgroundColor: "lightgray"}}>
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
