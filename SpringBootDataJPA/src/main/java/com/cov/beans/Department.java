package com.cov.beans;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Deptno;
	String Deptname;
	String Loc;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Employee>employees;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int deptno, String deptname, String loc) {
		super();
		Deptno = deptno;
		Deptname = deptname;
		Loc = loc;
	}

	public int getDeptno() {
		return Deptno;
	}

	public void setDeptno(int deptno) {
		Deptno = deptno;
	}

	public String getDeptname() {
		return Deptname;
	}

	public void setDeptname(String deptname) {
		Deptname = deptname;
	}

	public String getLoc() {
		return Loc;
	}

	public void setLoc(String loc) {
		Loc = loc;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(Deptname, other.Deptname) && Deptno == other.Deptno && Objects.equals(Loc, other.Loc);
	}

	@Override
	public String toString() {
		return "Department [Deptno=" + Deptno + ", Deptname=" + Deptname + ", Loc=" + Loc + "]";
	}

}
