package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalSalary extends Salary {
    public TotalSalary() {
    }

    public TotalSalary(BigDecimal totalSalary) {
        this.grossSalary = grossSalary(totalSalary);
    }

    @Override
    public BigDecimal grossSalary(BigDecimal totalSalary) {
        return this.grossSalary = totalSalary.divide(BigDecimal.ONE.add(SOCIAL_TAX_RATE)
                .add(EMT_INSURANCE_RATE_EMPLOYER), 10, RoundingMode.HALF_UP);
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
