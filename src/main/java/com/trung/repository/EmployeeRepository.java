package com.trung.repository;

import com.trung.entity.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {
}
