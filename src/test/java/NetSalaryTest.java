import org.example.NetSalary;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetSalaryTest {

    @Test
    void grossSalaryIsCorrect() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1296.68), obj.getGrossSalary().setScale(2, RoundingMode.HALF_UP));
    }
//    @Test
//    void netSalaryIsCorrect() {
//        NetSalary obj = new NetSalary(BigDecimal.valueOf(1000));
//        assertEquals(BigDecimal.valueOf(1000), obj.netSalary().setScale(0, RoundingMode.HALF_UP));
//    }
}
