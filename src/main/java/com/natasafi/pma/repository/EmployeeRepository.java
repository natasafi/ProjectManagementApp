package com.natasafi.pma.repository;

import com.natasafi.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
