import org.example.GrossSalary;
import org.example.TotalSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalSalaryTest {
    //TotalSalary example = new TotalSalary();

    @Test
    public void totalSalaryCorrect() {
        TotalSalary example = new TotalSalary(BigDecimal.valueOf(1338));
        assertEquals(BigDecimal.valueOf(1000), example.grossSalary(BigDecimal.valueOf(1338)).setScale(0, RoundingMode.HALF_UP));
    }

}
