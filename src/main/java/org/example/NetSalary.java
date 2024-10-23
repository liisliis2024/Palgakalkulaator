package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetSalary extends SalaryCalculator {
    BigDecimal grossSalary;
    BigDecimal netSalary;

    public NetSalary(BigDecimal netSalary) {
        this.grossSalary = grossSalary(netSalary);
        this.netSalary = netSalary;
    }

    @Override
    public BigDecimal grossSalary(BigDecimal netSalary) {
        BigDecimal one = BigDecimal.ONE;
        var grossSalaryNoIncomeTax = netSalary.divide(one.subtract(INCOME_TAX_RATE), 10, RoundingMode.HALF_UP);
        return this.netSalary = grossSalaryNoIncomeTax.divide
                (one.subtract(EMT_INSURANCE_RATE_EMPLOYEE).subtract(ACC_PENSION_RATE), 10, RoundingMode.HALF_UP);
    }

    public BigDecimal getGrossSalary() {return grossSalary;}

    public BigDecimal getNetSalary() {return netSalary;}
}
