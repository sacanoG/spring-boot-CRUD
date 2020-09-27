package co.com.sancanoga.calculatorsalary.services;

import co.com.sancanoga.calculatorsalary.business.Salary;
import co.com.sancanoga.calculatorsalary.data.ISalaryRepository;
import co.com.sancanoga.calculatorsalary.util.ApiHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("salaries")
public class CalculatorSalaryController {

    @Autowired
    private ISalaryRepository salaryRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public ResponseEntity consultById(@PathVariable(name="id") Long id){
        Salary salary = new Salary();
        salary.setBaseSalary(salaryRepository.consultById(id));
        salary.calculateTransportAid();
        salary.calculateTax();

        return new ResponseEntity<>(salary, ApiHeaders.getHeaders(), HttpStatus.OK);
    }
}
