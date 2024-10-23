import org.example.GrossSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossSalaryTest {
    GrossSalary example = new GrossSalary();

    @Test
    public void netSalaryCorrect() {
        assertEquals(BigDecimal.valueOf(902), example.netSalary(BigDecimal.valueOf(1000)).setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void grossSalaryCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(902), example.netSalary(BigDecimal.valueOf(1000)).setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void lowerThanTaxFreeMin() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(62.00), example.incomeTax(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void betweenTaxFreeMinAndMax() {
        BigDecimal grossSalary = BigDecimal.valueOf(1500);
        assertEquals(BigDecimal.valueOf(1244.00), example.netSalary(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void overTaxFreeMax() {
        BigDecimal grossSalary = BigDecimal.valueOf(2200);
        assertEquals(BigDecimal.valueOf(1696.64), example.netSalary(grossSalary).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void accPensionRate() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(20.00), example.accPension(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployee() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(16.00), example.emtInsuranceEmployee(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployer() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(8.00), example.emtInsuranceEmployer(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void incomeTax() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(62.00), example.incomeTax(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void calculateIncomeTaxFreeMin() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(654.00), example.calculateIncomeTaxFreeMin(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void calculateIncomeTaxFreeBetweenMinAndMax() {
        BigDecimal grossSalary = BigDecimal.valueOf(1689);

        assertEquals(BigDecimal.valueOf(298.66), example.calculateIncomeTaxFreeMin(grossSalary).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void calculateIncomeTaxFreeMax() {
        BigDecimal grossSalary = BigDecimal.valueOf(3000);
        assertEquals(BigDecimal.ZERO, example.calculateIncomeTaxFreeMin(grossSalary).setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void calculateAnnualSalary() {
        BigDecimal grossSalary = BigDecimal.valueOf(900);
        assertEquals(BigDecimal.valueOf(10800.00), example.calculateAnnualSalary(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void calculateSocialTax() {
        BigDecimal grossSalary = BigDecimal.valueOf(1000);
        assertEquals(BigDecimal.valueOf(330.00), example.socialTax(grossSalary).setScale(1, RoundingMode.HALF_UP));
    }
}
