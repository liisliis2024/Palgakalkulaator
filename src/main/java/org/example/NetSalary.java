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
        BigDecimal grossSalaryNoIncomeTax = calculateGrossSalaryNoIncomeTax(netSalary);
        if (salaryParameters.considerTaxFreeIncome) {
            grossSalaryNoIncomeTax = adjustForTaxFreeIncome(netSalary);
        }
        return calculateFinalGrossSalary(grossSalaryNoIncomeTax);
    }

    private BigDecimal calculateGrossSalaryNoIncomeTax(BigDecimal netSalary) {
        return netSalary.divide(BigDecimal.ONE.subtract(INCOME_TAX_RATE), 4, RoundingMode.HALF_UP);
    }

    private BigDecimal adjustForTaxFreeIncome(BigDecimal netSalary) {
        return (netSalary.subtract(incomeTaxMin))
                .divide(BigDecimal.ONE.subtract(INCOME_TAX_RATE), 4, RoundingMode.HALF_UP)
                .add(incomeTaxMin);
    }

    private BigDecimal calculateFinalGrossSalary(BigDecimal grossSalaryNoIncomeTax) {
        BigDecimal divisor = BigDecimal.ONE;
        divisor = applyPensionAndInsurance(divisor, EMT_INSURANCE_RATE_EMPLOYEE, ACC_PENSION_RATE);
        return this.grossSalary = grossSalaryNoIncomeTax.divide(divisor, 10, RoundingMode.HALF_UP);
    }

    public void calculateIncomeTaxFreeMinFromNet(BigDecimal netSalary) {
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
    }

    public BigDecimal calculateTaxFreeNetSalary(BigDecimal salary) {
        BigDecimal netSalary = salary;

        netSalary = applyPensionAndInsurance(netSalary, (salary.multiply(EMT_INSURANCE_RATE_EMPLOYEE)), (salary.multiply(ACC_PENSION_RATE)));
        netSalary = includeTaxFreeIncome(salary, netSalary);
        return netSalary;
    }

    private BigDecimal applyPensionAndInsurance(BigDecimal netSalary, BigDecimal salary, BigDecimal salary1) {
        if (salaryParameters.considerEmployeeInsuraceTax) {
            netSalary = netSalary.subtract(salary);
        }
        if (salaryParameters.considerPension) {
            netSalary = netSalary.subtract(salary1);
        }
        return netSalary;
    }

    private BigDecimal includeTaxFreeIncome(BigDecimal salary, BigDecimal netSalary) {
        if (salaryParameters.considerTaxFreeIncome && salary == TAX_FREE_MIN_SALARY) {
            netSalary = netSalary.subtract(netSalary.subtract(INCOME_TAX_MIN).multiply(INCOME_TAX_RATE));
        } else if (salaryParameters.considerTaxFreeIncome && salary == TAX_FREE_MAX_SALARY) {
            netSalary = netSalary.subtract(netSalary.multiply(INCOME_TAX_RATE));
        }
        return netSalary;
    }
}
