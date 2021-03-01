package br.com.EmployeeAdministration.repository;

import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HourRegisterRepository extends JpaRepository<HourRegisterEntity, Long> {

    @Query(value = "SELECT * FROM hour_register where id_employee = ?1 and moviment_date between ?2 and ?3", nativeQuery = true)
    List<HourRegisterEntity> findAllByEmployeeFromMonth(Long employeeEntity_id, Timestamp firstDayOfMonth, Timestamp lastDayOfMonth);
}
