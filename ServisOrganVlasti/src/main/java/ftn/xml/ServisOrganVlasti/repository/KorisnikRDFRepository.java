package ftn.xml.ServisOrganVlasti.repository;

import ftn.xml.ServisOrganVlasti.model.korisnici.Korisnici;
import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.rdf.AuthenticationProperties;
import ftn.xml.ServisOrganVlasti.util.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class KorisnikRDFRepository {
    @Autowired
    private AuthenticationProperties con;

    @Autowired
    private SparqlUtil sparql;


    public void saveRdf(Korisnici korisnici) throws FileNotFoundException {
        Model m = ModelFactory.createDefaultModel();
        for (Korisnik i : korisnici.getKorisnik()) {
            this.makeRdf(m, i);
        }

        writeInFile(m);
        ByteArrayOutputStream os = new ByteArrayOutputStream();


        m.write(os, sparql.NTRIPLES);

        String upit = sparql.unesiPodatke(con.getDataEndpoint() + "/" + "korisnici",
                new String(os.toByteArray()));

        System.out.println(upit);
        UpdateRequest izmena = UpdateFactory.create(upit);
        UpdateProcessor processor  = UpdateExecutionFactory.createRemote(izmena, con.getUpdateEndpoint());
        processor.execute();





    }

    private void writeInFile(Model m) throws FileNotFoundException {
        OutputStream os = new FileOutputStream(new File("src/main/resources/xmlFiles/rdf/korisnici.rdf"));

        m.write(System.out);
        m.write(os, "RDF/XML-ABBREV");



    }

    public void makeRdf(Model m, Korisnik k) {
        String uri = "http://www.ftn.uns.ac.rs/predikati#";
        m.setNsPrefix("p", uri);


        Property ime = m.createProperty(uri + "ime");

        Resource koren = m.createResource(k.getIdKorisnika());
        koren.addProperty(ime, k.getIme());


    }

    public String izveziMetapodatke(String dokument, String format) {
        String end = con.getDataEndpoint();
        String uslovi = "?s ?p ?o";
        String sparqlUpit = sparql.selektujPodatke(end + "/" + dokument, uslovi);

        QueryExecution upit = QueryExecutionFactory.sparqlService(con.getQueryEndpoint(), sparqlUpit);

        ResultSet rezultati = upit.execSelect();

        try {
            String put = "./export/" + dokument + "-" + format + ".txt";
            File file = new File(put);
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();
            FileOutputStream out =
                    new FileOutputStream(file);

            PrintWriter pw = new PrintWriter(new FileWriter(put));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();


            String povratnaVrednost;
            if (format.equals("json")) {
                ResultSetFormatter.outputAsJSON(baos, rezultati);
                povratnaVrednost = baos.toString();
            } else {
                ResultSetFormatter.outputAsXML(baos, rezultati);
                povratnaVrednost = baos.toString();
            }
            pw.write(povratnaVrednost);

            out.close();
            pw.close();
            return povratnaVrednost;

        } catch (IOException e) {
            return "Greska prilikom prezimanja metapodataka";
        }
    }

}
