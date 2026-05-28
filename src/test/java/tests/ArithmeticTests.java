package tests;

import base.BaseTest;
import pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticTests extends BaseTest {

    @Test
    public void testAddition() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("5");
        calc.clickAdd();
        calc.enterNumber("9");
        calc.clickEquals();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "14", "Addition result is incorrect!");
    }

    @Test
    public void testDigitThreeBug() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.clickClear();
        calc.enterNumber("3"); // try to press 3
        String result = calc.getDisplayValue();
        System.out.println("Result val:" + result);

        // Negative validation: expecting "3" but actually seeing "0"
        Assert.assertEquals(result, "0", "Bug validation: pressing '3' is showing something else!");
    }

    @Test
    public void testSubtractionBug() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.clickClear();
        calc.enterNumber("9");
        calc.clickSubtract(); // supposed to be minus, but UI maps to division
        calc.enterNumber("4");
        calc.clickEquals();
        String result = calc.getDisplayValue();

        // Negative validation: subtraction is broken, division result appears instead
        Assert.assertNotEquals(result, "5", "Bug validation: subtraction is not functioning correctly!");
        Assert.assertEquals(result, "0.4444444444444444",
                "Bug validation: pressing minus actually performs division.");
    }

    @Test
    public void testMultiplication() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("7");
        calc.clickMultiply();
        calc.enterNumber("6");
        calc.clickEquals();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "42", "Multiplication result is incorrect!");
    }

    @Test
    public void testDivision() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("8");
        calc.clickDivide();
        calc.enterNumber("2");
        calc.clickEquals();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "0.25", "Division result is incorrect!");
    }
}
