package io.quind.calculatorsalary.business;

import io.quind.calculatorsalary.data.IEmployeeRepository;
import io.quind.calculatorsalary.data.IGovernmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterEmployeeUseCase implements IRegisterEmployeeUseCase {

    @Autowired
    private IGovernmentRepository governmentGateway;

    @Autowired
    private IEmployeeRepository employeeRepository;

    public RegisterEmployeeUseCase(){
        super();
    }


    public ResponseEntity<String> validateEmployeeInGovernmentSystem(Employee employee){
        HttpStatus response = governmentGateway.consultEmployeeById(employee.getId()).getStatusCode();

        if (response == HttpStatus.OK){
            return new ResponseEntity<>("SAVE ERROR EMPLOYEE EXIST IN GOVERNMENT SYSTEM!", HttpStatus.CONFLICT);
        }else if (response == HttpStatus.NOT_FOUND){
            if (employeeRepository.create(employee)==1){
                return new ResponseEntity<>("SAVE OK!", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("SAVE ERROR!", HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>("SAVE ERROR!", response);
        }
    }

}
