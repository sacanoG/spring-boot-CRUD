package io.quind.calculatorsalary.business;

import io.quind.calculator.Calculator;

import java.text.DecimalFormat;

public class Salary {

    private double baseSalary;
    private double transportAid;
    private double tax;

    private static DecimalFormat salaryStandardFormat = new DecimalFormat("#.##");

    private Calculator calculator = new Calculator();

    public double getTransportAid() {
        return transportAid;
    }

    public double getTax() {
        return tax;
    }

    public double getSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setTransportAid(double transportAid) {
        this.transportAid = transportAid;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void calculateTransportAid()
    {
        this.transportAid = Double.parseDouble(salaryStandardFormat.format(calculator.multi(baseSalary, 0.1)));
    }

    public void calculateTax()
    {
        this.tax = Double.parseDouble(salaryStandardFormat.format(calculator.multi(baseSalary,0.2)));
    }
}
