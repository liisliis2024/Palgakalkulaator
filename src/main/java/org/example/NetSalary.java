package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetSalary extends Salary {
    BigDecimal grossSalary;

    public NetSalary(BigDecimal netSalary) {
        this.grossSalary = grossSalary(netSalary);
    }

    @Override
    public BigDecimal grossSalary(BigDecimal netSalary) {
        BigDecimal one = BigDecimal.ONE;
        var grossSalaryNoIncomeTax = netSalary.divide(one.subtract(INCOME_TAX_RATE), 10, RoundingMode.HALF_UP);
        return this.grossSalary = grossSalaryNoIncomeTax.divide
                (one.subtract(EMT_INSURANCE_RATE_EMPLOYEE).subtract(ACC_PENSION_RATE), 10, RoundingMode.HALF_UP);
    }

    public BigDecimal getGrossSalary() {return grossSalary;}
}
