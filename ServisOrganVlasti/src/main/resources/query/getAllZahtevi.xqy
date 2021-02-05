declare namespace zahtev = "http://www.ftn.un.ac.rs/zahtev";

for $k in doc ("/db/zahtev/korisnici.xml")/korisnici:korisnici/korisnik:korisnik
where $k/korisnik:tip_korisnika="korisnik" and $k/@id_korisnika="%s"
return $k