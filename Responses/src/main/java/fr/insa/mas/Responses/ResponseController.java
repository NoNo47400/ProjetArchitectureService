package fr.insa.mas.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @GetMapping
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Response getResponse(@PathVariable Long id) {
        return responseRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Response createResponse(@RequestBody Response response) {
        return responseRepository.save(response);
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        responseRepository.deleteById(id);
        return "Success";
    }
}
