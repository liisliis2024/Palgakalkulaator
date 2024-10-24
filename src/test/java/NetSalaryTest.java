import org.example.GrossSalary;
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
    @Test
    void grossSalaryIsCorrectB() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1296.68), obj.getGrossSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void incomeTaxFreeMinIsCorrect() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1500));
        assertEquals(BigDecimal.valueOf(138.77), obj.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryIsCorrect() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), obj.netSalary().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryLowerThenTaxFreeMinNetSalary() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(450));
        assertEquals(BigDecimal.valueOf(450), obj.calculateIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryHigherThenTaxFreeMinNetSalary() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1700));
        assertEquals(BigDecimal.ZERO, obj.calculateIncomeTaxFreeMin().setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    void netSalaryBetweenTaxFreeMinAndMaxNetSalary() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1300));
        assertEquals(BigDecimal.valueOf(370.98), obj.calculateIncomeTaxFreeMin().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void accPensionRateCorrect() {
        NetSalary obj = new NetSalary(BigDecimal.valueOf(1300));
        assertEquals(BigDecimal.valueOf(31.79), obj.accPension().setScale(2, RoundingMode.HALF_UP));
    }


}
