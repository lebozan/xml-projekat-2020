xquery version "3.1";


declare namespace korisnici = "http://www.ftn.un.ac.rs/korisnik";


    for $korisnik in collection("/db/sample/library/")/korisnici:korisnici
    return $korisnik