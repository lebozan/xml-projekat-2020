package ftn.xml.ServisPoverenik.service;

import ftn.xml.ServisPoverenik.repository.ZalbaNaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZalbaNaCutanjeService {

    @Autowired
    ZalbaNaCutanjeRepository zalbaNaCutanjeRepository;

    public Object readZalbaNaCutanje(String documentId) {

        return zalbaNaCutanjeRepository.findZalbaNaCutanje(documentId);
    }

    public boolean writeZalbaNaCutanje(String fileName) {

        return zalbaNaCutanjeRepository.saveZalbaNaCutanje(fileName);
    }

    public void writeZalbaNaCutanjeXml(String documentId, String xml) throws Exception {
        zalbaNaCutanjeRepository.saveZalbaNaCutanjeXml(documentId, xml);
    }

}
