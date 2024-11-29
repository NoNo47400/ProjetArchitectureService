package com.microservices.admin.exception;

/**
 * Exception personnalisée pour les erreurs du service administrateur
 * Utilisée pour signaler les erreurs métier spécifiques aux administrateurs
 */
public class AdminServiceException extends RuntimeException {
    
    /**
     * Crée une nouvelle exception avec un message
     * @param message Le message d'erreur
     */
    public AdminServiceException(String message) {
        super(message);
    }

    /**
     * Crée une nouvelle exception avec un message et une cause
     * @param message Le message d'erreur
     * @param cause La cause de l'erreur
     */
    public AdminServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
