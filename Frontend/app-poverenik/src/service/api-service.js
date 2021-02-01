import axios from 'axios';

const url = "[URL_SA_BACKENDA]";

class ApiService {

    //Primjer
   static getProducts() {
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

export default ApiService;