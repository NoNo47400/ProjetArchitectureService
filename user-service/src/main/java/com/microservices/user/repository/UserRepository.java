package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.user.model.User;

/**
 * Repository pour l'accès aux données des utilisateurs
 * Fournit les méthodes CRUD de base et la recherche par nom d'utilisateur
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Trouve un utilisateur par son nom d'utilisateur
     * @param username Le nom d'utilisateur à rechercher
     * @return L'utilisateur trouvé ou null
     */
    User findByUsername(String username);
}