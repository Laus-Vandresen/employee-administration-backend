package br.com.EmployeeAdministration.repository;

import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourRegisterRepository extends JpaRepository<HourRegisterEntity, Long> {
}
