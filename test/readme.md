Je vous remercie pour l'examen de ce test.

Pour lancer le projet, se placer à la source du projet (où se trouve le pom.xml):
lancer la commande
_mvn clean install_

Maven va effectuer et un build et, après tests, générer une image docker grâce au dockerfile-maven-plugin et au Dockerfile.

Toujours depuis la source, lancer:
_docker-compose up_

Docker va instancier 2 containers:
- 1 pour la base de données répertoriant les salles et leurs évènements
- 1 pour l'API Rest

Pour lancer le front, se déplacer dans le répertoire ocsin-front et lancer:
_ng serve_

Vous pouvez vous rendre sur http://localhost:4200 pour vous rendre sur la liste des salles


####  Composition / services
  * Une API Rest
  * Une application Client
  * Une base de donnée

#### Stack 
 
 Base de données: Postgresql
 
 API Rest: Java 8, Spring Boot, Hibernate/JPA,
 
 Client: Angular, Bootstrap, HTML, CSS
 
 Configuration, DevOps: Docker, Maven
 
#### Différentes URLs pour tester l'API:

Un CommandLineRunner à la base de l'application est implémenté pour initialiser quelques données au démarrage:


* #####enregistrer un évènement:

POST
http://localhost:9001/events/

ex:
_{
	"time": "2019-07-30T16:27:32",
    "event": "motion:off",
	"room": "salle_1"
}_

* #####recevoir le dernier évènement dde salle la salle 1 

GET
http://localhost:9001/events/last/1

* #####recevoir l'historique des évènements de salle la salle 1 

GET
http://localhost:9001/rooms/history/1

* #####recevoir l'ensemble des salles ayant reçu au moins un évènement

GET
http://localhost:9001/rooms/

* #####recevoir l'ensemble des salles ayant contenant l'expression "sa"

GET
http://localhost:9001/rooms/sa
