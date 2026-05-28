package tests;

import base.BaseTest;
import pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScientificTests extends BaseTest {

    @Test
    public void testSin90() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("90");
        calc.clickSin();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "1", "Sin(90°) result is incorrect!");
    }

    @Test
    public void testCos0() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("0");
        calc.clickCos();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "1", "Cos(0°) result is incorrect!");
    }

    @Test
    public void testLog10() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("10");
        calc.clickLog();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "1", "Log10(10) result is incorrect!");
    }

    @Test
    public void testSqrt16() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("16");
        calc.clickSqrt();
        String result = calc.getDisplayValue();
        Assert.assertEquals(result, "4", "Square root of 16 is incorrect!");
    }
}
