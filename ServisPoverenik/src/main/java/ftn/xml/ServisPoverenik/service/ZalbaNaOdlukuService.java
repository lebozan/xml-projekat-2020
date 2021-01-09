package ftn.xml.ServisPoverenik.service;

import ftn.xml.ServisPoverenik.repository.ZalbaNaOdlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
