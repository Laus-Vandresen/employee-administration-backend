package br.com.EmployeeAdministration.dto;

import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHistoryDto {

    private Long id;

    private Long idEmployee;

    private Timestamp date;

    private BigDecimal monthSalary;

    private Double monthHours;

    public EmployeeHistoryDto(EmployeeHistoryEntity entity) {
        this.id = entity.getId();
        this.idEmployee = entity.getEmployeeEntity().getId();
        this.date = entity.getDate();
        this.monthSalary = entity.getMonthSalary();
        this.monthHours = entity.getMonthHours();
    }
}
