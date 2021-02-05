import axios from 'axios';

const url = '/api/api/zahtev';

export default class ZahtevService {

    static getZahtev(documentId) {
        return new Promise((resolve, reject) =>
            axios.get(url + '/read?documentId=' + documentId)
                .then(res => {
                    if (res.status === 200) {
                        resolve(res.data);
                    } else {
                        reject("Error getting zahtev!");
                    }
                })
        );
    };

    static postZahtev(xml) {
        return new Promise((resolve, reject) =>
            axios.post(url + '/createZahtev', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res.data);
                    } else {
                        reject("Error posting zahtev!");
                    }
                })
                .catch(
                    error => {
                        console.log(error);
                    }
                )
        );
    }
}
