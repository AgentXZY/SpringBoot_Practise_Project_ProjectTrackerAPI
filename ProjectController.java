package com.klem.projecttracker;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	private final ProjectService service;
	
	public ProjectController(ProjectService service){
		this.service = service;
	}
	
	@GetMapping(path = "/projects")
	public ResponseEntity<List<Project>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllProjects());
	}
	
	@GetMapping(path = "/projects/{id}")
	public ResponseEntity<Project> getById(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getProjectById(id));
	}
	
	@PostMapping(path = "/projects")
//	public ResponseEntity<Project> addProject(@RequestBody Project project) {
	public Project addProject(@RequestBody Project project) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(service.addProject(project));
		return service.addProject(project);
	}
	
	@DeleteMapping(path = "/projects/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable long id) {
		service.deleteProject(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}