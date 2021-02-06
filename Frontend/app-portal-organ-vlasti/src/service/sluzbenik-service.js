import axios from 'axios';

const url = '/api/api/zahtev/';

export class SluzbenikService {
   static getZahtevi() {
      return new Promise((resolve, reject) =>
         axios.get(url + "getAll")
           .then(res => {
               if (res.status === 200) {
                   resolve(res.data);
               } else {
                   reject("Error getting products!");
               }
           })
      );
   };
};
