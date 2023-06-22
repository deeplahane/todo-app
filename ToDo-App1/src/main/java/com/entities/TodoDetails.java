package com.entities;

public class TodoDetails {
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", task=" + task + ", status=" + status + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private int id;
	private String name;
	private String task;
	private String status;

	public TodoDetails(int id, String name, String task, String status) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.status = status;
	}

	public TodoDetails(String name, String task, String status) {
		super();
		this.name = name;
		this.task = task;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TodoDetails() {
		super();
	}
	
	
}
