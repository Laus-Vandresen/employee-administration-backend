package br.com.EmployeeAdministration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAndHistoryDto {

    private EmployeeDto employeeDto;
    private List<EmployeeHistoryDto> employeeHistoryDtoList;

    public void alterEmployeeDto(EmployeeDto dto) {
        this.employeeDto = dto;
    }

    public void alterEmployeHistoryList(List<EmployeeHistoryDto> dtoList) {
        this.employeeHistoryDtoList = dtoList;
    }

}
