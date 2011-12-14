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

== Server starten

    $ mvn jetty:run

Dann http://localhost:8080 aufrufen, da sollte die EasyLunch-
Startseite angezeigt werden.

== Dokumentation

Webframework:
http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/mvc.html
