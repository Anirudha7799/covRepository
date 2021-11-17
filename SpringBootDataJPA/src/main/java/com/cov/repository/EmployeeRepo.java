package com.cov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
