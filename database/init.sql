-- Création de la base de données pour le service utilisateur
CREATE DATABASE IF NOT EXISTS user_service;
USE user_service;

-- Création de la table des utilisateurs avec contrainte d'unicité sur le nom d'utilisateur
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Table des administrateurs
CREATE TABLE IF NOT EXISTS admins (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
