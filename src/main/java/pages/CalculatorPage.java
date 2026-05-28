package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage {
    private WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================== Digits ====================
    public void clickDigit(String digit) {
        driver.findElement(By.xpath("//button[text()='" + digit + "']")).click();
    }

    // ==================== Arithmetic operations ====================
    public void clickAdd() {
        driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
    }

    public void clickSubtract() {
        driver.findElement(By.xpath("//button[normalize-space()='−']")).click();
    }

    public void clickMultiply() {
        driver.findElement(By.xpath("//button[normalize-space()='×']")).click();
    }

    public void clickDivide() {
        driver.findElement(By.xpath("//button[normalize-space()='÷']")).click();
    }

    // ==================== Scientific operations ====================
    public void clickSin() {
        driver.findElement(By.xpath("//button[text()='sin']")).click();
    }

    public void clickCos() {
        driver.findElement(By.xpath("//button[text()='cos']")).click();
    }

    public void clickTan() {
        driver.findElement(By.xpath("//button[text()='tan']")).click();
    }

    public void clickSqrt() {
        driver.findElement(By.xpath("//button[text()='√']")).click();
    }

    public void clickLog() {
        driver.findElement(By.xpath("//button[text()='log']")).click();
    }

    // ==================== Equals ====================
    public void clickEquals() {
        driver.findElement(By.xpath("//button[text()='=']")).click();
    }

    // ==================== Clear ====================
    public void clickClear() {
        driver.findElement(By.xpath("//button[text()='C']")).click();
    }

    // ==================== Display ====================
    public String getDisplayValue() {
        return driver.findElement(By.id("display")).getAttribute("value");
    }

    // Enter a full number
    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            clickDigit(String.valueOf(digit));
        }
    }
}
