package ftn.xml.ServisOrganVlasti.soap;

import ftn.xml.ServisOrganVlasti.repository.ZahtevRepository;
import ftn.xml.ServisOrganVlasti.soap.zahtev.GetZahtevRequest;
import ftn.xml.ServisOrganVlasti.soap.zahtev.GetZahtevResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ZahtevEndpoint {
    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/zahtev/soap";

    @Autowired
    ZahtevRepository zahtevRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZahtevRequest")
    @ResponsePayload
    public GetZahtevResponse getZahtev(@RequestPayload GetZahtevRequest request) {
        GetZahtevResponse response = new GetZahtevResponse();
        response.setZahtevZaPristupInformacijama(zahtevRepository.findZahtevClass(request.getId()));

        return response;
    }

}
