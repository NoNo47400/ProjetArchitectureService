# Users Microservice

## Description
Ce projet permet d'ajouter et de récupérer des utilisateurs via des endpoints REST. Le microservice a été généré avec [Spring Initializr](https://start.spring.io/).

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

L'application sera accessible sur `http://localhost:8082`.

## Endpoints

### GET /users
Pour récupérer la liste de tous les utilisateurs :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users
   ```
5. Cliquez sur `Send`.

### GET /users/{id}
Pour récupérer un utilisateur par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/{id}
   ```
5. Cliquez sur `Send`.

### POST /users
Pour créer un nouvel utilisateur :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails de l'utilisateur, par exemple :
   ```json
   {
       "username": "newuser",
       "email": "newuser@example.com",
       "password": "password123"
   }
   ```
8. Cliquez sur `Send`.

### DELETE /users/{id}
Pour supprimer un utilisateur par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/{id}
   ```
5. Cliquez sur `Send`.

### GET /requests
Pour récupérer la liste de toutes les requêtes :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/requests
   ```
5. Cliquez sur `Send`.

### GET /requests/{id}
Pour récupérer une requête par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/requests/{id}
   ```
5. Cliquez sur `Send`.

### POST /requests
Pour créer une nouvelle requête :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/requests
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
   http://localhost:8082/users/requests/{id}
   ```
5. Cliquez sur `Send`.

### GET /responses
Pour récupérer la liste de toutes les réponses :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/responses
   ```
5. Cliquez sur `Send`.

### GET /responses/{id}
Pour récupérer une réponse par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/responses/{id}
   ```
5. Cliquez sur `Send`.

### POST /feedbacks
Pour créer un nouveau feedback :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/feedbacks
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails du feedback, par exemple :
   ```json
   {
      "userId": 1,
      "feedbackText": "Feedback Text",
      "rating": 5
   }
   ```
8. Cliquez sur `Send`.

### DELETE /feedbacks/{id}
Pour supprimer un feedback par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/feedbacks/{id}
   ```
5. Cliquez sur `Send`.

### GET /feedbacks
Pour récupérer la liste de tous les feedbacks :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/feedbacks
   ```
5. Cliquez sur `Send`.

### GET /feedbacks/{id}
Pour récupérer un feedback par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8082/users/feedbacks/{id}
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
spring.application.name=Users
spring.datasource.url=jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_037
spring.datasource.username=projet_gei_037
spring.datasource.password=Oo3Loh1g
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8082
spring.jpa.properties.hibernate.packagesToScan=com.example.package
```
