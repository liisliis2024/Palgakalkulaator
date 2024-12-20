import org.example.Salary;
import org.example.SalaryParameters;
import org.example.SalaryType;
import org.example.TotalSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalSalaryTest {

    @Test
    public void totalSalaryCorrect() {
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1338"), SalaryType.TOTAL, new SalaryParameters());
        assertEquals(new BigDecimal("1000"), newSalary.grossSalary.setScale(0, RoundingMode.HALF_UP));
    }
    @Test
    void considerEmployerInsuranceTaxFalse() {
        SalaryParameters parameters = new SalaryParameters();
        parameters.setConsiderEmployerInsuraceTax(false);
        Salary newSalary = Salary.createNewSalary(new BigDecimal("1700"), SalaryType.TOTAL, parameters);
        assertEquals(new BigDecimal("1278.20"), newSalary.grossSalary.setScale(2, RoundingMode.HALF_UP));
    }

}
