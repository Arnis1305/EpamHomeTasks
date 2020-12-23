package hurtmeplentyhardcore.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CloudGoogleEstimationResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[2]/div")
    WebElement estimateVMClass;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]/div")
    WebElement estimateInstanceType;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[4]/div")
    WebElement estimateRegion;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[5]/div")
    WebElement estimateAvailableSSD;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[6]/div")
    WebElement estimateCommitmentTerm;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/h2/b")
    WebElement estimateCoast;

    @FindBy(xpath = "//*[@id='email_quote']")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement emailEstimateInput;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    WebElement sendEmailButton;

    public CloudGoogleEstimationResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage emailEstimate() {
        emailEstimateButton.click();
        return new TenMinuteMailPage(driver);
    }

    public TenMinuteMailPage pasteEmailAndSendLetter() {
        ArrayList<String> chromeTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(chromeTabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailEstimateInput));
        emailEstimateInput.click();
        emailEstimateInput.sendKeys(Keys.CONTROL + "v");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        return new TenMinuteMailPage(driver);
    }

    public String getEstimateVMClass() {
        return estimateVMClass.getText();
    }

    public String getEstimateInstanceType() {
        return estimateInstanceType.getText();
    }

    public String getEstimateRegion() {
        return estimateRegion.getText();
    }

    public String getEstimateAvailableSSD() {
        return estimateAvailableSSD.getText();
    }

    public String getEstimateCommitmentTerm() {
        return estimateCommitmentTerm.getText();
    }

    public String getEstimateCoast() {
        return estimateCoast.getText();
    }
}
