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

import java.time.LocalDate;
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
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        List<HourRegisterEntity> hourRegisterEntityList = hourRegisterService.findAllByEmployeeFromMonth(idEmployee, firstDayOfMonth, lastDayOfMonth);
        EmployeeHistoryEntity employeeHistoryEntity = employeeHistoryService.findTopByEmployeeEntityIdOrderByDateDesc(idEmployee);
        if (Objects.nonNull(employeeHistoryEntity)) {
            dashboarDataDto.alterActualSalary(employeeHistoryEntity.getMonthSalary());
            dashboarDataDto.alterEmployeHistoryList(employeeHistoryService.findAllByEmployeeId(idEmployee));
        }
        calculateAvaregeHours(hourRegisterEntityList, dashboarDataDto);
        return dashboarDataDto;
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
            if (MovimentTypeEnum.ENTRY.equals(hourRegisterEntity.getMovimentType())) {
                outCount++;
                totalOutValue += hourRegisterEntity.getHours();
            }
        }
        dashboarDataDto.alterAvarageEntryTime(totalEntryValue / entryCount);
        dashboarDataDto.alterAvarageOutTime(totalOutValue / outCount);
    }
}
