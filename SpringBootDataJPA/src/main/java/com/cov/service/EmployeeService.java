package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.repository.EmployeeRepo;

@Service
public class EmployeeService {
	Logger logger = Logger.getLogger(EmployeeService.class);
	@Autowired
	EmployeeRepo employeeRepository;

	public List<Employee> findAll() {
// List<Employee> employees=new ArrayList<Employee>();
		logger.info("finding all employees");
		return employeeRepository.findAll();
// return employees;

	}

	public Employee findById(int id) throws InvalidEmployeeIdException {
		logger.info("finding an employee with id: " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee id not found");
		logger.warn(invalidEmployeeIdException);
		if (!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee id" + id + "does not exist in repository");
		}
		Employee employee = empOptional.get();
		logger.info("Employee found with id " + id + "is" + employee.getName() + " " + employee.getDepartment());
		return empOptional.get();
	}

	public Employee save(Employee employee) {
		logger.info("Inserting a new employee");
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee id not found");
		logger.warn(invalidEmployeeIdException);
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) throws InvalidEmployeeIdException {
		logger.info("Updating employee details ");
		Optional<Employee> empOptional = employeeRepository.findById(employee.getId());
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee id not found");
		logger.warn(invalidEmployeeIdException);
		if (!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee id" + employee.getId() + "does not exist in repository");
		}
		logger.info("Employee updated is" + employee.getId() + " " + employee.getName());
		return employeeRepository.save(employee);
	}

	public Employee delete(int id) throws InvalidEmployeeIdException {
		logger.info("Deleting employee with id " + id);
		Optional<Employee> empOptional = employeeRepository.findById(id);
		InvalidEmployeeIdException invalidEmployeeIdException = new InvalidEmployeeIdException("Employee id not found");
		logger.warn(invalidEmployeeIdException);
		if (!empOptional.isPresent()) {
			throw new InvalidEmployeeIdException("Employee id" + id + "does not exist in repository");
		}
		Employee employee = empOptional.get();
		employeeRepository.deleteById(id);
		logger.info("Employee deleted is with id " + id + " " + employee.getName() + " " + employee.getDepartment());
		return employee;
	}

	public List<Employee> findAllByDeptno(Department deptno) throws InvalidDepartmentIdException {
		logger.info("finding all employees by department number");
		List<Employee> employees = employeeRepository.findByDepartment(deptno);
		if (employees.isEmpty()) {
			throw new InvalidDepartmentIdException("Department Id " + deptno + "not existing in repository");
		}

		return employees;

	}

}