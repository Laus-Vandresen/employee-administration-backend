package br.com.EmployeeAdministration.service;

import br.com.EmployeeAdministration.dto.HourRegisterDto;
import br.com.EmployeeAdministration.entity.HourRegisterEntity;

import java.sql.Timestamp;
import java.util.List;

public interface HourRegisterService {
    HourRegisterDto saveHourRegister(HourRegisterDto dto);

    List<HourRegisterEntity> findAllByEmployeeFromMonth(Long employeeEntity_id, Timestamp firstDayOfMonth, Timestamp lastDayOfMonth);
}
