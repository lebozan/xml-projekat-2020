package ftn.xml.ServisPoverenik.service;

import ftn.xml.ServisPoverenik.repository.ResenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenjeService {

    @Autowired
    ResenjeRepository resenjeRepository;


    public Object readResenje(String documentId) {

        return resenjeRepository.findResenje(documentId);
    }

    public boolean writeResenje(String fileName) {

        return resenjeRepository.saveResenje(fileName);
    }

    public void writeResenjeXml(String documentId, String xml) throws Exception {
        resenjeRepository.saveResenjeXml(documentId, xml);
    }
}
