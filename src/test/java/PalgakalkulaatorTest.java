import org.example.Palgakalkulaator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalgakalkulaatorTest {
    Palgakalkulaator calc = new Palgakalkulaator();

    @Test
    void incomeTaxRate() {
        var example = calc.incomeTax(1000);
        assertEquals(192.80,example);
    }

    @Test
    void accPensionRate() {
        var example = calc.accPension(1000);
        assertEquals(20,example);
    }
    @Test
    void emtInsuranceRate() {
        var example = calc.emtInsurance(1000);
        assertEquals(16,example);
    }
    @Test
    void netSalary() {
        var example = calc.netSalary(1000);
        assertEquals(771.20,example);
    }

}

