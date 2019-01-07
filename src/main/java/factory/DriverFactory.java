package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    private WebDriver webDriver;

    protected void initDriver(final String browserName) {
        if ("Chrome".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver(options);
        } else if ("Firefox".equalsIgnoreCase(browserName)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("Edge".equalsIgnoreCase(browserName)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        if (!(webDriver instanceof ChromeDriver)) {
            webDriver.manage().window().maximize();
        }
        threadLocalWebDriver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    protected void quitDriver() {
        if (webDriver != null) {
            threadLocalWebDriver.get().quit();
            threadLocalWebDriver.remove();
        }
    }

}
