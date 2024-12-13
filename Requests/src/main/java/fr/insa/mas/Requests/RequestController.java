package fr.insa.mas.Requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Request getAllRequests(@PathVariable Long id) {
        return requestRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestRepository.save(request);
    }

    @PutMapping("/{id}")
    public Request updateValidated(@RequestBody Request updatedRequest, @PathVariable Long id) {
        Request request = requestRepository.findById(id).orElseThrow();
        request.updateValidated(updatedRequest.getValidated());
        return requestRepository.save(request);
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestRepository.deleteById(id);
        return "Success";
    }
}
