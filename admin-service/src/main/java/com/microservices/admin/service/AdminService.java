package com.microservices.admin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.admin.model.Admin;
import com.microservices.admin.repository.AdminRepository;

/**
 * Service de gestion des administrateurs
 * Implémente la logique métier pour la gestion des administrateurs
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    /**
     * Crée un nouvel administrateur
     * @param admin L'administrateur à créer
     * @return L'administrateur créé
     */
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
    /**
     * Récupère tous les administrateurs
     * @return La liste des administrateurs
     */
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    
    /**
     * Récupère un administrateur par son ID
     * @param id L'ID de l'administrateur
     * @return L'administrateur trouvé ou null
     */
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    
    /**
     * Récupère un administrateur par son nom d'utilisateur
     * @param username Le nom d'utilisateur
     * @return L'administrateur trouvé ou null
     */
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
