package com.cov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cov.beans.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

}
