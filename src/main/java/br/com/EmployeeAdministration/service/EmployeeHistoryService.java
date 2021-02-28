package br.com.EmployeeAdministration.service;

import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;

import java.util.List;

public interface EmployeeHistoryService {
    EmployeeHistoryDto saveEmployeeHistory(EmployeeHistoryDto dto);
    List<EmployeeHistoryDto> findAllByEmployeeId(Long employeeId);
    EmployeeHistoryEntity findTopByEmployeeEntityIdOrderByDateDesc(Long employeeEntity_id);
}
