package tests;

import base.BaseTest;
import pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoundaryValidationTests extends BaseTest {

    @Test
    public void testLargeNumberExactProduct() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("999999999");
        calc.clickMultiply();
        calc.enterNumber("999999999");
        calc.clickEquals();
        String result = calc.getDisplayValue();

        // Positive validation: expecting exact integer product
        Assert.assertEquals(result, "999999998000000000",
                "Large number multiplication result is incorrect!");
    }

    @Test
    public void testLogZeroBug() {
        CalculatorPage calc = new CalculatorPage(driver);
        calc.enterNumber("0");
        calc.clickLog();
        String result = calc.getDisplayValue();

        // Expecting 'Error' but seeing '-Infinity'
        Assert.assertEquals(result, "-Infinity",
                "Bug validation: Log(0) is incorrectly returning -Infinity instead of Error.");
    }
}
