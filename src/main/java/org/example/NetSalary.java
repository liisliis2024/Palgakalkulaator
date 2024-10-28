package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NetSalary extends Salary {
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
        BigDecimal taxFreeMinNetSalary = calculateTaxFreeNetSalary(TAX_FREE_MIN_SALARY);
        BigDecimal taxFreeMaxNetSalary = calculateTaxFreeNetSalary(TAX_FREE_MAX_SALARY);

        this.incomeTaxMin = INCOME_TAX_MIN;
        if (netSalary.compareTo(taxFreeMinNetSalary) >= 0 && netSalary.compareTo(taxFreeMaxNetSalary) < 0) {
            this.incomeTaxMin = (taxFreeMaxNetSalary.subtract(netSalary))
                    .multiply(INCOME_TAX_MIN)
                    .divide((taxFreeMaxNetSalary.subtract(taxFreeMinNetSalary)), 4, RoundingMode.HALF_UP);
        } else if (netSalary.compareTo(taxFreeMaxNetSalary) >= 0) {
            this.incomeTaxMin = BigDecimal.ZERO;
        } else if (netSalary.compareTo(INCOME_TAX_MIN) < 0) {
            this.incomeTaxMin = netSalary;
        }
        return incomeTaxMin;
    }

    public BigDecimal calculateTaxFreeNetSalary (BigDecimal salary) {
        BigDecimal netSalary = salary;

        if(salaryParameters.considerTaxFreeIncome) {
            netSalary = netSalary.subtract((salary.multiply(EMT_INSURANCE_RATE_EMPLOYEE)));
        }
        if(salaryParameters.considerPension) {
            netSalary = netSalary.subtract((salary.multiply(ACC_PENSION_RATE)));
        }
        if(salaryParameters.considerTaxFreeIncome && salary == TAX_FREE_MIN_SALARY) {
            netSalary = netSalary.subtract(netSalary.subtract(INCOME_TAX_MIN).multiply(INCOME_TAX_RATE));
        } else if (salaryParameters.considerTaxFreeIncome && salary == TAX_FREE_MAX_SALARY) {
            netSalary = netSalary.subtract(netSalary.multiply(INCOME_TAX_RATE));
        }
        return netSalary;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }
}
