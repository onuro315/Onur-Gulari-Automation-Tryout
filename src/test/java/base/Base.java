package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {

    protected static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Base.webDriver = webDriver;
    }

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser){

        if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");

            WebDriverManager.chromedriver().setup();
            setWebDriver(new ChromeDriver(options));

            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.navigate().to("https://useinsider.com/");
        }else if(browser.equals("firefox")){

            WebDriverManager.firefoxdriver().setup();
            setWebDriver(new FirefoxDriver());

            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.navigate().to("https://useinsider.com/");
        }

    }

    @AfterTest
    public void endTest(){
        webDriver.quit();
    }

}
