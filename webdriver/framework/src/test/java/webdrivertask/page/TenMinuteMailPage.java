package webdrivertask.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TenMinuteMailPage {
    private WebDriver driver;
    private static final String TEN_MINUTE_MAIL_URL = "https://temp-mail.org/ru/10minutemail";

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[1]/form/div[2]/button")
    WebElement copyMailButton;

    @FindBy(xpath = "//span[@title='Google Cloud Sales ']")
    WebElement inboxSender;

    @FindBy(xpath = "//*[@id='tm-body']/main/div[1]/div/div[3]/div[2]/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    WebElement estimatedMonthlyCoast;

    public TenMinuteMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleEstimationResultPage openTenMinuteMailAndCopyMail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(chromeTabs.get(1));
        driver.get(TEN_MINUTE_MAIL_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(copyMailButton));
        copyMailButton.click();
        return new CloudGoogleEstimationResultPage(driver);
    }

    public String getTotalEstimatedMonthlyCostFromLetter() {
        ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(chromeTabs.get(1));
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(inboxSender));
        inboxSender.click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(estimatedMonthlyCoast));
        return estimatedMonthlyCoast.getText();
    }
}

