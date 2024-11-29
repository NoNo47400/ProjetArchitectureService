package com.microservices.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import com.microservices.user.model.User;
import com.microservices.user.repository.UserRepository;

/**
 * Service gérant les opérations liées aux utilisateurs
 * Fournit les méthodes CRUD et la logique métier pour la gestion des utilisateurs
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Crée un nouvel utilisateur
     * @param user L'utilisateur à créer
     * @return L'utilisateur créé avec son ID
     * @throws RuntimeException si le nom d'utilisateur existe déjà
     */
    public User createUser(User user) {
        try {
            // Vérification de l'existence de l'utilisateur
            User existingUser = userRepository.findByUsername(user.getUsername());
            if (existingUser != null) {
                throw new RuntimeException("Username already exists: " + user.getUsername());
            }
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }
    }
    
    /**
     * Récupère tous les utilisateurs
     * @return Liste de tous les utilisateurs
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Récupère un utilisateur par son ID
     * @param id ID de l'utilisateur
     * @return L'utilisateur trouvé ou null
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    /**
     * Récupère un utilisateur par son nom d'utilisateur
     * @param username Nom d'utilisateur
     * @return L'utilisateur trouvé ou null
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
