package net.EmployeeManagement.ems.service.impl;

import lombok.AllArgsConstructor;
import net.EmployeeManagement.ems.dto.EmployeeDto;
import net.EmployeeManagement.ems.entity.Employee;
import net.EmployeeManagement.ems.mapper.EmployeeMapper;
import net.EmployeeManagement.ems.repository.EmployeeRepository;
import net.EmployeeManagement.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }
}
