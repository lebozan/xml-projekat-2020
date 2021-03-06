import axios from 'axios';

const url = '/api/zalbaNaCutanje';

export default class ZalbaCutanjeService {

    static postZalbaCutanje(xml){
        return new Promise((resolve, reject) =>
            axios.post(url + '/xml/testZalbaNaCutanje', xml, {headers: {'content-type': 'application/xml'}})
                .then(res => {
                    if (res.status === 200) {
                        resolve(res.data);
                    } else {
                        reject("Error posting zalba na cutanje!");
                    }
                })
        );

    }
}