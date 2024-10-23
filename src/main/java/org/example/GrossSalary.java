package org.example;

import java.math.BigDecimal;

public class GrossSalary extends SalaryCalculator {
    BigDecimal grossSalary;
    BigDecimal netSalary;

    public GrossSalary() {}
    public GrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
        this.netSalary = netSalary(grossSalary);
    }

    public BigDecimal netSalary(BigDecimal grossSalary) {
       return this.netSalary =  grossSalary.subtract(accPension(grossSalary))
                .subtract(emtInsuranceEmployee(grossSalary))
                .subtract(incomeTax(grossSalary));
    }

    @Override
    public BigDecimal grossSalary(BigDecimal grossSalary) {
        return this.grossSalary = grossSalary;
    }
}
