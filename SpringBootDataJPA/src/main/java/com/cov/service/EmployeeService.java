package com.cov.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Employee;
import com.cov.repository.EmployeeRepo;

@Service
public class EmployeeService {
@Autowired
EmployeeRepo employeeRepository;
private Integer id;

public List<Employee> findAll() {

	return employeeRepository.findAll();
}

public Employee findById(int id) throws InvalidEmployeeIdException {
	Optional<Employee> empOptional = employeeRepository.findById(id);
	if (!empOptional.isPresent()) {
		throw new InvalidEmployeeIdException("Employee ID " + id + " not existing in repository");

	}
	return empOptional.get();
}

public Employee save(Employee employee) {
	return employeeRepository.save(employee);
}

public Employee update(Employee employee) throws InvalidEmployeeIdException {
	Optional<Employee> empOptional = employeeRepository.findById(id);
	if (!empOptional.isPresent()) {
		throw new InvalidEmployeeIdException("Employee ID " + employee.getId() + " not existing in repository");

	}
	return employeeRepository.save(employee);
}

public Employee delete(int id) throws InvalidEmployeeIdException {

	Optional<Employee> empOptional = employeeRepository.findById(id);
	if (!empOptional.isPresent()) {
		throw new InvalidEmployeeIdException("Employee ID " + id + " not existing in repository");
	}
	Employee employee = empOptional.get();
	employeeRepository.deleteById(id);
	return employee;
}

}

