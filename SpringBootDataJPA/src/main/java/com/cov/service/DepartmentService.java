package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.repository.DepartmentRepo;

@Service
public class DepartmentService {
	Logger logger = Logger.getLogger(DepartmentService.class);
	@Autowired
	DepartmentRepo departmentRepository;

	public List<Department> findAll() {
// List<Employee> employee=new ArrayList<Employee>();
		logger.info("finding all departments");
		return departmentRepository.findAll();
// return employee;
	}

	public Department findById(int id) throws InvalidDepartmentIdException {
		logger.info("finding a department with id: " + id);
		Optional<Department> deptOptional = departmentRepository.findById(id);
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department id not found");
		logger.warn(invalidDepartmentIdException);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + " not existing in repository");
		}
		Department department = deptOptional.get();
		logger.info("Department found with id " + id + "is" + department.getName());
		return deptOptional.get();
	}

	public Department save(Department department) {
		logger.info("Inserting a new department");
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department id not found");
		logger.warn(invalidDepartmentIdException);
		return departmentRepository.save(department);
	}

	public Department update(Department department) throws InvalidDepartmentIdException {
		logger.info("Updating departments ");
		Optional<Department> deptOptional = departmentRepository.findById(department.getId());
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department id not found");
		logger.warn(invalidDepartmentIdException);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException(
					"Department Id" + department.getId() + "not existing in reposiotory");
		}
		logger.info("Department updated is" + department.getId() + " " + department.getName());
		return departmentRepository.save(department);
	}

	public Department delete(int id) throws InvalidDepartmentIdException {
		logger.info("Deleting department with id " + id);
		Optional<Department> deptOptional = departmentRepository.findById(id);
		InvalidDepartmentIdException invalidDepartmentIdException = new InvalidDepartmentIdException(
				"Department id not found");
		logger.warn(invalidDepartmentIdException);
		if (!deptOptional.isPresent()) {
			throw new InvalidDepartmentIdException("Department Id " + id + "not existing in repository");
		}
		Department department = deptOptional.get();
		departmentRepository.deleteById(id);
		logger.info("Department deleted is with id " + id + " " + department.getName());
		return department;
	}
}