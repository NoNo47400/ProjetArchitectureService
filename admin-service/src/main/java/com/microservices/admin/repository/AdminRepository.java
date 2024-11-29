package com.microservices.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.admin.model.Admin;

/**
 * Repository pour l'accès aux données des administrateurs
 * Fournit les méthodes CRUD de base et la recherche par nom d'utilisateur
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    /**
     * Trouve un administrateur par son nom d'utilisateur
     * @param username Le nom d'utilisateur à rechercher
     * @return L'administrateur trouvé ou null
     */
    Admin findByUsername(String username);
}
