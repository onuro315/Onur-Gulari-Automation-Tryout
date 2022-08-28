package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static constant.CareersPageConstant.QUALITY_ASSURANCE_JOBS_PATH;
import static constant.OpenPositionsPageConstant.*;


public class OpenPositionsPage extends BasePage {

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
    }

    public OpenPositionsPage openPositions(){
        Assert.assertEquals(ALL_OPEN_POSITIONS_TEXT,getText(ALL_OPEN_POSITIONS_PATH));
//        goBottomOfPage();

        waitToLoad();
        scrollIntoView(FILTER_BY_LOCATION_TITLE_PATH);
        Assert.assertEquals(FILTER_BY_LOCATION_TITLE_TEXT,getText(FILTER_BY_LOCATION_TITLE_PATH));
        click(FILTER_BY_LOCATION_PATH);
        click(SELECT_LOCATION_ISTANBUL);

        waitToLoad();
        Assert.assertEquals(FILTER_BY_DEPARTMENT_TITLE_TEXT,getText(FILTER_BY_DEPARTMENT_TITLE_PATH));
        click(FILTER_BY_DEPARTMENT_PATH);
        click(SELECT_QUALITY_ASSURANCE);
        return this;
    }

    public OpenPositionsPage opportunities(){
        waitToLoad();
        scrollIntoView(BROWSE_JOBS);
        Assert.assertNotNull(findElement(FIRST_JOB_OPPORTUNITY_DEPARTMENT));

        List <WebElement> departments = findElements(JOB_OPPORTUNITIES_DEPARTMENT);
        List <WebElement> locations = findElements(JOB_OPPORTUNITIES_LOCATION);

        for (WebElement dep: departments){
            Assert.assertEquals(DEPARTMENT_TEXT, dep.getText());
        }
        for (WebElement loc: locations){
            Assert.assertEquals(LOCATION_TEXT, loc.getText());
        }

        hoverOn(FIRST_JOB_HOVER_PATH);
        Assert.assertNotNull(findElement(APPLY_NOW));
        click(APPLY_NOW);
        return this;
    }

    public OpenPositionsPage jobDescription(){
        switchWindow();
        Assert.assertEquals(JOB_DESCRIPTION_PAGE_DEPARTMENT_TEXT, getText(JOB_DESCRIPTION_PAGE_DEPARTMENT));
        Assert.assertEquals(JOB_DESCRIPTION_PAGE_LOCATION_TEXT, getText(JOB_DESCRIPTION_PAGE_LOCATION));
        return this;
    }
}
