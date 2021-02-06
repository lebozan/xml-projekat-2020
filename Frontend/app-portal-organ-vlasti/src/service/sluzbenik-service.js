import axios from 'axios';

const url = "localhost:8085";

class SluzbenikService {

   static getZahtevi() {
      return new Promise((resolve, reject) =>
         axios.get(url)
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

export default SluzbenikService;