
create table benutzer (
    id serial primary key,
    benutzername varchar(255) unique not null,
    password_hash varchar(255),
    password_salt varchar(255),
    aktiv boolean not null default false,
    personal_nummer varchar(255),
    titel varchar(255),
    vorname varchar(255),
    nachname varchar(255) not null,
    ist_mitarbeiter boolean not null default false,
    ist_verwaltung boolean not null default false,
    ist_gast boolean not null default false
);

create index benutzer_nachname_index on benutzer (lower(nachname));
create index benutzer_personal_nummer_index on benutzer (lower(personal_nummer));

create table bild (
    id serial primary key,
    data bytea not null,
    filename varchar(255) not null
);

create table speise (
    id serial primary key,
    name varchar(255) not null,
    beschreibung varchar(2048),
    art varchar(255) not null,
    bild_id integer references bild (id) on delete set null,
    im_sortiment_ab date not null,
    im_sortiment_bis date not null,
    preis numeric(10, 2) not null,
    lagerstand integer not null default 0,
    check (art in ('Vorspeise', 'Hauptspeise', 'Nachspeise'))
);

create table bestellung (
    id serial primary key,
    kosumationszeitpunkt timestamp not null,
    ausgabezeitpunkt timestamp,
    ausgabepreis numeric(10, 2),
    storniert boolean not null default false,
    bestätigt boolean not null default false,
    benutzer_id integer not null references benutzer (id),
    speise_id integer not null references speise (id)
);
