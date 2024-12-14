package fr.insa.mas.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "Success";
    }

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        ParameterizedTypeReference<List<Request>> responseType = new ParameterizedTypeReference<List<Request>>() {};
        String url = "http://localhost:8084/requests"; // Assurez-vous que l'URL est correcte
        ResponseEntity<List<Request>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return responseEntity.getBody();
    }

    @GetMapping("/requests/{id}")
    public Request getRequest(@PathVariable Long id) {
        String url = "http://localhost:8084/requests/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<Request> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Request.class);
        return responseEntity.getBody();
    }

    @PostMapping("/requests")
    public Request createRequest(@RequestBody Request request) {
        String url = "http://localhost:8084/requests"; // Assurez-vous que l'URL est correcte
        HttpEntity<Request> requestEntity = new HttpEntity<>(request);
        ResponseEntity<Request> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Request.class);
        return responseEntity.getBody();
    }

    @DeleteMapping("/requests/{id}")
    public String deleteRequest(@PathVariable Long id) {
        String url = "http://localhost:8084/requests/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/responses")
    public List<Response> getAllResponses() {
        ParameterizedTypeReference<List<Response>> responseType = new ParameterizedTypeReference<List<Response>>() {};
        String url = "http://localhost:8085/responses"; // Assurez-vous que l'URL est correcte
        ResponseEntity<List<Response>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return responseEntity.getBody();
    }

    @GetMapping("/responses/{id}")
    public Response getResponse(@PathVariable Long id) {
        String url = "http://localhost:8085/responses/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Response.class);
        return responseEntity.getBody();
    }

    @PostMapping("/feedbacks")
    public Feedback createFeedback(@RequestBody Feedback request) {
        String url = "http://localhost:8086/feedbacks"; // Assurez-vous que l'URL est correcte
        HttpEntity<Feedback> requestEntity = new HttpEntity<>(request);
        ResponseEntity<Feedback> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Feedback.class);
        return responseEntity.getBody();
    }

    @DeleteMapping("/feedbacks/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        String url = "http://localhost:8086/feedbacks/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedbacks() {
        ParameterizedTypeReference<List<Feedback>> responseType = new ParameterizedTypeReference<List<Feedback>>() {};
        String url = "http://localhost:8086/feedbacks"; // Assurez-vous que l'URL est correcte
        ResponseEntity<List<Feedback>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return responseEntity.getBody();
    }

    @GetMapping("/feedbacks/{id}")
    public Feedback getFeedback(@PathVariable Long id) {
        String url = "http://localhost:8086/feedbacks/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<Feedback> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Feedback.class);
        return responseEntity.getBody();
    }

}
