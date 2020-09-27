package co.com.sancanoga.calculatorsalary.data;

import co.com.sancanoga.calculatorsalary.business.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {

    List<Employee> consult();
    Optional<Employee> consultById(Long id);

    int create(Employee employee);
    int update(Employee employee);
    int deleteById(Long id);
}

