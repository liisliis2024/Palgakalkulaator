package org.example;

import java.math.BigDecimal;

public interface Salary {
    public static final BigDecimal INCOME_TAX_RATE = new BigDecimal(0.2);
    public static final BigDecimal ACC_PENSION_RATE = new BigDecimal(0.02);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYEE = new BigDecimal(0.016);
    public static final BigDecimal SOCIAL_TAX_RATE = new BigDecimal(0.33);
    public static final BigDecimal EMT_INSURANCE_RATE_EMPLOYER = new BigDecimal(0.008);

    public static final BigDecimal TAX_FREE_MIN_SALARY = new BigDecimal(1200);
    public static final BigDecimal TAX_FREE_MAX_SALARY = new BigDecimal(2100);

    public void netSalary();
    public void incomeTax();
    public void incomeTaxFreeMin();
    public void annualSalary();
    public void accPension();
    public void emtInsuranceEmployee();
    public void emtInsuranceEmployer();
    public void socialTax();
}
