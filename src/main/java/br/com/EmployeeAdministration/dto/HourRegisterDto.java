package br.com.EmployeeAdministration.dto;

import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import br.com.EmployeeAdministration.enuns.MovimentTypeEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HourRegisterDto {

    private Long id;

    private Long idEmployee;

    @Enumerated(EnumType.STRING)
    private MovimentTypeEnum movimentType;

    private Double hours;

    public HourRegisterDto(HourRegisterEntity hourRegisterEntity) {
        this.id = hourRegisterEntity.getId();
        this.idEmployee = hourRegisterEntity.getId();
        this.movimentType = hourRegisterEntity.getMovimentType();
        this.hours = hourRegisterEntity.getHours();
    }
}
