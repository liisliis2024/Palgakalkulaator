import org.example.NetSalary;
import org.example.Salary;
import org.example.SalaryParameters;
import org.example.SalaryType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetSalaryTest {


    @Test
    public void IsNetSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("1000"), newSalary.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void grossSalaryIsCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("1127.07"), newSalary.grossSalary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void grossSalaryIsCorrectB() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("1127.07"), newSalary.grossSalary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void incomeTaxFreeMinIsCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1500"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("138.77"), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryIsCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("1000"), newSalary.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryBetweenTaxFreeMinAndMaxNetSalary() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1300"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("370.98"), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void accPensionRateCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1300"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("31.79"), newSalary.accPension().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsEmtInsuranceRateEmployeeCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("18.03"), newSalary.emtInsuranceEmployee().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsEmtInsuranceRateEmployerCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("9.02"), newSalary.emtInsuranceEmployer().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsIncomeTaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("86.50"), newSalary.incomeTax().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsIncomeTaxFreeMinCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1000"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("654.00"), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsIncomeTaxFreeBetweenMinAndMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1350"), SalaryType.NET, new SalaryParameters());
        assertEquals(BigDecimal.valueOf(312.93), newSalary.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void IsIncomeTaxFreeMaxCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1689"), SalaryType.NET, new SalaryParameters());
        assertEquals(BigDecimal.ZERO, newSalary.calculateIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void IsAnnualSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("900"), SalaryType.NET, new SalaryParameters());
        assertEquals(new BigDecimal("11968.88"), newSalary.calculateAnnualSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerTaxFreeIncomeFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderTaxFreeIncome(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1500"), SalaryType.NET, parameters);
        assertEquals(new BigDecimal("1945.02"), newSalary.grossSalary.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void considerEmployerInsuranceTaxFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderEmployerInsuraceTax(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1700"), SalaryType.NET, parameters);
        assertEquals(new BigDecimal("2931.8"), newSalary.totalSalary().setScale(1, RoundingMode.HALF_UP));
    }
}
