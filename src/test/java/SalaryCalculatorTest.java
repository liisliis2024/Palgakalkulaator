import org.example.SalaryCalculator;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryCalculatorTest {
    SalaryCalculator calc = new SalaryCalculator();
    DecimalFormat df = new DecimalFormat("#.##");

    @Test
    void lowerThanTaxFreeMin() {
        var example = calc.incomeTax(1000);
        assertEquals(62, example);
    }

    @Test
    void betweenTaxFreeMinAndMax() {
        var example = calc.netSalary(1500);
        assertEquals(1244, example);
    }

    @Test
    void overTaxFreeMax() {
        var example = calc.netSalary(2200);
        assertEquals(1696.64, Math.round(example * 100.0) / 100.0);
    }

    @Test
    void accPensionRate() {
        var example = calc.accPension(1000);
        assertEquals(20, example);
    }

    @Test
    void emtInsuranceRateEmployee() {
        var example = calc.emtInsuranceEmployee(1000);
        assertEquals(16, example);
    }

    @Test
    void emtInsuranceRateEmployer() {
        var example = calc.emtInsuranceEmployer(1000);
        assertEquals(8, example);
    }

    @Test
    void netSalary() {
        var example = calc.netSalary(1000);
        assertEquals(902, example);
    }

    @Test
    void calculateIncomeTaxFreeMin() {
        var example = calc.calculateIncomeTaxFreeMin(1000);
        assertEquals(654.00, example);
    }

    @Test
    void calculateIncomeTaxFreeBetweenMinAndMax() {
        var example = calc.calculateIncomeTaxFreeMin(1689);
        assertEquals(298.66, Math.round(example * 100.0) / 100.0);
    }

    @Test
    void calculateIncomeTaxFreeMax() {
        var example = calc.calculateIncomeTaxFreeMin(3000);
        assertEquals(0, example);
    }

    @Test
    void calculateAnnualTaxFreeMin() {
        var example = calc.calculateAnnualSalary(900);
        assertEquals(10800.00, Math.round(example * 100.0) / 100.0);
    }

    @Test
    void calculateSocialTax() {
        var example = calc.calculateSocialTax(1000);
        assertEquals(330, example);
    }

    @Test
    void calculateNetToGross() {
        var example = calc.calculateNetToGross(2000);
        assertEquals(2593.36, Math.round(example * 100.0) / 100.0);
    }
}

