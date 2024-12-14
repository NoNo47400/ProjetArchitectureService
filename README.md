# Projet Architecture Service

## Instructions

1. Ouvrez un terminal pour chaque service et lancez-les.
2. Une fois tous les services lancés, ouvrez le fichier `login.html` dans votre navigateur pour accéder à l'application.

## Services

Assurez-vous que tous les services nécessaires sont en cours d'exécution avant d'ouvrir `login.html`.

### Lancer les services

Pour chaque service, utilisez les commandes appropriées dans des terminaux séparés. Par exemple :

```bash
# Terminal 1
cd Volunteers
./mvnw spring-boot:run

# Terminal 2
cd Users
./mvnw spring-boot:run

# Terminal 3
cd Requests
./mvnw spring-boot:run

# Terminal 4
cd Responses
./mvnw spring-boot:run

# Terminal 5
cd Feedbacks
./mvnw spring-boot:run

# Terminal 6
cd Administrators
./mvnw spring-boot:run
```

### Accéder à l'application

Après avoir lancé tous les services, ouvrez `login.html` dans votre navigateur :

```bash
start Frontend/login.html
```

ou simplement double-cliquant sur le fichier dans votre explorateur de fichiers.