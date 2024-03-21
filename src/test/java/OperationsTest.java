import datamodels.Polynomial;
import logic.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void testAddition() {
        Polynomial p1 = new Polynomial();
        p1.readPolynomialFromUser("2x^2+3x^1+4x^0");
        Polynomial p2 = new Polynomial();
        p2.readPolynomialFromUser("3x^2+2x^1+1x^0");
        Polynomial result = Operations.add(p1, p2);
        assertEquals("5x^2+5x+5", result.convertString());
    }
    @Test
    public void testSubtraction() {
        Polynomial p1 = new Polynomial();
        p1.readPolynomialFromUser("2x^2+3x^1+4x^0");
        Polynomial p2 = new Polynomial();
        p2.readPolynomialFromUser("3x^2+2x^1+1x^0");
        Polynomial result = Operations.subtract(p1, p2);
        assertEquals("-1x^2+1x+3", result.convertString());
    }
    @Test
    public void testMultiplication() {
        Polynomial p1 = new Polynomial();
        p1.readPolynomialFromUser("2x^2+3x^1+4x^0");
        Polynomial p2 = new Polynomial();
        p2.readPolynomialFromUser("3x^2+2x^1+1x^0");
        Polynomial result = Operations.multiply(p1, p2);
        assertEquals("6x^4+13x^3+20x^2+11x+4", result.convertString());
    }
    @Test
    public void testDerivation() {
        Polynomial p1 = new Polynomial();
        p1.readPolynomialFromUser("2x^2+3x^1+4x^0");
        Polynomial result = Operations.derivate(p1);
        assertEquals("4x+3", result.convertString());
    }
    @Test
    public void testIntegration() {
        Polynomial p1 = new Polynomial();
        p1.readPolynomialFromUser("2x^2+3x^1+4x^0");
        Polynomial result = Operations.integrate(p1);
        assertEquals("0.667x^3+1.5x^2+4x", result.convertString());
    }

}
