xquery version "3.1";

declare namespace korisnici = "http://www.ftn.un.ac.rs/korisnici";

for $korisnici in doc("/db/organVlastiKorisnici/korisnici.xml")/korisnici:korisnici
return $korisnici