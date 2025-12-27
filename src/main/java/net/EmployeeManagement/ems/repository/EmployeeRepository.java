package net.EmployeeManagement.ems.repository;

import net.EmployeeManagement.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
