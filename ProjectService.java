package com.klem.projecttracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProjectService {
	
	private int count = 2; //----> SET TO 2 AS WE ALREADY DECALRED 2 SAMPLE TUPULES
	private List<Project> projects = new ArrayList<>();
	
	public ProjectService(){
		projects.add(new Project(
				1L,
	            "Build API",
	            "Create backend for tracker",
	            LocalDate.now().plusDays(7),
	            Status.PLANNED
				));
		
		projects.add(new Project(
                2L,
                "Frontend UI",
                "Design dashboard",
                LocalDate.now().plusDays(14),
                Status.IN_PROGRESS
        ));
		
	}
	
	public List<Project> getAllProjects(){
		return projects;
	}
	
	public Project getProjectById(long id) {
		for(Project p : projects) {
			if(p.getId() == id) return p;
		}
		throw new ProjectNotFoundException("Project not found!");
	}
	
	public Project addProject(Project project) {
		count++;
		project.setId(count);
		projects.add(project);
		return project;
	}
	
	public void deleteProject(long id) {
		projects.remove(getProjectById(id));
	}
	
	public Project updateStatus(long id, Status status) {
		Project p = getProjectById(id);
		p.setStatus(status);
		return p;
	}
	
}