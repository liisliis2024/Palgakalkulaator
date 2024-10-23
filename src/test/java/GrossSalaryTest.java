import org.example.GrossSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossSalaryTest {

    @Test
    public void netSalaryCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(902), example.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void grossSalaryCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(902), example.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void lowerThanTaxFreeMinCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(62.00), example.incomeTax().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void betweenTaxFreeMinAndMaxCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1500));
        assertEquals(BigDecimal.valueOf(1244.00), example.netSalary().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void overTaxFreeMaxCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(2000));
        assertEquals(BigDecimal.valueOf(1556.93), example.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void accPensionRateCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(20.00), example.accPension().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployeeCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(16.00), example.emtInsuranceEmployee().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployerCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(8.00), example.emtInsuranceEmployer().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void incomeTaxCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(62.00), example.incomeTax().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeMinCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(654.00), example.calculateIncomeTaxFreeMin().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeBetweenMinAndMaxCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1689));

        assertEquals(BigDecimal.valueOf(298.66), example.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeMaxCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(3000));
        assertEquals(BigDecimal.ZERO, example.calculateIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void AnnualSalaryCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(900));
        assertEquals(BigDecimal.valueOf(10800.00), example.calculateAnnualSalary().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    void totalSalaryCorrect() {
        GrossSalary example = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1338.00), example.totalSalary().setScale(1, RoundingMode.HALF_UP));
    }
}
