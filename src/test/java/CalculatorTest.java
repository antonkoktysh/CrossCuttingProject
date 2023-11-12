import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = new Calculator();
        assertEquals(48,calculator.calculate("   12*5   - 36 / 3"));
        assertEquals(19,calculator.calculate("12 + 50 / 5 - 3  "));
        assertEquals(100,calculator.calculate("   20 * ( 45 + 5 ) / 10"));
        assertEquals(3,calculator.calculate("(0 - 1 + ( 45 + 5 ) * 2) / 33"));
        assertEquals(0,calculator.calculate("0/1"));
        assertEquals(16,calculator.calculate("  2*2*2*2"));
    }
}