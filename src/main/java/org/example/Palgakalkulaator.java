package org.example;

public class Palgakalkulaator {

    public static final double INCOME_TAX_RATE = 0.2;
    public static final double ACC_PENSION_RATE = 0.02;
    public static final double EMT_INSURANCE_RATE = 0.016;

    public static final double TAX_FREE_MIN_SALARY = 1200;
    public static final double TAX_FREE_MAX_SALARY = 2100;


    public double netSalary(double grossSalary){

        return grossSalary - incomeTax(grossSalary)
                 - accPension(grossSalary)
                 - emtInsurance(grossSalary);
    }

    public double incomeTax(double grossSalary){
        double incomeTaxSum = grossSalary - accPension(grossSalary)- emtInsurance(grossSalary)- calculateIncomeTaxFreeMin(grossSalary);
        return incomeTaxSum* INCOME_TAX_RATE;
    }

    public double calculateIncomeTaxFreeMin (double grossSalary){
        var incomeTaxMin = 654.0;

        if(grossSalary >= TAX_FREE_MIN_SALARY && grossSalary < TAX_FREE_MAX_SALARY){
           incomeTaxMin = (incomeTaxMin - incomeTaxMin / 900.0 * (grossSalary - TAX_FREE_MIN_SALARY));
        } else if (grossSalary >= TAX_FREE_MAX_SALARY ) {
            incomeTaxMin = 0.0;
        }
        return incomeTaxMin;
    }

    public double accPension(double grossSalary){
            return grossSalary* ACC_PENSION_RATE;
    }
    public double emtInsurance(double grossSalary){
            return grossSalary* EMT_INSURANCE_RATE;
    }
}
