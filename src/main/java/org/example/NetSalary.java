package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetSalary extends Salary {
    public static final BigDecimal TAX_FREE_MIN_NETSALARY = new BigDecimal(1056.24);
    public static final BigDecimal TAX_FREE_MAX_NETSALARY = new BigDecimal(1619.52);

    // todo: NetSalary klassis muuda considerTaxFreeIncomeFalse() & considerPensionFalse() &....


    public NetSalary(BigDecimal netSalary, SalaryParameters salaryParameters) {
        super(netSalary, salaryParameters);
    }

    @Override
    public BigDecimal grossSalary(BigDecimal netSalary) {
        calculateIncomeTaxFreeMinFromNet(netSalary);
        var grossSalaryNoIncomeTax = netSalary.divide(BigDecimal.ONE.subtract(INCOME_TAX_RATE), 4, RoundingMode.HALF_UP);

        if (salaryParameters.considerTaxFreeIncome) {
            grossSalaryNoIncomeTax = (netSalary.subtract(incomeTaxMin)).divide(BigDecimal.ONE.subtract(INCOME_TAX_RATE), 4, RoundingMode.HALF_UP)
                    .add(incomeTaxMin);
        }
        if (salaryParameters.considerPension && salaryParameters.considerEmployeeInsuraceTax) {
            return this.grossSalary = grossSalaryNoIncomeTax.divide
                    (BigDecimal.ONE.subtract(EMT_INSURANCE_RATE_EMPLOYEE).subtract(ACC_PENSION_RATE), 10, RoundingMode.HALF_UP);
        } else if (!salaryParameters.considerPension && salaryParameters.considerEmployeeInsuraceTax) {
            return this.grossSalary = grossSalaryNoIncomeTax.divide
                    (BigDecimal.ONE.subtract(EMT_INSURANCE_RATE_EMPLOYEE), 10, RoundingMode.HALF_UP);
        } else if (salaryParameters.considerPension) {
            return this.grossSalary = grossSalaryNoIncomeTax.divide
                    (BigDecimal.ONE.subtract(ACC_PENSION_RATE), 10, RoundingMode.HALF_UP);
        } else return this.grossSalary = grossSalaryNoIncomeTax;
    }


    public BigDecimal calculateIncomeTaxFreeMinFromNet(BigDecimal netSalary) {
        this.incomeTaxMin = INCOME_TAX_MIN;
        if (netSalary.compareTo(TAX_FREE_MIN_NETSALARY) >= 0 && netSalary.compareTo(TAX_FREE_MAX_NETSALARY) < 0) {
            this.incomeTaxMin = (TAX_FREE_MAX_NETSALARY.subtract(netSalary))
                    .multiply(INCOME_TAX_MIN)
                    .divide((TAX_FREE_MAX_NETSALARY.subtract(TAX_FREE_MIN_NETSALARY)), 4, RoundingMode.HALF_UP);
        } else if (netSalary.compareTo(TAX_FREE_MAX_NETSALARY) >= 0) {
            this.incomeTaxMin = BigDecimal.ZERO;
        } else if (netSalary.compareTo(INCOME_TAX_MIN) < 0) {
            this.incomeTaxMin = netSalary;
        }
        return incomeTaxMin;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
