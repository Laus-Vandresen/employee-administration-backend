package br.com.EmployeeAdministration.service.impl;

import br.com.EmployeeAdministration.dto.HourRegisterDto;
import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import br.com.EmployeeAdministration.repository.HourRegisterRepository;
import br.com.EmployeeAdministration.service.EmployeeService;
import br.com.EmployeeAdministration.service.HourRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HourRegisterServiceImpl implements HourRegisterService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HourRegisterRepository hourRegisterRepository;


    @Override
    public HourRegisterDto saveHourRegister(HourRegisterDto dto) {
        EmployeeEntity employeeEntity = employeeService.findById(dto.getIdEmployee());
        return new HourRegisterDto(hourRegisterRepository.save(new HourRegisterEntity(dto, employeeEntity)));
    }

    @Override
    public List<HourRegisterEntity> findAllByEmployeeFromMonth(Long employeeEntity_id, Timestamp firstDayOfMonth, Timestamp lastDayOfMonth) {
        return hourRegisterRepository.findAllByEmployeeFromMonth(employeeEntity_id, firstDayOfMonth, lastDayOfMonth);
    }
}
