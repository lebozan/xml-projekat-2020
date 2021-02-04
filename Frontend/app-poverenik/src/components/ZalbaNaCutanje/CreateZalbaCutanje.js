import React from "react"
import ZalbaCutanje from "./ZalbaCutanje";
import ZalbaCutanjeService from "../../service/zalbaCutanje-service";

const CreateZalbaCutanje = () => {

    const createZalbaCutanjeXml = (data) => {
        console.log(data);
        let xml = ''
    }

    return (
        <div>
            <ZalbaCutanje sendZalbaOdlukaData={createZalbaCutanjeXml}/>
        </div>

    );

}

export default CreateZalbaCutanje;