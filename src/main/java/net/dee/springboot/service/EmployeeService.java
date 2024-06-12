package net.dee.springboot.service;

import net.dee.springboot.dto.EmployeeDto;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
}
