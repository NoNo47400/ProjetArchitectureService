package com.microservices.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservices.admin.model.Admin;
import com.microservices.admin.service.AdminService;

/**
 * Contrôleur REST pour la gestion des administrateurs
 * Expose les endpoints HTTP pour les opérations CRUD
 */
@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    /**
     * Crée un nouvel administrateur
     * @param admin L'administrateur à créer
     * @return L'administrateur créé
     */
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(newAdmin);
    }
    
    /**
     * Récupère tous les administrateurs
     * @return La liste des administrateurs
     */
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
    
    /**
     * Récupère un administrateur par son ID
     * @param id L'ID de l'administrateur
     * @return L'administrateur trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Récupère un administrateur par son nom d'utilisateur
     * @param username Le nom d'utilisateur
     * @return L'administrateur trouvé
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.notFound().build();
    }
}
