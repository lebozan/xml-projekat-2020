xquery version "3.1";

declare namespace zahtevi = "http://www.ftn.un.ac.rs/zahtevi";

for $z in doc("/db/zahtev/zahtevi.xml")
return $z