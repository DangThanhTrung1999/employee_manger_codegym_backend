package com.trung.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String employeeCode;
    String employeeGroup;
    String fullName;
    Integer yearOfBirth;
    String gender;
    String phoneNumber;
    Integer identityCode;
    String email;
    String address;
}
