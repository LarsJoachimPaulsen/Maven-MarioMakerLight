# Maven-MarioMakerLight

NB!! 
  PASS PÅ AT DERE IKKE COMMITER MED XML FILENE SOM LIGGER I .IDE-MAPPA! KUN POM.XML SKAL MED! 
NB!!  

For å starte builds og dependencies i Maven:
  Husk å enable auto imports! 
  Trykk på Maven på høyre side av IDE, åpne clean. Velg Clean:Clean trykk på play-knappen. Velg compiler -> compiler:compile trykk play-knappen. 
  For å sette opp JavaFX uten å måtte laste ned JavaFX 14 og legge in path variabler: 
  Trykk på edit configuration -> + (øverst i venstre hjørne) -> maven -> finn before launch(helt nederst i det store vinduet) -> trykk + 
  -> maven goal -> i commandline skriv javafx:compile -> OK -> gå øverst i skjermvinduet velg command line -> skriv javafx:run -> gi navn 
  -> apply -> OK 


Dokumentasjon for dyn4j: http://www.dyn4j.org/documentation/getting-started/#Maven

# Initial start up of the framework
 
The framework is built in the dependency management system Maven. 
To use the frameworks existing dependencies, as well as expanding it with new dependencies is as easy as adding them to the pom.xml-file.
New dependencies can be found on https://mvnrepository.com/. The easiest way to get the framework to start, is to open the pom.xml-file, 
located in the main folder, and allowing for auto-importing. 
