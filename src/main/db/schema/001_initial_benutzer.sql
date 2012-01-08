-- creates user 'admin' with password 'secret'
-- see ShaPasswordEncoder.mergePasswordAndSalt
insert into benutzer (benutzername, password_hash, password_salt,
                      aktiv, ist_mitarbeiter, ist_verwaltung,
                      nachname)
              values ('admin', 'b3dc84d945ccc42a3f6a884a47223867bb952ce6' , '847fdjndr9-&a',
                      true, true, true,
                      'X');
