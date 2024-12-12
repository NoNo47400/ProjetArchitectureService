package fr.insa.mas.AddRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestRepository.save(request);
    }

    @PutMapping
    public Request updateValidated(@RequestBody Request updatedRequest) {
        Request request = requestRepository.findById(updatedRequest.getId()).orElseThrow();
        request.updateValidated(updatedRequest.getValidated());
        return requestRepository.save(request);
    }
}
