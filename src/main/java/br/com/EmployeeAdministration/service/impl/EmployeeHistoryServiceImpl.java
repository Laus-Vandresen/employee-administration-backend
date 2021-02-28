package br.com.EmployeeAdministration.service.impl;

import br.com.EmployeeAdministration.dto.EmployeeDto;
import br.com.EmployeeAdministration.dto.EmployeeHistoryDto;
import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;
import br.com.EmployeeAdministration.repository.EmployeeHistoryRepository;
import br.com.EmployeeAdministration.service.EmployeeHistoryService;
import br.com.EmployeeAdministration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeHistoryServiceImpl implements EmployeeHistoryService {

    @Autowired
    private EmployeeHistoryRepository employeeHistoryRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmployeeHistoryDto saveEmployeeHistory(EmployeeHistoryDto dto) {
        EmployeeHistoryEntity employeeHistoryEntity = employeeHistoryRepository.findTopByEmployeeEntityIdOrderByDateDesc(dto.getIdEmployee());
        EmployeeEntity employeeEntity = employeeService.findById(dto.getIdEmployee());
        if (Objects.isNull(employeeHistoryEntity) || !employeeHistoryEntity.getMonthSalary().equals(dto.getMonthSalary()))
            return new EmployeeHistoryDto(employeeHistoryRepository.save(new EmployeeHistoryEntity(dto, employeeEntity)));
        return null;
    }

    @Override
    public List<EmployeeHistoryDto> findAllByEmployeeId(Long employeeId) {
        List<EmployeeHistoryEntity> employeeHistoryEntityList = employeeHistoryRepository.findAllById(Collections.singleton(employeeId));
        return employeeHistoryEntityList.stream().map(EmployeeHistoryDto::new).collect(Collectors.toList());
    }
}