package io.quind.calculatorsalary.data;

import org.springframework.http.ResponseEntity;

public interface IGovernmentRepository {

    ResponseEntity<Object> consultEmployeeById(Long id);
}

