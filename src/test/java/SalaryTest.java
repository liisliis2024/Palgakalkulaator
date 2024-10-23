import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryTest {
    //SalaryCalculator calc = new SalaryCalculator();

//    @Test
//    void lowerThanTaxFreeMin() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.incomeTax(grossSalary);
//        assertEquals(BigDecimal.valueOf(62.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void betweenTaxFreeMinAndMax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1500);
//        var example = calc.netSalary(grossSalary);
//        assertEquals(BigDecimal.valueOf(1244.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void overTaxFreeMax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(2200);
//        var example = calc.netSalary(grossSalary);
//        assertEquals(BigDecimal.valueOf(1696.64), example.setScale(2, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void accPensionRate() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.accPension(grossSalary);
//        assertEquals(BigDecimal.valueOf(20.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void emtInsuranceRateEmployee() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.emtInsuranceEmployee(grossSalary);
//        assertEquals(BigDecimal.valueOf(16.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void emtInsuranceRateEmployer() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.emtInsuranceEmployer(grossSalary);
//        assertEquals(BigDecimal.valueOf(8.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void netSalary() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.netSalary(grossSalary);
//        assertEquals(BigDecimal.valueOf(902.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void payroll() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.totalSalary(grossSalary);
//        assertEquals(BigDecimal.valueOf(1338.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void incomeTax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.incomeTax(grossSalary);
//        assertEquals(BigDecimal.valueOf(62.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateIncomeTaxFreeMin() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.calculateIncomeTaxFreeMin(grossSalary);
//        assertEquals(BigDecimal.valueOf(654.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateIncomeTaxFreeBetweenMinAndMax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1689);
//        var example = calc.calculateIncomeTaxFreeMin(grossSalary);
//        assertEquals(BigDecimal.valueOf(298.66), example.setScale(2, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateIncomeTaxFreeMax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(3000);
//        var example = calc.calculateIncomeTaxFreeMin(grossSalary);
//        assertEquals(BigDecimal.ZERO, example.setScale(0, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateAnnualTaxFreeMin() {
//        BigDecimal grossSalary = BigDecimal.valueOf(900);
//        var example = calc.calculateAnnualSalary(grossSalary);
//        assertEquals(BigDecimal.valueOf(10800.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateSocialTax() {
//        BigDecimal grossSalary = BigDecimal.valueOf(1000);
//        var example = calc.socialTax(grossSalary);
//        assertEquals(BigDecimal.valueOf(330.00), example.setScale(1, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calculateNetToGross() {
//        BigDecimal netSalary = BigDecimal.valueOf(2000);
//        BigDecimal example = calc.calculateNetToGross(netSalary);
//        assertEquals(BigDecimal.valueOf(2593.36), example.setScale(2, RoundingMode.HALF_UP));
//    }
}

