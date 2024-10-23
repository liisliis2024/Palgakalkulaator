package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    @Override
    public BigDecimal grossSalary(BigDecimal grossSalary) {
        return this.grossSalary = grossSalary;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
