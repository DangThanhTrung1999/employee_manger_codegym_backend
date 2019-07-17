package com.trung.service;

import com.trung.entity.EmployeeEntity;

public interface EmployeeService {
    Iterable<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    void save(EmployeeEntity EmployeeEntity);

    void remove(Long id);

    EmployeeEntity findByEmployeeCode(String employeeCode);

    EmployeeEntity findByName(String name);
}
