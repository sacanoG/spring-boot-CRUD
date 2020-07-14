package io.quind.calculatorsalary.business;

import org.springframework.http.ResponseEntity;

public interface IRegisterEmployeeUseCase {

    ResponseEntity<String> validateEmployeeInGovernmentSystem(Employee employee);
}

