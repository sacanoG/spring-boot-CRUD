package co.com.sancanoga.calculatorsalary.services;

import co.com.sancanoga.calculatorsalary.business.Salary;
import co.com.sancanoga.calculatorsalary.data.SalaryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorSalaryControllerTest {

    @InjectMocks
    CalculatorSalaryController calculatorSalaryController;

    @Mock
    SalaryRepository salaryRepository;

    @Test
    public void consultSalaryOfEmployeeShouldReturnCorrectResult() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(salaryRepository.consultById((long) 342)).thenReturn(1_000_000.00);

        Salary salary = (Salary) calculatorSalaryController.consultById((long) 342).getBody();

        assertThat(salary.getSalary()).isEqualTo(1_000_000.00);
        assertThat(salary.getTransportAid()).isEqualTo(100_000.00);
        assertThat(salary.getTax()).isEqualTo(200_000.0);

    }
}