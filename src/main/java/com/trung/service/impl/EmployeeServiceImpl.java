package com.trung.service.impl;

import com.trung.entity.EmployeeEntity;
import com.trung.repository.EmployeeRepository;
import com.trung.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public EmployeeEntity findByEmployeeCode(String employeeCode) {
        Iterable<EmployeeEntity> list = employeeRepository.findAll();
        for(EmployeeEntity employeeEntity: list){
            if(employeeEntity.getEmployeeCode().equals(employeeCode)) return employeeEntity;
        }
        return null;
    }

    @Override
    public EmployeeEntity findByName(String name) {
        Iterable<EmployeeEntity> list = employeeRepository.findAll();
        for(EmployeeEntity employeeEntity: list){
            if(employeeEntity.getFullName().equals(name)) return employeeEntity;
        }
        return null;
    }
}
