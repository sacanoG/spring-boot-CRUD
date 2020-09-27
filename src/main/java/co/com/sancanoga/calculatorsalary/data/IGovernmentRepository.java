package co.com.sancanoga.calculatorsalary.data;

import org.springframework.http.ResponseEntity;

public interface IGovernmentRepository {

    ResponseEntity<Object> consultEmployeeById(Long id);
}

