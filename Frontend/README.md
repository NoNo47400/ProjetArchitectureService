# Frontend

## Description
Ce projet frontend permet aux utilisateurs, volontaires et administrateurs d'interagir avec le système via une interface web. Le frontend est construit en HTML, CSS et JavaScript.

## Prérequis
- Un navigateur web moderne

## Pages

### Login
- **URL**: `login.html`
- **Description**: Page de connexion pour les utilisateurs, volontaires et administrateurs.
- **Fonctionnalités**:
  - Saisir l'email et le mot de passe pour se connecter.
  - Redirection vers la page appropriée en fonction du rôle de l'utilisateur.

### User
- **URL**: `user.html`
- **Description**: Tableau de bord pour les utilisateurs.
- **Fonctionnalités**:
  - Voir toutes les requêtes validées.
  - Créer une nouvelle requête.
  - Voir les réponses aux requêtes.
  - Ajouter des feedbacks aux réponses.
  - Filtrer les requêtes par "Toutes les requêtes" et "Mes requêtes".
  - Se déconnecter.

### Volunteer
- **URL**: `volunteer.html`
- **Description**: Tableau de bord pour les volontaires.
- **Fonctionnalités**:
  - Voir toutes les requêtes validées.
  - Ajouter des réponses aux requêtes.
  - Filtrer les requêtes par "Toutes les requêtes".
  - Se déconnecter.

### Administrator
- **URL**: `administrator.html`
- **Description**: Tableau de bord pour les administrateurs.
- **Fonctionnalités**:
  - Voir toutes les requêtes validées et invalidées.
  - Valider les requêtes.
  - Supprimer les requêtes, réponses et feedbacks.
  - Filtrer les requêtes par "Requêtes validées" et "Requêtes invalidées".
  - Se déconnecter.

## Utilisation

### Connexion
1. Ouvrez `login.html` dans votre navigateur.
2. Saisissez votre email et mot de passe.
3. Cliquez sur "Login".

### Utilisateur
1. Après la connexion, vous serez redirigé vers `user.html`.
2. Utilisez les filtres pour voir toutes les requêtes ou seulement vos requêtes.
3. Pour créer une nouvelle requête, cliquez sur "Create Request" et remplissez le formulaire.
4. Pour ajouter un feedback à une réponse, cliquez sur "Add Feedback" sous la réponse correspondante.
5. Pour vous déconnecter, cliquez sur "Logout".

### Volontaire
1. Après la connexion, vous serez redirigé vers `volunteer.html`.
2. Utilisez les filtres pour voir toutes les requêtes.
3. Pour ajouter une réponse à une requête, cliquez sur "Add Response" sous la requête correspondante et remplissez le formulaire.
4. Pour vous déconnecter, cliquez sur "Logout".

### Administrateur
1. Après la connexion, vous serez redirigé vers `administrator.html`.
2. Utilisez les filtres pour voir les requêtes validées ou invalidées.
3. Pour valider une requête, cliquez sur "Validate" sous la requête correspondante.
4. Pour supprimer une requête, une réponse ou un feedback, cliquez sur "Delete" sous l'élément correspondant.
5. Pour vous déconnecter, cliquez sur "Logout".
