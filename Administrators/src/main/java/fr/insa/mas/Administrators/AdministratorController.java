package fr.insa.mas.Administrators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    private final RestTemplate restTemplate;

    @Autowired
    public AdministratorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private AdministratorRepository administratorRepository;

    @GetMapping
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Administrator getAdministrator(@PathVariable Long id) {
        return administratorRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        administratorRepository.deleteById(id);
        return "Success";
    }

    @PutMapping("/requests/{id}")
    public Request updateRequest(@PathVariable Long id, @RequestBody Request updatedRequest) {
        String url = "http://localhost:8084/requests/"+id; // Assurez-vous que l'URL est correcte
        HttpEntity<Request> requestEntity = new HttpEntity<>(updatedRequest);
        ResponseEntity<Request> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Request.class);
        return responseEntity.getBody();
    }

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        ParameterizedTypeReference<List<Request>> responseType = new ParameterizedTypeReference<List<Request>>() {};
        String url = "http://localhost:8084/requests"; // Assurez-vous que l'URL est correcte
        ResponseEntity<List<Request>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return responseEntity.getBody();
    }

    @DeleteMapping("/requests/{id}")
    public String deleteRequest(@PathVariable Long id) {
        String url = "http://localhost:8084/requests/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/requests/{id}")
    public Request getRequest(@PathVariable Long id) {
        String url = "http://localhost:8084/requests/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<Request> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Request.class);
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

    @DeleteMapping("/responses/{id}")
    public String deleteResponse(@PathVariable Long id) {
        String url = "http://localhost:8085/responses/"+id; // Assurez-vous que l'URL est correcte
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        return responseEntity.getBody();
    }

}
