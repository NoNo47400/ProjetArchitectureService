package fr.insa.msa.studentslistservice.ressources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.msa.studentslistservice.model.*;

@RestController
@RequestMapping("/students")
public class StudentListRessource {

	@GetMapping("ids/{idSpeciality}")
	public StudentIDList getIDStudents(@PathVariable("idSpeciality") String speciality) {
	
	    // Simulate the database using a list of integers
	    StudentIDList studentsId = new StudentIDList();
	    studentsId.addStudentToList(0);
	    studentsId.addStudentToList(1);
	    studentsId.addStudentToList(2);
	    studentsId.addStudentToList(3);
	    
	    return studentsId;
	}

	@GetMapping("all/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality") String speciality) {
	
	    // Simulate the database using a list of integers
	    StudentIDList students = new StudentIDList();
	    students.addStudentToList(0);
	    students.addStudentToList(1);
	    students.addStudentToList(2);
	    students.addStudentToList(3);
	
	    // Instantiate RestTemplate for REST calls
	    RestTemplate restTemplate = new RestTemplate();
	    int i = 0;
	    List<Student> listStudents = new ArrayList<>();
	
	    while (i < students.getStudentList().size()) {
	        // Call the microservice to get student's information
	        // The result is deserialized into a StudentInfos Java object
	        StudentInfos etudInfos = restTemplate.getForObject(
	            "http://localhost:8081/student/" + i, StudentInfos.class);
	
	        // Call the microservice to get the student's evaluation
	        // The result is deserialized into an Evaluation Java object
	        Evaluation eval = restTemplate.getForObject(
	            "http://localhost:8082/evaluation/" + i, Evaluation.class);
	
	        // Instantiate a student with its id, first name, last name, average and store it in the list
	        listStudents.add(new Student(i, etudInfos.getFirstName(), etudInfos.getLastName(), eval.getAverage()));
	        i++;
	    }
	
	    return listStudents;
	}

}
