package br.com.EmployeeAdministration.dto;

import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import br.com.EmployeeAdministration.enuns.MovimentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HourRegisterDto {

    private Long id;

    private Long idEmployee;

    @Enumerated(EnumType.STRING)
    private MovimentTypeEnum movimentType;

    private Timestamp movimentDate;

    private Double hours;

    public HourRegisterDto(HourRegisterEntity hourRegisterEntity) {
        this.id = hourRegisterEntity.getId();
        this.idEmployee = hourRegisterEntity.getEmployeeEntity().getId();
        this.movimentType = hourRegisterEntity.getMovimentType();
        this.movimentDate = hourRegisterEntity.getMovimentDate();
        this.hours = hourRegisterEntity.getHours();
    }
}