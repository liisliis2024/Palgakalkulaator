import org.example.GrossSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrossSalaryTest {

    @Test
    public void grossSalaryCorrect() {
        assertEquals(BigDecimal.valueOf(1000), new GrossSalary(BigDecimal.valueOf(1000)).getGrossSalary());
    }

    @Test
    public void netSalaryCorrect() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(1200));
        assertEquals(BigDecimal.valueOf(1056.24), gross.getNetSalary().setScale(2, RoundingMode.HALF_UP));
    }
    @Test
    public void incomeTaxCorrect() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(1400));
        assertEquals(BigDecimal.valueOf(168.19), gross.getIncomeTax().setScale(2, RoundingMode.HALF_UP));
    }
    @Test
    public void incomeTaxFreeMinLowerThenMin() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(300.0), gross.getIncomeTaxFreeMin().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void incomeTaxFreeMinLower() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(900));
        assertEquals(BigDecimal.valueOf(654.0), gross.getIncomeTaxFreeMin().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void incomeTaxFreeMinMiddle() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(1500));
        assertEquals(BigDecimal.valueOf(436.0), gross.getIncomeTaxFreeMin().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void incomeTaxFreeMinHigher() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(3000));
        assertEquals(BigDecimal.ZERO, gross.getIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void annualSalaryCorrect() {
        GrossSalary gross = new GrossSalary((BigDecimal.valueOf(1200)));
        assertEquals(BigDecimal.valueOf(14400.0), gross.getAnnualSalary().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void accPensionCorrect() {
        GrossSalary gross = new GrossSalary((BigDecimal.valueOf(1200)));
        assertEquals(BigDecimal.valueOf(24.0), gross.getAccPension().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void emtInsuranceEmployeeCorrect() {
        GrossSalary gross = new GrossSalary((BigDecimal.valueOf(1200)));
        assertEquals(BigDecimal.valueOf(19.2), gross.getEmtInsuranceEmployee().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void emtInsuranceEmployerCorrect() {
        GrossSalary gross = new GrossSalary((BigDecimal.valueOf(1200)));
        assertEquals(BigDecimal.valueOf(9.6), gross.getEmtInsuranceEmployer().setScale(1, RoundingMode.HALF_UP));
    }

    @Test
    public void socialTaxCorrect() {
        GrossSalary gross = new GrossSalary((BigDecimal.valueOf(1500)));
        assertEquals(BigDecimal.valueOf(495.0), gross.getSocialTax().setScale(1, RoundingMode.HALF_UP));
    }

}
