package constant;

import org.openqa.selenium.By;

public class HomePageConstant {

    //Locators
    public static final By ALLOW_COOKIES = By.id("wt-cli-accept-all-btn");
    public static final By MORE_DROPDOWN = By.xpath("(//a[@class='nav-link dropdown-toggle']/span[contains(text(),'More')])");
    public static final By DROPDOWN_CAREERS = By.xpath("//a[@href='https://useinsider.com/careers/']");
    //Texts
    public static final String HOME_PAGE_TITLE = "Insider personalization engine for seamless customer experiences";

}
