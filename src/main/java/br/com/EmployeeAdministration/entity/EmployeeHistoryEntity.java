package br.com.EmployeeAdministration.entity;

import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_history")
public class EmployeeHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employeeEntity;

    @Column(name = "data")
    private Timestamp date;

    @Column(name = "month_salary")
    private BigDecimal monthSalary;

    @Column(name = "month_hours")
    private Double monthHours;

    public EmployeeHistoryEntity(EmployeeHistoryDto dto, EmployeeEntity employeeEntity) {
        this.id = dto.getId();
        this.employeeEntity = employeeEntity;
        this.date = dto.getDate();
        this.monthHours = dto.getMonthHours();
        this.monthSalary = dto.getMonthSalary();
    }
}