package ftn.xml.ServisOrganVlasti.service;

import ftn.xml.ServisOrganVlasti.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ZalbaNaOdlukuService {

    @Autowired
    ZalbaNaOdlukuRepository zalbaNaOdlukuRepository;

    public Object readZalbaNaOdluku(String documentId) {

        return zalbaNaOdlukuRepository.findZalbaNaOdluku(documentId);
    }

    public boolean writeZalbaNaOdluku(String fileName) {

        return zalbaNaOdlukuRepository.saveZalbaNaOdluku(fileName);
    }

    public void writeZalbaNaOdlukuXml(String documentId, String xml) throws Exception {
        zalbaNaOdlukuRepository.saveZalbaNaOdlukuXml(documentId, xml);
    }

}
