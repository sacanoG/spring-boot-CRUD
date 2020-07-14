package io.quind.calculatorsalary.services;

import io.quind.calculatorsalary.business.Employee;
import io.quind.calculatorsalary.business.IRegisterEmployeeUseCase;
import io.quind.calculatorsalary.data.IEmployeeRepository;
import io.quind.calculatorsalary.util.ApiHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("employees")
public class EmployeeController {


    @Autowired(required=true)
    private IEmployeeRepository employeeRepository;

    @Autowired(required=true)
    private IRegisterEmployeeUseCase registerEmployeeUseCase;

    @CrossOrigin
    @GetMapping(produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Employee> consult(){
        return employeeRepository.consult();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Object> consultById(@PathVariable(name="id") Long id){
        Optional<Employee> employee;
        try {
            employee = employeeRepository.consultById(id);
            return new ResponseEntity<>(employee, ApiHeaders.getHeaders() , HttpStatus.OK);
        }catch (EmptyResultDataAccessException e){
            if ("Incorrect result size: expected 1, actual 0".equals(e.getMessage())){
                return new ResponseEntity<>("Employee not exists", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Employee newEmployee){
        return registerEmployeeUseCase.validateEmployeeInGovernmentSystem(newEmployee);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable(name="id") Long id, @RequestBody Employee employee){
        if (employeeRepository.update(employee) == 1){
            return new ResponseEntity<>("UPDATE OK!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("UPDATE ERROR!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name="id") Long id) {
        if (employeeRepository.deleteById(id) == 1) {
            return new ResponseEntity<>("DELETE OK!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("DELETE ERROR!", HttpStatus.BAD_REQUEST);
        }
    }
}



