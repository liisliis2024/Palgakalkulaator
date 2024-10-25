package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(BigDecimal grossSalary, SalaryParameters salaryParameters){
        super(grossSalary, salaryParameters);
    }

    @Override
    public BigDecimal grossSalary(BigDecimal salary) {
        return this.grossSalary = salary;
    }
}
