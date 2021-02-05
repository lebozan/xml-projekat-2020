import axios from 'axios';

const url = '/api/resenje';

export default class ResenjeService {

    static postResenje(xml){
        return new Promise((resolve, reject) =>
            axios.post(url + '/xml/testResenje', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res.data);
                    } else {
                        reject("Error posting resenje!");
                    }
                })
        );

    }
}