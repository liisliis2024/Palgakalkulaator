package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
        this.netSalary = netSalary();
    }

    @Override
    public BigDecimal grossSalary(BigDecimal grossSalary) {
        return this.grossSalary = grossSalary;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
