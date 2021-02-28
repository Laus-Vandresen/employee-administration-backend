package br.com.EmployeeAdministration.service;

import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;

import java.util.List;

public interface EmployeeHistoryService {
    EmployeeHistoryDto saveEmployeeHistory(EmployeeHistoryDto dto);
    List<EmployeeHistoryDto> findAllByEmployeeId(Long employeeId);
}
