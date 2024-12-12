-- Permet de supprimer la base de données si elle existe
DROP DATABASE IF EXISTS projet_gei_037;

-- Création de la base de données pour le service utilisateur
CREATE DATABASE IF NOT EXISTS projet_gei_037;
USE projet_gei_037;

-- Création de la table des utilisateurs
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Création de la table des administrateurs
CREATE TABLE IF NOT EXISTS administrators (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Création de la table des volontaires
CREATE TABLE IF NOT EXISTS volunteers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Création de la table des requêtes
CREATE TABLE IF NOT EXISTS requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    objectOfRequest VARCHAR(255) NOT NULL UNIQUE,
    textOfRequest VARCHAR(500) NOT NULL,
    validated VARCHAR(255) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
);

-- Création de la table des réponses
CREATE TABLE IF NOT EXISTS responses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    requestId BIGINT NOT NULL,
    textOfResponse VARCHAR(500) NOT NULL,
    FOREIGN KEY (requestId) REFERENCES requests(id) ON DELETE CASCADE
);