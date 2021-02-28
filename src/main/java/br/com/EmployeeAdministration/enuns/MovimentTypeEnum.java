package br.com.EmployeeAdministration.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MovimentTypeEnum {

    ENTRY,
    OUT;

    @JsonCreator
    public static MovimentTypeEnum getByCodigo(String codigo) {
        return MovimentTypeEnum.valueOf(codigo);
    }
}
