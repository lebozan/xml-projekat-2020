import axios from 'axios';

const url = '/api/api/zalbaNaOdluku';

export default class ZalbaOdlukaService {

    static postZalbaOdluka(xml){
        return new Promise((resolve, reject) =>
            axios.post(url + '/createZalbaOdluka', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res.data);
                    } else {
                        reject("Error posting zalba na odluku!");
                    }
                })
        );

    }
}
