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

    @Test
    public void testChainedOperations() {
        CalculatorPage calc = new CalculatorPage(driver);
        // Step 1: 2 + 3 = 5
        calc.enterNumber("2");
        calc.clickAdd();
        calc.enterNumber("5");
        calc.clickEquals();

        String firstResult = calc.getDisplayValue();
        Assert.assertEquals(firstResult, "7");

        // Step 2: Continue with * 4 = 28
        calc.clickMultiply();
        calc.enterNumber("4");
        calc.clickEquals();

        String finalResult = calc.getDisplayValue();
        Assert.assertEquals(finalResult, "28");
    }

    @Test
    public void testChainedOperationsBug() {
        CalculatorPage calc = new CalculatorPage(driver);

        // Step 1: 2 + 3 = 5
        calc.enterNumber("2");
        calc.clickAdd();
        calc.enterNumber("3");
        calc.clickEquals();

        String firstResult = calc.getDisplayValue();
        Assert.assertEquals(firstResult, "5");

        // Step 2: Continue with * 4 = 20
        calc.clickMultiply();
        calc.enterNumber("4");
        calc.clickEquals();

        String finalResult = calc.getDisplayValue();
        Assert.assertEquals(finalResult, "20");
    }

    @Test
    public void testDivisionBug() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("8");
        calc.clickDivide();
        calc.enterNumber("5");
        calc.clickEquals();

        String result = calc.getDisplayValue();

        Assert.assertEquals(result, "1.6",
                "Bug validation: Division of 8 ÷ 5 is incorrectly returning 0.625 instead of 1.6.");
    }

}
