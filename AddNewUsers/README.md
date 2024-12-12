# AddNewUsers

## Description
Ce projet permet d'ajouter et de récupérer des utilisateurs via des endpoints REST.

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

### GET /users
Pour récupérer la liste de tous les utilisateurs :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `GET`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/users
   ```
5. Cliquez sur `Send`.

### POST /users
Pour créer un nouvel utilisateur :
1. Ouvrez Postman.
2. Créez une nouvelle requête.
3. Sélectionnez le type de requête `POST`.
4. Entrez l'URL suivante :
   ```
   http://localhost:8081/users
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

## Initialisation de la base de données

Pour initialiser la base de données, exécutez le script `initiate_database.py` :
```sh
python /c:/Users/noelj/Desktop/ProjetArchitectureService/database/initiate_database.py
```

Ce script exécutera les commandes SQL définies dans `init.sql` pour créer les tables nécessaires.

## Configuration

Les configurations de la base de données et du serveur sont définies dans le fichier `application.properties` :
```properties
spring.application.name=AddNewUsers
spring.datasource.url=jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_037
spring.datasource.username=projet_gei_037
spring.datasource.password=Oo3Loh1g
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8081
spring.jpa.properties.hibernate.packagesToScan=com.example.package
