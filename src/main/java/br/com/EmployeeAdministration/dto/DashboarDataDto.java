package br.com.EmployeeAdministration.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DashboarDataDto {

    private BigDecimal actualSalary;
    private List<EmployeeHistoryDto> employeeHistoryDtoList;
    private Double averageEntryTime;
    private Double avarageOutTime;

    public void alterActualSalary(BigDecimal actualSalary) {
        this.actualSalary = actualSalary;
    }

    public void alterEmployeHistoryList(List<EmployeeHistoryDto> dtoList) {
        this.employeeHistoryDtoList = dtoList;
    }

    public void alterAvarageEntryTime(Double avarageEntryTime) {
        this.averageEntryTime = avarageEntryTime;
    }

    public void alterAvarageOutTime(Double avarageOutTime) {
        this.avarageOutTime = avarageOutTime;
    }

}
