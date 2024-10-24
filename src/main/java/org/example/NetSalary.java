package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetSalary extends Salary {
    public static final BigDecimal TAX_FREE_MIN_NETSALARY = new BigDecimal(1056.24);
    public static final BigDecimal TAX_FREE_MAX_NETSALARY = new BigDecimal(1619.52);

    public NetSalary(BigDecimal netSalary) {
        this.grossSalary = grossSalary(netSalary);
        this.netSalary = netSalary;
    }

    @Override
    public BigDecimal grossSalary(BigDecimal netSalary) {
        BigDecimal one = BigDecimal.ONE;
        var grossSalaryNoIncomeTax = netSalary.divide(one.subtract(INCOME_TAX_RATE), 10, RoundingMode.HALF_UP);
        return this.grossSalary = grossSalaryNoIncomeTax.divide
                (one.subtract(EMT_INSURANCE_RATE_EMPLOYEE).subtract(ACC_PENSION_RATE), 10, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calculateIncomeTaxFreeMin() {
        var incomeTaxMin = INCOME_TAX_MIN;

        if (netSalary.compareTo(TAX_FREE_MIN_NETSALARY) >= 0 && netSalary.compareTo(TAX_FREE_MAX_NETSALARY) < 0) {
            incomeTaxMin = (TAX_FREE_MAX_NETSALARY.subtract(netSalary))
                    .multiply(INCOME_TAX_MIN)
                    .divide((TAX_FREE_MAX_NETSALARY.subtract(TAX_FREE_MIN_NETSALARY)), 10, RoundingMode.HALF_UP);
            ;
        } else if (netSalary.compareTo(TAX_FREE_MAX_NETSALARY) >= 0) {
            incomeTaxMin = BigDecimal.ZERO;
        } else if (netSalary.compareTo(TAX_FREE_MIN_NETSALARY) < 0) {
            incomeTaxMin = netSalary;
        }
        return incomeTaxMin;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
