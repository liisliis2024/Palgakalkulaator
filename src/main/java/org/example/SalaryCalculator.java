package org.example;

public class SalaryCalculator {

    // todo: changes types to bigDecimals
    // todo: create interface Salary
    // todo: create seperate classes grossSalary, netSalary
    // todo: igale salaryle tostring meetod, et igauks end ise valja prindiks

    public static final double INCOME_TAX_RATE = 0.2;
    public static final double ACC_PENSION_RATE = 0.02;
    public static final double EMT_INSURANCE_RATE_EMPLOYEE = 0.016;
    public static final double SOCIAL_TAX_RATE = 0.33;
    public static final double EMT_INSURANCE_RATE_EMPLOYER = 0.008;

    public static final double TAX_FREE_MIN_SALARY = 1200;
    public static final double TAX_FREE_MAX_SALARY = 2100;

    public double calculateNetToGross(double netSalary) {
        var grossSalaryNoIncomeTax = netSalary / (1 - INCOME_TAX_RATE);
        return grossSalaryNoIncomeTax / (1 - EMT_INSURANCE_RATE_EMPLOYEE - ACC_PENSION_RATE);
    }

    public double netSalary(double grossSalary) {
        return grossSalary - incomeTax(grossSalary)
                - accPension(grossSalary)
                - emtInsuranceEmployee(grossSalary);
    }

    public double incomeTax(double grossSalary) {
        double incomeTaxSum = grossSalary - accPension(grossSalary) - emtInsuranceEmployee(grossSalary) - calculateIncomeTaxFreeMin(grossSalary);
        return incomeTaxSum * INCOME_TAX_RATE;
    }

    public double calculateIncomeTaxFreeMin(double grossSalary) {
        var incomeTaxMin = 654.0;

        if (grossSalary >= TAX_FREE_MIN_SALARY && grossSalary < TAX_FREE_MAX_SALARY) {
            incomeTaxMin = (incomeTaxMin - incomeTaxMin / 900.0 * (grossSalary - TAX_FREE_MIN_SALARY));
        } else if (grossSalary >= TAX_FREE_MAX_SALARY) {
            incomeTaxMin = 0.0;
        }
        return incomeTaxMin;
    }

    public double calculateAnnualSalary(double grossSalary) {
        return grossSalary * 12;
    }

    public double accPension(double grossSalary) {
        return grossSalary * ACC_PENSION_RATE;
    }

    public double emtInsuranceEmployee(double grossSalary) {
        return grossSalary * EMT_INSURANCE_RATE_EMPLOYEE;
    }

    public double emtInsuranceEmployer(double grossSalary) {
        return grossSalary * EMT_INSURANCE_RATE_EMPLOYER;
    }

    public double calculateSocialTax(double grossSalary) {
        return grossSalary * SOCIAL_TAX_RATE;
    }
}
