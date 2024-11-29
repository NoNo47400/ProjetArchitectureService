package com.microservices.user.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Exception personnalisée pour les erreurs du service utilisateur
 * Génère une réponse SOAP Fault appropriée avec un code d'erreur serveur
 */
@SoapFault(faultCode = FaultCode.SERVER)
public class UserServiceException extends RuntimeException {
    
    /**
     * Crée une nouvelle exception avec un message
     * @param message Le message d'erreur
     */
    public UserServiceException(String message) {
        super(message);
    }

    /**
     * Crée une nouvelle exception avec un message et une cause
     * @param message Le message d'erreur
     * @param cause La cause de l'erreur
     */
    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
