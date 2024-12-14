# Administrators Microservice

## Description
Ce projet permet d'ajouter et de récupérer des administrateurs via des endpoints REST. Le microservice a été généré avec [Spring Initializr](https://start.spring.io/).

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

L'application sera accessible sur `http://localhost:8081`.

## Endpoints

### GET /administrators
Pour récupérer la liste de tous les administrateurs :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators
   ```
5. Cliquez sur `Send`.

### GET /administrators/{id}
Pour récupérer un administrateur par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/{id}
   ```
5. Cliquez sur `Send`.

### POST /administrators
Pour créer un nouvel administrateur :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails de l'administrateur, par exemple :
   ```json
   {
       "username": "newadmin",
       "email": "admin@example.com",
       "password": "password123"
   }
   ```
8. Cliquez sur `Send`.

### DELETE /administrators/{id}
Pour supprimer un administrateur par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/{id}
   ```
5. Cliquez sur `Send`.

### GET /requests
Pour récupérer la liste de toutes les requêtes :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/requests
   ```
5. Cliquez sur `Send`.

### GET /requests/{id}
Pour récupérer une requête par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/requests/{id}
   ```
5. Cliquez sur `Send`.

### PUT /requests/{id}
Pour mettre à jour une requête par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `PUT`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/requests/{id}
   ```
5. Allez dans l'onglet `Body`.
6. Sélectionnez `raw` et `JSON` (application/json).
7. Entrez le corps de la requête avec les détails de la requête, par exemple :
   ```json
   {
      "validated": true
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
   http://localhost:8081/administrators/requests/{id}
   ```
5. Cliquez sur `Send`.

### GET /feedbacks
Pour récupérer la liste de tous les feedbacks :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/feedbacks
   ```
5. Cliquez sur `Send`.

### GET /feedbacks/{id}
Pour récupérer un feedback par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/feedbacks/{id}
   ```
5. Cliquez sur `Send`.

### DELETE /feedbacks/{id}
Pour supprimer un feedback par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/feedbacks/{id}
   ```
5. Cliquez sur `Send`.

### GET /responses
Pour récupérer la liste de toutes les réponses :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/responses
   ```
5. Cliquez sur `Send`.

### GET /responses/{id}
Pour récupérer une réponse par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/responses/{id}
   ```
5. Cliquez sur `Send`.

### DELETE /responses/{id}
Pour supprimer une réponse par son ID :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `DELETE`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/administrators/responses/{id}
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
spring.application.name=Administrators
spring.datasource.url=jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_037
spring.datasource.username=projet_gei_037
spring.datasource.password=Oo3Loh1g
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8081
spring.jpa.properties.hibernate.packagesToScan=com.example.package
```
