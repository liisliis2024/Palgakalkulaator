package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class GrossSalary implements Salary {
    BigDecimal netSalary;
    BigDecimal grossSalary;
    BigDecimal incomeTax;
    BigDecimal incomeTaxFreeMin;
    BigDecimal annualSalary;
    BigDecimal accPension;
    BigDecimal emtInsuranceEmployee;
    BigDecimal emtInsuranceEmployer;
    BigDecimal socialTax;

    public GrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
        accPension();
        emtInsuranceEmployee();
        incomeTaxFreeMin();
        incomeTax();
        netSalary();
        annualSalary();
        emtInsuranceEmployer();
        socialTax();
    }

    @Override
    public void netSalary() {
        this.netSalary = grossSalary.subtract(accPension)
                .subtract(emtInsuranceEmployee)
                .subtract(incomeTax);
    }

    @Override
    public void incomeTax() {
        BigDecimal incomeTaxSum = grossSalary.subtract(accPension)
                .subtract(emtInsuranceEmployee)
                .subtract(incomeTaxFreeMin);
        this.incomeTax = incomeTaxSum.multiply(INCOME_TAX_RATE);
    }

    @Override
    public void incomeTaxFreeMin() {
        var incomeTaxMin = BigDecimal.valueOf(654);
        var incomeTaxMax = BigDecimal.valueOf(900);

        if (grossSalary.compareTo(TAX_FREE_MIN_SALARY) >= 0 && grossSalary.compareTo(TAX_FREE_MAX_SALARY) < 0) {
            this.incomeTaxFreeMin = (incomeTaxMin.subtract(incomeTaxMin
                    .divide(incomeTaxMax, 10, RoundingMode.HALF_UP)
                    .multiply(grossSalary.subtract(TAX_FREE_MIN_SALARY))));
        } else if (grossSalary.compareTo(TAX_FREE_MAX_SALARY) >= 0) {
            this.incomeTaxFreeMin = BigDecimal.ZERO;
        } else if (grossSalary.compareTo(TAX_FREE_MIN_SALARY) < 0) {
            this.incomeTaxFreeMin = grossSalary;
        }else {
            this.incomeTaxFreeMin = incomeTaxMin;
        }
    }

    @Override
    public void annualSalary() {
        this.annualSalary = grossSalary.multiply(BigDecimal.valueOf(12));
    }

    @Override
    public void accPension() {
        this.accPension = grossSalary.multiply(ACC_PENSION_RATE);
    }

    @Override
    public void emtInsuranceEmployee() {
        this.emtInsuranceEmployee = grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYEE);
    }

    @Override
    public void emtInsuranceEmployer() {
        this.emtInsuranceEmployer = grossSalary.multiply(EMT_INSURANCE_RATE_EMPLOYER);
    }

    @Override
    public void socialTax() {
        this.socialTax = grossSalary.multiply(SOCIAL_TAX_RATE);
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getIncomeTaxFreeMin() {
        return incomeTaxFreeMin;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public BigDecimal getAccPension() {
        return accPension;
    }

    public BigDecimal getEmtInsuranceEmployee() {
        return emtInsuranceEmployee;
    }

    public BigDecimal getEmtInsuranceEmployer() {
        return emtInsuranceEmployer;
    }

    public BigDecimal getSocialTax() {
        return socialTax;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrossSalary that = (GrossSalary) o;
        return Objects.equals(netSalary, that.netSalary) && Objects.equals(grossSalary, that.grossSalary) && Objects.equals(incomeTax, that.incomeTax) && Objects.equals(incomeTaxFreeMin, that.incomeTaxFreeMin) && Objects.equals(annualSalary, that.annualSalary) && Objects.equals(accPension, that.accPension) && Objects.equals(emtInsuranceEmployee, that.emtInsuranceEmployee) && Objects.equals(emtInsuranceEmployer, that.emtInsuranceEmployer) && Objects.equals(socialTax, that.socialTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(netSalary, grossSalary, incomeTax, incomeTaxFreeMin, annualSalary, accPension, emtInsuranceEmployee, emtInsuranceEmployer, socialTax);
    }
}
