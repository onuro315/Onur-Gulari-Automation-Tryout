package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage extends Base {

    String mainWindow;
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = Base.webDriver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By by){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public List findElements(By by){
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        List<WebElement> elements = webDriver.findElements(by);
        return elements;
    }

    public void click(By by){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void javascriptClick(By by){
        WebElement element = findElement(by);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void waitToLoad(){
        while (true)
        {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
        }}

    public void scrollIntoView(By by){
        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    public void hoverOn(By by){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void switchWindow(){
        mainWindow = webDriver.getWindowHandle();
        Set <String> windowList = driver.getWindowHandles();
        Iterator <String> windowIterator = windowList.iterator();

        while(windowIterator.hasNext()){
            String ChildWindow = windowIterator.next();

            if(!mainWindow.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
            }
        }
    }
}
