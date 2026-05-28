package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.reflect.Method;

@Listeners(ExtentTestListener.class)   // Register the listener
public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    public static ExtentTest test;     // static so listener can access it

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = DriverManager.getDriver();
        driver.get("https://rbihubcodechallenge.github.io/calculator/index.html");
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        extent.flush();
    }
}
