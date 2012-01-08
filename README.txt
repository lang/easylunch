= Setup

== Maven 3.0.3 installieren

Anleitung: http://maven.apache.org/download.html

Besonders beim ersten Aufruf von Maven (mvn) werden
viele Dateien heruntergeladen. Sollte dies wiederholt
fehlschlagen, kann man versuchen einen anderen Mirror
zu konfigurieren. Dazu folgendes in $HOME/.m2/settings.xml
schreiben (nur der erste mirror eintrag ist relevant):

    <settings>
      <mirrors>
        <mirror>
          <id>ibiblio.org</id>
          <url>http://mirrors.ibiblio.org/pub/mirrors/maven2</url>
          <mirrorOf>central</mirrorOf>
        </mirror>
        <mirror>
          <id>UK</id>
          <name>UK Central</name>
          <url>http://uk.maven.org/maven2</url>
          <mirrorOf>central</mirrorOf>
        </mirror>
      </mirrors>
    </settings>

== Datenbank einrichten

PostgreSQL-Server installieren und starten. Eine Datenbank mit Namen
"easylunch" erstellen.

Ubuntu erstellt bei Installation des postgresql Servers sowohl einen
System-Benutzer als auch einen DB-Benutzer mit Namen "postgres". Das
Passwort des DB-Benutzers kann folgendermaßen gesetzt werden:

    $ sudo su postgres
    $ psql
    psql (8.4.9)
    Geben Sie »help« für Hilfe ein.

    postgres=# alter user postgres with password 'secret';

Erstellen der Datenbank (als postgres user):

    $ createdb easylunch

Zum erstellen des Schemas die sql-Dateien in src/main/db/schema der
Reihe nach ausführen. Z.b. im psql-Client:

    easylunch=# \i /some/path/easylunch/src/main/db/schema/000_init.sql
    easylunch=# \i /some/path/easylunch/src/main/db/schema/001_initial_benutzer.sql

datasource_template.xml nach datasource.xml kopieren und vor allem
Benutzername und Password anpassen:

    $ cp src/main/webapp/WEB-INF/datasource_template.xml src/main/webapp/WEB-INF/datasource.xml

== Server starten

    $ mvn jetty:run

Dann http://localhost:8080 aufrufen, da sollte die EasyLunch-
Startseite angezeigt werden.

Mit CTRL+C kann der Server gestoppt werden.

== Dokumentation

Webframework:
http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/mvc.html

Freemarker (Views, z.B. zum HTML-Templates):
http://freemarker.sourceforge.net/docs/ref.html

MyBatis (SQL-Java Mapping)
http://code.google.com/p/mybatis/wiki/UserGuides
