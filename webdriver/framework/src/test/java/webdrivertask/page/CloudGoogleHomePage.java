package webdrivertask.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {
    private static final String CLOUD_GOOGLE_HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    WebElement searchTextArea;

    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(CLOUD_GOOGLE_HOMEPAGE_URL);
        logger.info("Cloud Google home page opened");
        return this;
    }

    public CloudGoogleSearchResultPage searchForGoogleCloudPlatformPricing(String textToSearch) {
        searchTextArea.sendKeys(textToSearch);
        searchTextArea.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']")));
        return new CloudGoogleSearchResultPage(driver);
    }
}
