package br.com.EmployeeAdministration.service.impl;

import br.com.EmployeeAdministration.dto.EmployeeAndHistoryDto;
import br.com.EmployeeAdministration.dto.EmployeeDto;
import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.repository.EmployeeRepository;
import br.com.EmployeeAdministration.service.EmployeeHistoryService;
import br.com.EmployeeAdministration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {
        employeeRepository.save(new EmployeeEntity(dto));
        return dto;
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public EmployeeAndHistoryDto findEmployeeAndHistoryById(Long id) {
        EmployeeAndHistoryDto dto = new EmployeeAndHistoryDto();
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        employeeEntity.ifPresent(entity -> dto.alteraEmployeeDto(new EmployeeDto(entity)));
        dto.alteraEmployeHistoryList(employeeHistoryService.findAllByEmployeeId(id));
        return dto;
    }
}
