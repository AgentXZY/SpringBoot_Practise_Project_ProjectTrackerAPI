package com.klem.projecttracker;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Project {

	private Long id;
	private String name;
	private String description;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate deadline;
	private Status status;
	
	public Project() {
	}
	
	public Project(long id, String name, String description, LocalDate deadline, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", deadline=" + deadline
				+ ", status=" + status + "]";
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public Status getStatus() {
		return status;
	}
	
}