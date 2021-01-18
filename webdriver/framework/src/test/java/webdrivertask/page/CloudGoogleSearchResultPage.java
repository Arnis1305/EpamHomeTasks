package webdrivertask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement linkToPricingCalculator;

    public CloudGoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGooglePricingCalculatorPage redirectToPricingCalculatorPage() {
        linkToPricingCalculator.click();
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']")));
        return new CloudGooglePricingCalculatorPage(driver);
    }
}
