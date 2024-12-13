# Requests Microservice

## Description
Ce projet permet d'ajouter et de récupérer des requêtes via des endpoints REST. Le microservice a été généré avec [Spring Initializr](https://start.spring.io/).

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

L'application sera accessible sur `http://localhost:8084`.

## Endpoints

### GET /requests
Pour récupérer la liste de toutes les requêtes :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8084/requests
   ```
5. Cliquez sur `Send`.

### GET /requests/{id}
Pour récupérer une requête par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8084/requests/{id}
   ```
5. Cliquez sur `Send`.

### POST /requests
Pour créer ou mettre à jour une requête :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8084/requests
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails de la requête, par exemple :
   ```json
   {
      "userId": 1,
      "objectOfRequest": "New",
      "textOfRequest": "Request Text",
      "validated": false
   }
   ```
8. Cliquez sur `Send`.

### DELETE /requests/{id}
Pour supprimer une requête par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8084/requests/{id}
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
spring.application.name=Requests
spring.datasource.url=jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_037
spring.datasource.username=projet_gei_037
spring.datasource.password=Oo3Loh1g
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8084
spring.jpa.properties.hibernate.packagesToScan=com.example.package
