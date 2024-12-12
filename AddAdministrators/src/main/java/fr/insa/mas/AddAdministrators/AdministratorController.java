package fr.insa.mas.AddNewAdministrators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorRepository administratorRepository;

    @GetMapping
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @PostMapping
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return administratorRepository.save(administrator);
    }
}
