package fr.insa.mas.studentManagementMS.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentManagementMS.model.Student;

@RestController
public class StudentRessource {

	@GetMapping("/students")
	public int studentNumber() {
		return 200;
	}
	
	@GetMapping(value="/students/{id}")
	public Student infosStudent(@PathVariable int id) {
		Student student=new Student(id, "Noel", "Jumin");
		return student;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_ATOM_XML_VALUE)
	public Student xmlInfosStudent(@PathVariable int id) {
		Student student=new Student(id, "Noel", "Jumin");
		return student;
	}
}
