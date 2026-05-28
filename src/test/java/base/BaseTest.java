package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import driver.DriverManager;

import listeners.ExtentTestListener;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(ExtentTestListener.class)
public class BaseTest {

    protected WebDriver driver;

    protected static ExtentReports extent;

    // Thread-safe ExtentTest
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("target/extent-report.html");

        sparkReporter.config().setReportName("RBIH Calculator Automation Report");
        sparkReporter.config().setDocumentTitle("Automation Execution Report");

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Framework", "Selenium + TestNG");
        extent.setSystemInfo("Execution Environment", "GitHub Actions CI");
        extent.setSystemInfo("Author", "Snehasish Roy");

        System.out.println("Extent Report Initialized");
    }

    @BeforeMethod
    public void setUp(Method method) {

        driver = DriverManager.getDriver();

        driver.get("https://rbihubcodechallenge.github.io/calculator/index.html");

        ExtentTest extentTest = extent.createTest(method.getName());

        test.set(extentTest);

        System.out.println("Starting Test: " + method.getName());
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();

        System.out.println("Test Execution Completed");
    }

    @AfterSuite
    public void flushReport() {

        if (extent != null) {

            extent.flush();

            System.out.println("Extent Report Flushed Successfully");
        }
    }
}

