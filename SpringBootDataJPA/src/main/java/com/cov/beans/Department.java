package com.cov.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Department {
	@ApiModelProperty(notes = "auto genterated department ID by DB ")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int id;
	@ApiModelProperty(notes = "Departmetn name")
	String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	public List<Employee> employees = new ArrayList<>();

	public Department() {
	}

	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}