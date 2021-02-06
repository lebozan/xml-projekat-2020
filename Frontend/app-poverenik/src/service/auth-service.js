import axios from "axios";

const url = '/api/auth/';

export default class AuthService {
    static login(xml) {
        return new Promise((resolve, reject) =>
            axios.post(url + 'login', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res);
                    } else {
                        reject("Error getting zahtev!");
                    }
                })
        );
    };

    static register(xml) {
        return new Promise((resolve, reject) =>
            axios.post(url + 'register', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res);
                    } else {
                        reject("Error!");
                    }
                })
                .catch(
                    error => {
                        console.log('Error status: ' + error.status);
                    }
                )
        );
    };
}
