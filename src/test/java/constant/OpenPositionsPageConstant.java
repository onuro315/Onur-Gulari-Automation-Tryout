package constant;

import org.openqa.selenium.By;

public class OpenPositionsPageConstant {

    //Locators

    public static final By ALL_OPEN_POSITIONS_PATH = By.xpath("//div[@class=\"col-12 text-center\"]/h3");
    public static final By FILTER_BY_LOCATION_TITLE_PATH = By.xpath("//label[@for=\"filter-by-location\"]");
    public static final By FILTER_BY_LOCATION_PATH = By.xpath("(//span[@id=\"select2-filter-by-location-container\"])");
    public static final By SELECT_LOCATION_ISTANBUL = By.xpath("//ul[@role=\"listbox\"]/li[contains(@data-select2-id, 'Istanbul, Turkey')]");

    public static final By FILTER_BY_DEPARTMENT_TITLE_PATH = By.xpath("//label[@for=\"filter-by-department\"]");
    public static final By FILTER_BY_DEPARTMENT_PATH = By.xpath("//span[@id=\"select2-filter-by-department-container\"]");
    public static final By SELECT_QUALITY_ASSURANCE = By.xpath("//ul[@role=\"listbox\"]/li[contains(@data-select2-id, 'Quality Assurance')]");

    public static final By BROWSE_JOBS = By.xpath("(//h3[@class=\"mb-0\"])");
    public static final By FIRST_JOB_OPPORTUNITY_DEPARTMENT = By.xpath("//span[contains(@class,\"position-department\")][1]");
    public static final By FIRST_JOB_HOVER_PATH = By.xpath("(//div[@class=\"position-list-item-wrapper bg-light\"])[1]");
    public static final By APPLY_NOW = By.xpath("(//a[@class=\"btn btn-navy rounded pt-2 pr-5 pb-2 pl-5\"])[1]");

    public static final By JOB_OPPORTUNITIES_DEPARTMENT = By.xpath("//span[contains(@class,\"position-department\")]");
    public static final By JOB_OPPORTUNITIES_LOCATION = By.xpath("//div[contains(@class,\"position-location\")]");

    public static final By JOB_DESCRIPTION_PAGE_LOCATION = By.xpath("//div[contains(@class,\"medium-category-label\")][1]");
    public static final By JOB_DESCRIPTION_PAGE_DEPARTMENT = By.xpath("//div[contains(@class,\"medium-category-label\")][2]");


    //Texts

    public static final String ALL_OPEN_POSITIONS_TEXT = "All open positions";
    public static final String FILTER_BY_LOCATION_TITLE_TEXT = "Filter by Location";
    public static final String FILTER_BY_DEPARTMENT_TITLE_TEXT = "Filter by Department";

    public static final String DEPARTMENT_TEXT = "Quality Assurance";
    public static final String LOCATION_TEXT = "Istanbul, Turkey";

    public static final String JOB_DESCRIPTION_PAGE_DEPARTMENT_TEXT = "QUALITY ASSURANCE /";
    public static final String JOB_DESCRIPTION_PAGE_LOCATION_TEXT = "ISTANBUL, TURKEY /";
    //Sizes

}
