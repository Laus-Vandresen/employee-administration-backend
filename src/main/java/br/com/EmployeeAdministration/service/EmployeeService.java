package br.com.EmployeeAdministration.service;


import br.com.EmployeeAdministration.dto.DashboarDataDto;
import br.com.EmployeeAdministration.dto.EmployeeAndHistoryDto;
import br.com.EmployeeAdministration.dto.EmployeeDto;
import br.com.EmployeeAdministration.entity.EmployeeEntity;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto dto);

    EmployeeEntity findById(Long id);

    EmployeeAndHistoryDto findEmployeeAndHistoryById(Long id);

    DashboarDataDto getDashBoardData(Long idEmployee);
}
