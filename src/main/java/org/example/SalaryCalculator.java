package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class SalaryCalculator {
    // todo: netToGross maksuvaba tulu lisamine
    // todo: igale salaryle tostring meetod, et igauks end ise valja prindiks

    public static final BigDecimal INCOME_TAX_RATE = new BigDecimal(0.2);
    public static final BigDecimal ACC_PENSION_RATE = new BigDecimal(0.02);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYEE = new BigDecimal(0.016);
    public static final BigDecimal SOCIAL_TAX_RATE = new BigDecimal(0.33);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYER = new BigDecimal(0.008);

    public static final BigDecimal TAX_FREE_MIN_SALARY = new BigDecimal(1200);
    public static final BigDecimal TAX_FREE_MAX_SALARY = new BigDecimal(2100);

    public abstract BigDecimal grossSalary(BigDecimal grossSalary );
    //public abstract BigDecimal netSalary(BigDecimal grossSalary );

    public BigDecimal totalSalary(BigDecimal grossSalary) {
        return grossSalary.add(emtInsuranceEmployer(grossSalary))
                .add(socialTax(grossSalary));
    }

    public BigDecimal incomeTax(BigDecimal grossSalary) {
        BigDecimal incomeTaxSum = grossSalary.subtract(accPension(grossSalary))
                .subtract(emtInsuranceEmployee(grossSalary))
                .subtract(calculateIncomeTaxFreeMin(grossSalary));
        return incomeTaxSum.multiply(INCOME_TAX_RATE);
    }

    public BigDecimal calculateIncomeTaxFreeMin(BigDecimal grossSalary) {
        var incomeTaxMin = BigDecimal.valueOf(654);
        var incomeTaxMax = BigDecimal.valueOf(900);

        if (grossSalary.compareTo(TAX_FREE_MIN_SALARY) >= 0 && grossSalary.compareTo(TAX_FREE_MAX_SALARY) < 0) {
            incomeTaxMin = (incomeTaxMin.subtract(incomeTaxMin
                    .divide(incomeTaxMax, 10, RoundingMode.HALF_UP)
                    .multiply(grossSalary.subtract(TAX_FREE_MIN_SALARY))));
        } else if (grossSalary.compareTo(TAX_FREE_MAX_SALARY) >= 0) {
            incomeTaxMin = BigDecimal.ZERO;
        }
        return incomeTaxMin;
    }

    public BigDecimal calculateAnnualSalary(BigDecimal grossSalary) {
        return grossSalary.multiply(BigDecimal.valueOf(12));
    }

    public BigDecimal accPension(BigDecimal grossSalary) {
        return grossSalary.multiply(ACC_PENSION_RATE);
    }

    public BigDecimal emtInsuranceEmployee(BigDecimal grossSalary) {
        return grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYEE);
    }

    public BigDecimal emtInsuranceEmployer(BigDecimal grossSalary) {
        return grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYER);
    }

    public BigDecimal socialTax(BigDecimal grossSalary) {
        return grossSalary.multiply(SOCIAL_TAX_RATE);
    }
}
