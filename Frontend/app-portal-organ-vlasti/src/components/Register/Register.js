import React from "react";
import {Button, TextField} from "@material-ui/core";
import AuthService from "../../service/auth-service";

const Register = (props) => {
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [firstName, setFirstName] = React.useState('');
    const [lastName, setLastName] = React.useState('');

    const register = () => {
        if (username === '' || password === '' || firstName === '' || lastName === '') {
            return;
        }
        let xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<korisnik xmlns=\"http://www.ftn.un.ac.rs/korisnik\"\n" +
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" id_korisnika='" + Math.floor(Math.random() * 10000) + 4 + "'>\n" +
            "    <korisnicko_ime>" + username + "</korisnicko_ime>\n" +
            "    <lozinka>" + password + "</lozinka>\n" +
            "    <ime>" + firstName + " " + lastName + "</ime>\n" +
            "    <tip_korisnika>korisnik</tip_korisnika>\n" +
            "    <uloga>gradjanin</uloga>\n" +
            "</korisnik>";

        AuthService.register(xml).then(
            (response) => {
                console.log(response.status);
                props.history.push('/login')
            }, (error) => {
                console.log(error);
                props.history.push('/login')
            });
    }

    return (
        <div align={'center'} style={{width:450, position: "absolute", left:'40%', marginTop: 150, borderRadius: 20, padding: 20, backgroundColor: "lightgray"}}>
            Enter your personal information
            <TextField style={{width:400}} id="username" label="Username" variant="filled"
                       value={username} onChange={(e)=> {setUsername(e.target.value)}}
            />
            <TextField type={'password'} style={{width:400}} id="password" label="Password" variant="filled"
                       value={password} onChange={(e)=> {setPassword(e.target.value)}}
            />
            <TextField style={{width:190, marginRight:20}} id="fname" label="First name" variant="filled"
                       value={firstName} onChange={(e)=> {setFirstName(e.target.value)}}
            />
            <TextField style={{width:190}} id="lname" label="Last name" variant="filled"
                       value={lastName} onChange={(e)=> {setLastName(e.target.value)}}
            />
            <Button style={{marginTop:10}} variant="contained" color="primary" onClick={register}>Register</Button>
        </div>
    );
};

export default Register;
