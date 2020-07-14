package io.quind.calculatorsalary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"io.quind.calculatorsalary.business","io.quind.calculatorsalary.services","io.quind.calculatorsalary.data","io.quind.calculatorsalary.gateway"})
@EntityScan("io.quind.calculatorsalary.business")
@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

}