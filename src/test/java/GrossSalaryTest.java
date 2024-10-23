import org.example.GrossSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrossSalaryTest {

    @Test
    public void netSalaryCorrect() {
        GrossSalary gross = new GrossSalary();
        assertEquals(BigDecimal.valueOf(902), gross.netSalary(BigDecimal.valueOf(1000)).setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void grossSalaryCorrect() {
        GrossSalary gross = new GrossSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(902), gross.netSalary(BigDecimal.valueOf(1000)).setScale(0, RoundingMode.HALF_UP));
    }


}
