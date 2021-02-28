package br.com.EmployeeAdministration.controller;

import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;
import br.com.EmployeeAdministration.service.EmployeeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employee-history")
public class EmployeeHistoryController {

    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @PostMapping
    public EmployeeHistoryDto saveEmployee(@RequestBody EmployeeHistoryDto dto) {
        return employeeHistoryService.saveEmployeeHistory(dto);
    }
}