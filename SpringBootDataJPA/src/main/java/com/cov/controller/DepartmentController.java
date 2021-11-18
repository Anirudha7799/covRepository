package com.cov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cov.beans.Department;
import com.cov.beans.Employee;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.service.DepartmentService;

@Controller

public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping("getDep")
	public ModelAndView findEmployee(Employee employee) {
		ModelAndView modelAndView = new ModelAndView("department", "deps", departmentService.findAll());

		return modelAndView;

	}

	@RequestMapping(value = "editDep", method = RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) throws InvalidDepartmentIdException {

		Department depToEdit = departmentService.findById(id);
		ModelAndView modelAndView = new ModelAndView("editDepartment", "depToEdit", depToEdit);

		return modelAndView;
	}

	@RequestMapping(value = "updateDep", method = RequestMethod.POST)
	public ModelAndView updateDep(@ModelAttribute("depToEdit") Department department)
			throws InvalidDepartmentIdException {
		ModelAndView modelAndView = new ModelAndView("redirect:" + "getDep");

		return modelAndView;
	}

}