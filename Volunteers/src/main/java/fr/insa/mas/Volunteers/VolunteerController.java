package fr.insa.mas.Volunteers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.core.ParameterizedTypeReference;


import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    private final RestTemplate restTemplate;

    @Autowired
    public VolunteerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private VolunteerRepository volunteerRepository;

    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Volunteer getVolunteer(@PathVariable Long id) {
        return volunteerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @DeleteMapping("/{id}")
    public String deleteVolunteer(@PathVariable Long id) {
        volunteerRepository.deleteById(id);
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

    @PostMapping("/responses")
    public Response createResponse(@RequestBody Response request) {
        String url = "http://localhost:8085/responses"; // Assurez-vous que l'URL est correcte
        HttpEntity<Response> requestEntity = new HttpEntity<>(request);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Response.class);
        return responseEntity.getBody();
    }

    @DeleteMapping("/responses/{id}")
    public String deleteResponse(@PathVariable Long id) {
        String url = "http://localhost:8085/responses/"+id; // Assurez-vous que l'URL est correcte
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
