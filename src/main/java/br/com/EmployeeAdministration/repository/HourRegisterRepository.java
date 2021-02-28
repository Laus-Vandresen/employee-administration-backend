package br.com.EmployeeAdministration.repository;

import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HourRegisterRepository extends JpaRepository<HourRegisterEntity, Long> {

    @Query(value = "SELECT h FROM hour_register h where h.id_employee = ?1 and h.moviment_date between ?2 and ?3", nativeQuery = true)
    List<HourRegisterEntity> findAllByEmployeeFromMonth(Long employeeEntity_id, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);
}
