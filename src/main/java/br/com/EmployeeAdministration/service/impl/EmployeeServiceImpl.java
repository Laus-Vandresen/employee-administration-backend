package br.com.EmployeeAdministration.service.impl;

import br.com.EmployeeAdministration.dto.DashboarDataDto;
import br.com.EmployeeAdministration.dto.EmployeeAndHistoryDto;
import br.com.EmployeeAdministration.dto.EmployeeDto;
import br.com.EmployeeAdministration.entity.EmployeeEntity;
import br.com.EmployeeAdministration.entity.EmployeeHistoryEntity;
import br.com.EmployeeAdministration.entity.HourRegisterEntity;
import br.com.EmployeeAdministration.enuns.MovimentTypeEnum;
import br.com.EmployeeAdministration.repository.EmployeeRepository;
import br.com.EmployeeAdministration.service.EmployeeHistoryService;
import br.com.EmployeeAdministration.service.EmployeeService;
import br.com.EmployeeAdministration.service.HourRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeHistoryService employeeHistoryService;

    @Autowired
    private HourRegisterService hourRegisterService;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {
        return new EmployeeDto(employeeRepository.save(new EmployeeEntity(dto)));
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public EmployeeAndHistoryDto findEmployeeAndHistoryById(Long idEmployee) {
        EmployeeAndHistoryDto dto = new EmployeeAndHistoryDto();
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(idEmployee);
        employeeEntity.ifPresent(entity -> dto.alterEmployeeDto(new EmployeeDto(entity)));
        dto.alterEmployeHistoryList(employeeHistoryService.findAllByEmployeeId(idEmployee));
        return dto;
    }

    @Override
    public DashboarDataDto getDashBoardData(Long idEmployee) {
        DashboarDataDto dashboarDataDto = new DashboarDataDto();
        List<HourRegisterEntity> hourRegisterEntityList = hourRegisterService.findAllByEmployeeFromMonth(idEmployee, getFirstDayOfMonth(), getLasttDayOfMonth());
        EmployeeHistoryEntity employeeHistoryEntity = employeeHistoryService.findTopByEmployeeEntityIdOrderByDateDesc(idEmployee);
        if (Objects.nonNull(employeeHistoryEntity)) {
            dashboarDataDto.alterActualSalary(employeeHistoryEntity.getMonthSalary());
            dashboarDataDto.alterEmployeHistoryList(employeeHistoryService.findAllByEmployeeId(idEmployee));
        }
        calculateAvaregeHours(hourRegisterEntityList, dashboarDataDto);
        return dashboarDataDto;
    }

    private Timestamp getFirstDayOfMonth() {
        LocalDateTime firstDayOfMonth = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
        return Timestamp.valueOf(firstDayOfMonth);
    }

    private Timestamp getLasttDayOfMonth() {
        LocalDateTime lastDayOfMonth = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        return Timestamp.valueOf(lastDayOfMonth);
    }

    private void calculateAvaregeHours(List<HourRegisterEntity> hourRegisterEntityList, DashboarDataDto dashboarDataDto) {
        Integer entryCount = 0;
        Integer outCount = 0;
        Double totalEntryValue = 0.0D;
        Double totalOutValue = 0.0D;
        for (HourRegisterEntity hourRegisterEntity: hourRegisterEntityList) {
            if (MovimentTypeEnum.ENTRY.equals(hourRegisterEntity.getMovimentType())) {
                entryCount++;
                totalEntryValue += hourRegisterEntity.getHours();
            }
            if (MovimentTypeEnum.OUT.equals(hourRegisterEntity.getMovimentType())) {
                outCount++;
                totalOutValue += hourRegisterEntity.getHours();
            }
        }

        dashboarDataDto.alterAvarageEntryTime(0D == totalEntryValue ? totalEntryValue : totalEntryValue / entryCount);
        dashboarDataDto.alterAvarageOutTime(0d == totalOutValue ? totalOutValue : totalOutValue / outCount);
    }
}
