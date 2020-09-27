package co.com.sancanoga.calculatorsalary.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalaryRepository implements ISalaryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Double consultById(Long id) {
        return jdbcTemplate.queryForObject(
                "select salary from employees where id = ?",
                new Object[]{id},
                Double.class
        );
    }
}
