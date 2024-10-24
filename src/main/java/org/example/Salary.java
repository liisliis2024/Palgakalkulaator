package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryType.*;

public abstract class Salary {
    // todo: netToGross maksuvaba tulu lisamine NetSalary klassi
    // todo: tosta nii, koikide arvude jaoks oleks eraldi fieldid ja see arvutaks konstruktoris valja
    // ka TotalSalary classi puhul arvutame totalSalary() grossSalaryga??
    BigDecimal grossSalary;
    BigDecimal netSalary;
    BigDecimal incomeTaxMin;

    public static final BigDecimal INCOME_TAX_RATE = new BigDecimal(0.2);
    public static final BigDecimal ACC_PENSION_RATE = new BigDecimal(0.02);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYEE = new BigDecimal(0.016);
    public static final BigDecimal SOCIAL_TAX_RATE = new BigDecimal(0.33);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYER = new BigDecimal(0.008);

    public static final BigDecimal TAX_FREE_MIN_SALARY = new BigDecimal(1200);
    public static final BigDecimal TAX_FREE_MAX_SALARY = new BigDecimal(2100);
    public static final BigDecimal INCOME_TAX_MIN = new BigDecimal(654);

    public abstract BigDecimal grossSalary(BigDecimal grossSalary);

    public BigDecimal netSalary() {
        return grossSalary.subtract(accPension())
                .subtract(emtInsuranceEmployee())
                .subtract(incomeTax());
    }

    public BigDecimal incomeTax() {
        BigDecimal incomeTaxSum = grossSalary.subtract(accPension())
                .subtract(emtInsuranceEmployee())
                .subtract(calculateIncomeTaxFreeMin());
        return incomeTaxSum.multiply(INCOME_TAX_RATE);
    }

    public BigDecimal calculateIncomeTaxFreeMin() {
        var incomeTaxMax = BigDecimal.valueOf(900);
        incomeTaxMin = INCOME_TAX_MIN;

        if (grossSalary.compareTo(TAX_FREE_MIN_SALARY) >= 0 && grossSalary.compareTo(TAX_FREE_MAX_SALARY) < 0) {
            this.incomeTaxMin = (incomeTaxMin.subtract(incomeTaxMin
                    .divide(incomeTaxMax, 10, RoundingMode.HALF_UP)
                    .multiply(grossSalary.subtract(TAX_FREE_MIN_SALARY))));
        } else if (grossSalary.compareTo(TAX_FREE_MAX_SALARY) >= 0) {
            this.incomeTaxMin = BigDecimal.ZERO;
        } else if (grossSalary.compareTo(TAX_FREE_MIN_SALARY) < 0) {
            this.incomeTaxMin = grossSalary;
        }
        return incomeTaxMin;
    }

    public BigDecimal calculateAnnualSalary() {
        return grossSalary.multiply(BigDecimal.valueOf(12));
    }

    public BigDecimal accPension() {
        return grossSalary.multiply(ACC_PENSION_RATE);
    }

    public BigDecimal emtInsuranceEmployee() {
        return grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYEE);
    }

    public BigDecimal emtInsuranceEmployer() {
        return grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYER);
    }

    public BigDecimal socialTax() {
        return grossSalary.multiply(SOCIAL_TAX_RATE);
    }

    public BigDecimal totalSalary() {
        return grossSalary.add(emtInsuranceEmployer())
                .add(socialTax());
    }

    public static Salary getName(BigDecimal salary, SalaryType type) {
        return switch (type) {
            case NET -> new NetSalary(salary);
            case GROSS -> new GrossSalary(salary);
            case TOTAL -> new TotalSalary(salary);
        };
    }

    @Override
    public String toString() {
        var allData = new StringBuilder();

        allData.append("Total Salary: ")
                .append(totalSalary().setScale(2, RoundingMode.HALF_UP))
                .append("Social Tax: ")
                .append(socialTax().setScale(2, RoundingMode.HALF_UP))
                .append("Unemployment insurance contribution (employer): ")
                .append(emtInsuranceEmployer().setScale(2, RoundingMode.HALF_UP))
                .append("Gross Salary: ")
                .append(grossSalary.setScale(2, RoundingMode.HALF_UP))
                .append("Savings pension (II pillar): ")
                .append(accPension().setScale(2, RoundingMode.HALF_UP))
                .append("Unemployment insurance contribution (employee): ")
                .append(emtInsuranceEmployee().setScale(2, RoundingMode.HALF_UP))
                .append("Income Tax: ")
                .append(incomeTax().setScale(2, RoundingMode.HALF_UP))
                .append("Net Salary: ")
                .append(netSalary.setScale(2, RoundingMode.HALF_UP));

        return allData.toString();
    }

    public static void main(String[] args) {
        Salary example = Salary.getName(BigDecimal.valueOf(1000), GROSS);
        System.out.println(example);
    }
}
