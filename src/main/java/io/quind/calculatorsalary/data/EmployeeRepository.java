package io.quind.calculatorsalary.data;

import io.quind.calculatorsalary.business.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Employee> consult() {
        return jdbcTemplate.query(
                "select * from employees",
                (rs, rowNum) ->
                        new Employee(
                                rs.getLong("id"),
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getDouble("salary")
                        )
        );
    }

    @Override
    public Optional<Employee> consultById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from employees where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Employee(
                                rs.getLong("id"),
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getDouble("salary")
                        ))
        );
    }

    @Override
    public int create(Employee employee) {
        return jdbcTemplate.update(
                "insert into employees (id, firstname, lastname, salary) values(?,?,?,?)",
                employee.getId(), employee.getName(), employee.getLastName(), employee.getBaseSalary());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update(
                "update employees set firstname = ? , lastname= ?, salary = ? where id = ?",
                employee.getName(), employee.getLastName(), employee.getBaseSalary(), employee.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from employees where id = ?", id);
    }
}
