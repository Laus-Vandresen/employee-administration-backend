package br.com.EmployeeAdministration.entity;

import br.com.EmployeeAdministration.dto.HourRegisterDto;
import br.com.EmployeeAdministration.enuns.MovimentTypeEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hour_register")
public class HourRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employeeEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "moviment_type")
    private MovimentTypeEnum movimentType;

    private Timestamp movimentDate;

    private Double hours;

    public HourRegisterEntity(HourRegisterDto dto, EmployeeEntity employeeEntity) {
        this.id = dto.getId();
        this.employeeEntity = employeeEntity;
        this.movimentType = dto.getMovimentType();
        this.movimentDate = dto.getMovimentDate();
        this.hours = dto.getHours();
    }
}
