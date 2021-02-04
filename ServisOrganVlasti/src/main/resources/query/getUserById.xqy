declare namespace korisnik = "http://www.ftn.un.ac.rs/korisnik";
declare namespace korisnici = "http://www.ftn.un.ac.rs/korisnici";


for $k in doc ("/db/organVlastiKorisnici/korisnici.xml")/korisnici:korisnici/korisnik:korisnik
where $k/korisnik:tip_korisnika="korisnik" and $k/@id_korisnika="%s"
return $k