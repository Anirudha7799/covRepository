package com.cov.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Employee;
import com.cov.exception.InvalidEmployeeIdException;
import com.cov.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API to Perform operations on Employee", description = "This API provides capability to perform differnt CRUD Operation on Employee Repository", produces = "application/xml")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	static Logger logger = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "Search a single Employee based on the ID given", response = Employee.class, produces = "application/xml")
	@GetMapping("/{id}")
	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Successfully retrived list of Employee"),
			@ApiResponse(code = 401, message = "Unauthrizedd access for Employee"),
			@ApiResponse(code = 403, message = "Forbidden access for Employee"),
			@ApiResponse(code = 404, message = "Page not found in Employee") })
	public Employee find(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("finding a employee with id " + id);
		Employee employee = employeeService.findById(id);
		logger.info("employee found with id " + id + " is" + employee.getName());
		return employee;
	}

	@GetMapping()
	public List<Employee> findAll() {
		logger.info("finding all employees");
		return employeeService.findAll();
	}

	@PostMapping()
	public Employee insertPerson(@RequestBody Employee employee) {
		logger.info("inserting a employee with " + employee.getName());
		return employeeService.save(employee);
	}

	@PutMapping()
	public Employee edit(@RequestBody Employee employee) throws InvalidEmployeeIdException {
		logger.info("editing a employee with " + employee.getName());
		return employeeService.update(employee);
	}

	@DeleteMapping("/{id}")
	public Employee delete(@PathVariable int id) throws InvalidEmployeeIdException {
		logger.info("deleting a employee with id " + id);
		return employeeService.delete(id);
	}
}