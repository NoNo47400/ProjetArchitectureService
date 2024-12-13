package fr.insa.mas.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @GetMapping
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    @PostMapping
    public Response createResponse(@RequestBody Response response) {
        return responseRepository.save(response);
    }
}
