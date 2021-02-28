package br.com.EmployeeAdministration.service;

import br.com.EmployeeAdministration.dto.HourRegisterDto;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;
import br.com.EmployeeAdministration.entity.HourRegisterEntity;

import java.time.LocalDate;
import java.util.List;

public interface HourRegisterService {
    HourRegisterDto saveHourRegister(HourRegisterDto dto);

    List<HourRegisterEntity> findAllByEmployeeFromMonth(Long employeeEntity_id, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);
}
