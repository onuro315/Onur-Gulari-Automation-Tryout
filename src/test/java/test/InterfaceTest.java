package test;

import base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.OpenPositionsPage;

public class InterfaceTest extends Base {

    HomePage homePage;
    CareersPage careersPage;
    OpenPositionsPage openPositionsPage;

    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage(getWebDriver());
        careersPage = new CareersPage(getWebDriver());
        openPositionsPage = new OpenPositionsPage(getWebDriver());
    }

    @Test
    public void startTest(){
        homePage.insiderHomePage();
        careersPage.careers()
                .ourLocations()
                .lifeAtInsider()
                .teams()
                .qualityAssurance();
        openPositionsPage.openPositions()
                .opportunities()
                .jobDescription();
    }
}
