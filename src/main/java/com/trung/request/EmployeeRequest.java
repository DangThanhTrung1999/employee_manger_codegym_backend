package com.trung.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class EmployeeRequest {
    Long id;
    @NotEmpty
    @Size(max = 12)
    String employeeCode;
    String employeeGroup;
    @NotEmpty
    @Size(min = 10, max = 100)
    String fullName;
    Integer yearOfBirth;
    String gender;
    @NotEmpty
    String phoneNumber;
    @NotNull
    Integer identityCode;
    @NotEmpty
    @Email
    String email;
    @NotEmpty
    @Size(max = 100)
    String address;
}
