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

}
