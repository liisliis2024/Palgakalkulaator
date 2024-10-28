package org.example;

public class SalaryParameters {

    public boolean considerTaxFreeIncome = true;
    public boolean considerEmployerInsuraceTax = true;
    public boolean considerEmployeeInsuraceTax = true;
    public boolean considerPension = true;

    public void setConsiderTaxFreeIncome(boolean considerTaxFreeIncome) {
        this.considerTaxFreeIncome = considerTaxFreeIncome;
    }

    public void setConsiderEmployerInsuraceTax(boolean considerEmployerInsuraceTax) {
        this.considerEmployerInsuraceTax = considerEmployerInsuraceTax;
    }

    public void setConsiderPension(boolean considerPension) {
        this.considerPension = considerPension;
    }

    public void setConsiderEmployeeInsuraceTax(boolean considerEmployeeInsuraceTax) {
        this.considerEmployeeInsuraceTax = considerEmployeeInsuraceTax;
    }
}
