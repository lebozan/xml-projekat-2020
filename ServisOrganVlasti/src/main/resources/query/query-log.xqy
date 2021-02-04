declare namespace korisnik = "http://www.ftn.un.ac.rs/korisnik";
declare namespace korisnici = "http://www.ftn.un.ac.rs/korisnik";


for $k in doc ("/db/sample/library/korisnici.xml")/korisnici:korisnici/korisnik:korisnik
where $k/korisnik:korisnicko_ime ="%s"
return $k