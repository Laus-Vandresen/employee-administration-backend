package br.com.EmployeeAdministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;

@Repository
public interface EmployeeHistoryRepository extends JpaRepository<EmployeeHistoryEntity, Long> {

    EmployeeHistoryEntity findTopByEmployeeEntityIdOrderByDateDesc(Long employeeEntity_id);
}
