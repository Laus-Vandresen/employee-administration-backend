package br.com.EmployeeAdministration.controller;

import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;
import br.com.EmployeeAdministration.dto.HourRegisterDto;
import br.com.EmployeeAdministration.service.HourRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hour-register")
public class HourRegistrerController {

    @Autowired
    private HourRegisterService hourRegisterService;

    @PostMapping
    public HourRegisterDto saveHourRegister(@RequestBody HourRegisterDto dto) {
        return hourRegisterService.saveHourRegister(dto);
    }
}
