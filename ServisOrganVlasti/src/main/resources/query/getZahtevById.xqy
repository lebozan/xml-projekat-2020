xquery version "3.1";

declare namespace zahtev = "http://www.ftn.un.ac.rs/zahtev";
declare namespace zahtevi = "http://www.ftn.un.ac.rs/zahtevi";

for $k in doc("/db/zahtev/zahtevi.xml")
return $k