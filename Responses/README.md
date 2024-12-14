# Responses Microservice

## Description
Ce projet permet d'ajouter et de récupérer des réponses via des endpoints REST. Le microservice a été généré avec [Spring Initializr](https://start.spring.io/).

## Prérequis
- Java 17
- Maven
- MySQL

## Build et Lancement

### Build
Pour compiler le projet, exécutez la commande suivante à la racine du projet :
```sh
./mvnw clean install
```

### Lancer l'application
Pour lancer l'application, exécutez la commande suivante à la racine du projet :
```sh
./mvnw spring-boot:run
```

L'application sera accessible sur `http://localhost:8085`.

## Endpoints

### GET /responses
Pour récupérer la liste de toutes les réponses :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8085/responses
   ```
5. Cliquez sur `Send`.

### GET /responses/{id}
Pour récupérer une réponse par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8085/responses/{id}
   ```
5. Cliquez sur `Send`.

### POST /responses
Pour créer une nouvelle réponse :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8085/responses
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails de la réponse, par exemple :
   ```json
   {
      "volunteerId": 1,
      "requestId": 1,
      "textOfResponse": "Response Text"
   }
   ```
8. Cliquez sur `Send`.

### DELETE /responses/{id}
Pour supprimer une réponse par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8085/responses/{id}
   ```
5. Cliquez sur `Send`.

## Initialisation de la base de données

Pour initialiser la base de données, exécutez le script `initiate_database.py` :
```sh
python /c:/Users/noelj/Desktop/ProjetArchitectureService/database/initiate_database.py
```

Ce script exécutera les commandes SQL définies dans `init.sql` pour créer les tables nécessaires.

## Configuration

Les configurations de la base de données et du serveur sont définies dans le fichier `application.properties` :
```properties
spring.application.name=Responses
spring.datasource.url=jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_037
spring.datasource.username=projet_gei_037
spring.datasource.password=Oo3Loh1g
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8085
spring.jpa.properties.hibernate.packagesToScan=com.example.package
```