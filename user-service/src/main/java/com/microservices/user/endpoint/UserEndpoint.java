package com.microservices.user.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.microservices.user.model.User;
import com.microservices.user.service.UserService;
import com.microservices.user.*;
import com.microservices.user.exception.UserServiceException;

/**
 * Endpoint SOAP pour la gestion des utilisateurs
 * Expose les opérations CRUD via des services web SOAP
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://microservices.com/user";

    @Autowired
    private UserService userService;

    /**
     * Récupère un utilisateur par son ID
     * @param request Requête contenant l'ID de l'utilisateur
     * @return Réponse contenant l'utilisateur trouvé
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        User user = userService.getUserById(request.getId());
        if (user != null) {
            response.setUser(mapUserToUserType(user));
        }
        return response;
    }

    /**
     * Récupère tous les utilisateurs
     * @param request Requête vide
     * @return Réponse contenant la liste des utilisateurs
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        userService.getAllUsers().stream()
            .map(this::mapUserToUserType)
            .forEach(response.getUser()::add);
        return response;
    }

    /**
     * Crée un nouvel utilisateur
     * @param request Requête contenant les données de l'utilisateur
     * @return Réponse contenant l'utilisateur créé
     * @throws UserServiceException si la création échoue
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        try {
            CreateUserResponse response = new CreateUserResponse();
            User user = mapUserTypeToUser(request.getUser());
            User savedUser = userService.createUser(user);
            response.setUser(mapUserToUserType(savedUser));
            return response;
        } catch (RuntimeException e) {
            throw new UserServiceException("User creation failed: " + e.getMessage());
        }
    }

    /**
     * Convertit un User du modèle en UserType pour SOAP
     */
    private User mapUserTypeToUser(com.microservices.user.User userType) {
        User user = new User();
        user.setUsername(userType.getUsername());
        user.setEmail(userType.getEmail());
        user.setPassword(userType.getPassword());
        return user;
    }

    /**
     * Convertit un UserType SOAP en User du modèle
     */
    private com.microservices.user.User mapUserToUserType(User user) {
        com.microservices.user.User userType = new com.microservices.user.User();
        userType.setId(user.getId());
        userType.setUsername(user.getUsername());
        userType.setEmail(user.getEmail());
        userType.setPassword(user.getPassword());
        return userType;
    }
}
