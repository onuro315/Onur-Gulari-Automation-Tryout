package constant;

import org.openqa.selenium.By;

public class CareersPageConstant {

    //Locators
    public static final By OUR_LOCATIONS_PATH = By.id("career-our-location");
    public static final By OUR_LOCATIONS_TITLE_PATH = By.xpath("//h3[@class=\"category-title-media ml-0\"]");
    public static final By OUR_LOCATIONS_TEXT_PATH = By.xpath("//div[@class=\"col-12 col-md-6\"]/p");
    public static final By OUR_LOCATIONS_SLIDER = By.id("location-slider");
    public static final By OUR_LOCATIONS_LIST_PATH = By.xpath("//li[contains(@class, 'glide__slide')]");
    public static final By OUR_LOCATIONS_LIST_FIGURE_PATH = By.xpath("//div[contains(@class, 'location-figure')]/img");

    public static final By LIFE_AT_INSIDER_TITLE_PATH = By.xpath("(//div[@class=\"elementor-widget-container\"]/h2)[2]");
    public static final By LIFE_AT_INSIDER_TEXT_PATH = By.xpath("(//div[@class=\"elementor-text-editor elementor-clearfix\"]/p)[4]");
    public static final By LIFE_AT_INSIDER_WRAPPER = By.xpath("(//div[@class=\"swiper-wrapper\"])");

    public static final By SEE_ALL_TEAMS_PATH = By.linkText("See all teams");
    public static final By SEE_ALL_TEAMS_EXTENDED_PATH = By.xpath("//div[contains(@class,\"career-load-more\")]");
    public static final By SEE_ALL_TEAMS_LIST_PATH = By.xpath("//div[contains(@class,\"job-item\")]");
    public static final By SEE_ALL_TEAMS_IMAGES_PATH = By.xpath("//div[contains(@class,\"job-image\")]/a");
    public static final By SEE_ALL_TEAMS_TITLE_PATH = By.xpath("//div[contains(@class,\"job-title\")]/a");
    public static final By SEE_ALL_TEAMS_DESCRIPTION_PATH = By.xpath("//div[contains(@class,\"job-description\")]/p");
    public static final By SEE_ALL_TEAMS_QA_PATH = By.linkText("Quality Assurance");

    public static final By QUALITY_ASSURANCE_TITLE_PATH = By.xpath("//h1[contains(@class,\"big-title\")]");
    public static final By QUALITY_ASSURANCE_DESCRIPTION_PATH = By.xpath("//p[@class=\"text-medium pl-2 pr-2 pl-lg-0 pr-lg-0\"]");
    public static final By QUALITY_ASSURANCE_JOBS_PATH = By.linkText("See all QA jobs");

    //Texts
    public static final String CAREER_PAGE_TITLE = "Insider Careers";

    public static final String OUR_LOCATIONS_TITLE_TEXT = "Our Locations";
    public static final String OUR_LOCATIONS_TEXT = "25 offices across 5 continents, home to 600+ Insiders";

    public static final String LIFE_AT_INSIDER_TITLE_TEXT = "Life at Insider";
    public static final String LIFE_AT_INSIDER_TEXT = "We’re here to grow and drive growth—as none of us did before. Together, we’re building a culture that inspires us to create our life’s work—and creates a bold(er) impact. We know that we’re smarter as a group than we are alone. Become one of us if you dare to play bigger.";

    public static final String QUALITY_ASSURANCE_PAGE_TITLE = "Insider quality assurance job opportunities";
    public static final String QUALITY_ASSURANCE_TITLE = "Quality Assurance";
    public static final String QUALITY_ASSURANCE_TEXT = "Never miss a thing? Obsess over every little detail? Our Q&A team is committed to testing everything we build to ensure it’s flawless for our customers (and theirs).";

    //Size
    public static final Integer OUR_LOCATIONS_LIST_SIZE = 29;
    public static final Integer JOB_COUNT = 15;
}
