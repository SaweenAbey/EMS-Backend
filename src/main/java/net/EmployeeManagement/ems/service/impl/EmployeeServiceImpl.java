package net.EmployeeManagement.ems.service.impl;

import lombok.AllArgsConstructor;
import net.EmployeeManagement.ems.dto.EmployeeDto;
import net.EmployeeManagement.ems.entity.Employee;
import net.EmployeeManagement.ems.exception.RecourceNotFoundException;
import net.EmployeeManagement.ems.mapper.EmployeeMapper;
import net.EmployeeManagement.ems.repository.EmployeeRepository;
import net.EmployeeManagement.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RecourceNotFoundException("Employee is not exits with given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }
}
