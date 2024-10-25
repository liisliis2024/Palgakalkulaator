import org.example.GrossSalary;
import org.example.Salary;
import org.example.SalaryParameters;
import org.example.SalaryType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossSalaryTest {

    @Test
    public void netSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("902"), newSalary.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void grossSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("902"), newSalary.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void lowerThanTaxFreeMinCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("62.00"), newSalary.incomeTax().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void betweenTaxFreeMinAndMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1500"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("1244.00"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void overTaxFreeMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("2000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("1556.93"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void accPensionRateCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("20.00"), newSalary.accPension().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployeeCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("16.00"), newSalary.emtInsuranceEmployee().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void emtInsuranceRateEmployerCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("8.00"), newSalary.emtInsuranceEmployer().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void incomeTaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("62.00"), newSalary.incomeTax().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeMinCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("654.00"), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeBetweenMinAndMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1689"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("298.66"), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IncomeTaxFreeMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("3000"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("0"), newSalary.calculateIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void AnnualSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("900"), SalaryType.GROSS, new SalaryParameters());
        assertEquals(new BigDecimal("10800.00"), newSalary.calculateAnnualSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerTaxFreeIncomeFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderTaxFreeIncome(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1500"), SalaryType.GROSS, parameters);
        assertEquals(new BigDecimal("1156.80"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerPensionFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderPension(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1600"), SalaryType.GROSS, parameters);
        assertEquals(new BigDecimal("1332.19"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerEmployerInsuranceTaxFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderEmployerInsuraceTax(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1700"), SalaryType.GROSS, parameters);
        assertEquals(new BigDecimal("1369.17"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerEmployeeInsuranceTaxFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderEmployeeInsuraceTax(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1500"), SalaryType.GROSS, parameters);
        assertEquals(new BigDecimal("1263.20"), newSalary.netSalary().setScale(2, RoundingMode.HALF_UP));
    }
}
