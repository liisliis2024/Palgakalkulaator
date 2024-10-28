package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalSalary extends Salary {
    BigDecimal totalSalary;

    public TotalSalary(BigDecimal totalSalary, SalaryParameters salaryParameters) {
        super(totalSalary, salaryParameters);
    }

    @Override
    public BigDecimal grossSalary(BigDecimal salary) {
        if (salaryParameters.considerEmployerInsuraceTax){
            return this.grossSalary = salary.divide(BigDecimal.ONE.add(SOCIAL_TAX_RATE)
                    .add(EMT_INSURANCE_RATE_EMPLOYER), 10, RoundingMode.HALF_UP);
        }else return this.grossSalary = salary.divide(BigDecimal.ONE.add(SOCIAL_TAX_RATE)
                , 10, RoundingMode.HALF_UP);
    }
}
