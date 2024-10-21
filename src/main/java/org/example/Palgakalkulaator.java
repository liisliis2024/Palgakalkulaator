package org.example;

public class Palgakalkulaator {

    public static final double INCOME_TAX_RATE = 0.2;
    public static final double ACC_PENSION_RATE = 0.02;
    public static final double EMT_INSURANCE_RATE = 0.016;


    public double netSalary(double grossSalary){
        return grossSalary - incomeTax(grossSalary)
                 - accPension(grossSalary)
                 - emtInsurance(grossSalary);
    }

    public double incomeTax(double grossSalary){
        double incomeTaxSum = grossSalary- accPension(grossSalary)- emtInsurance(grossSalary);
        return incomeTaxSum* INCOME_TAX_RATE;
    }
    public double accPension(double grossSalary){
            return grossSalary* ACC_PENSION_RATE;
    }
    public double emtInsurance(double grossSalary){
            return grossSalary* EMT_INSURANCE_RATE;
    }

}
