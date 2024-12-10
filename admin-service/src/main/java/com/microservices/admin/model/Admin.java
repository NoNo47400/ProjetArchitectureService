package com.microservices.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Represents an Admin entity with fields for id, username, email, password, and role.
 * This entity is mapped to the "admins" table in the database.
 * 
 * Annotations:
 * - @Entity: Specifies that the class is an entity and is mapped to a database table.
 * - @Table(name = "admins"): Specifies the name of the database table to be used for mapping.
 * - @Id: Specifies the primary key of the entity.
 * - @GeneratedValue(strategy = GenerationType.IDENTITY): Provides the specification of generation strategies for the values of primary keys.
 * - @Column(unique = true): Specifies the mapped column for a persistent property or field and indicates that the column should have a unique constraint.
 * 
 * Fields:
 * - id: The unique identifier for the admin (primary key).
 * - username: The unique username for the admin.
 * - email: The unique email address for the admin.
 * - password: The password for the admin.
 * - role: The role assigned to the admin.
 * 
 * Methods:
 * - getId(): Returns the id of the admin.
 * - setId(Long id): Sets the id of the admin.
 * - getUsername(): Returns the username of the admin.
 * - setUsername(String username): Sets the username of the admin.
 * - getEmail(): Returns the email of the admin.
 * - setEmail(String email): Sets the email of the admin.
 * - getPassword(): Returns the password of the admin.
 * - setPassword(String password): Sets the password of the admin.
 * - getRole(): Returns the role of the admin.
 * - setRole(String role): Sets the role of the admin.
 */
@Entity
@Table(name = "admins")
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String username;
    
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
