package io.quind.calculatorsalary.services;

import io.quind.calculatorsalary.business.Salary;
import io.quind.calculatorsalary.data.SalaryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.Mockito.when;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class CalculatorSalaryControllerTest {

    @InjectMocks
    CalculatorSalaryController calculatorSalaryController;

    @Mock
    SalaryRepository salaryRepository;

    @Test
    public void consultSalaryOfEmployeeShouldReturnCorrectResult()
    {
        /*MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(salaryRepository.consultById((long) 342)).thenReturn(1_000_000.00);
        ResponseEntity salary = calculatorSalaryController.consultById((long) 342);
        assertThat(salary.getSalary()).isEqualTo(1_000_000.00);
        assertThat(salary.getTransportAid()).isEqualTo(100_000.00);
        assertThat(salary.getTax()).isEqualTo(200_000.0);*/

    }


}
