package factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Runner extends DriverFactory {

    @Test
    public void test() {
        initDriver("Chrome");
        WebDriver driver;
        driver = getDriver();
        driver.get("https://www.google.com");
        quitDriver();
    }


}
