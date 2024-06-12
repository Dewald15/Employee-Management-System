package net.dee.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.dee.springboot.dto.EmployeeDto;
import net.dee.springboot.entity.Employee;
import net.dee.springboot.mapper.EmployeeMapper;
import net.dee.springboot.repository.EmployeeRepository;
import net.dee.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }
}
