package com.trung.convert;

import com.trung.entity.EmployeeEntity;
import com.trung.request.EmployeeRequest;

public class EmployeeConverter {
    public static EmployeeEntity convertRequestToEntity(EmployeeRequest employeeRequest) {
        return EmployeeEntity.builder()
                .employeeCode(employeeRequest.getEmployeeCode())
                .employeeGroup(employeeRequest.getEmployeeGroup())
                .fullName(employeeRequest.getFullName())
                .yearOfBirth(employeeRequest.getYearOfBirth())
                .gender(employeeRequest.getGender())
                .phoneNumber(employeeRequest.getPhoneNumber())
                .identityCode(employeeRequest.getIdentityCode())
                .email(employeeRequest.getEmail())
                .address(employeeRequest.getAddress())
                .build();
    }

    public static EmployeeRequest convertEntityToRequest(EmployeeEntity employeeEntity) {
        return EmployeeRequest.builder()
                .id(employeeEntity.getId())
                .employeeCode(employeeEntity.getEmployeeCode())
                .employeeGroup(employeeEntity.getEmployeeGroup())
                .fullName(employeeEntity.getFullName())
                .yearOfBirth(employeeEntity.getYearOfBirth())
                .gender(employeeEntity.getGender())
                .phoneNumber(employeeEntity.getPhoneNumber())
                .identityCode(employeeEntity.getIdentityCode())
                .email(employeeEntity.getEmail())
                .address(employeeEntity.getAddress())
                .build();
    }
}
