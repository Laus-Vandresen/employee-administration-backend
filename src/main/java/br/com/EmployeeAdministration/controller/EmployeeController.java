package br.com.EmployeeAdministration.controller;

import br.com.EmployeeAdministration.dto.EmployeeAndHistoryDto;
import br.com.EmployeeAdministration.dto.EmployeeDto;
import br.com.EmployeeAdministration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto dto) {
        return employeeService.saveEmployee(dto);
    }

    @GetMapping
    public EmployeeAndHistoryDto getEmployeeAndHistory(@RequestParam Long id) {
        return employeeService.findEmployeeAndHistoryById(id);
    }
}