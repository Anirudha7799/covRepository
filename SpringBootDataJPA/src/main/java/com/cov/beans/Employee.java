package com.cov.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String Name;
	int Deptno;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Employee employee;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int deptno) {
		super();
		this.id = id;
		Name = name;
		Deptno = deptno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDeptno() {
		return Deptno;
	}

	public void setDeptno(int deptno) {
		Deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", Deptno=" + Deptno + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Deptno == other.Deptno && Objects.equals(Name, other.Name) && id == other.id;
	}

}
