package icanwinbringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement codeInputTextArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pastExpirationDropDownList;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinutesExpiration;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement pastTitle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonCreatePaste;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropDownList;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashSyntaxHighlighting;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinPasteResultPage createPasteWithPasteExpirationTenMinutes(String codeToPaste, String pasteName) {
        codeInputTextArea.sendKeys(codeToPaste);
        pastExpirationDropDownList.click();
        tenMinutesExpiration.click();
        pastTitle.sendKeys(pasteName);
        buttonCreatePaste.click();
        waitForElementLocatedBy(driver, By.xpath("//div[@class='de1']"));
        return new PastebinPasteResultPage(driver);
    }

    public PastebinPasteResultPage createPasteWithSyntaxHighlighting(String codeToPaste, String pastName) {
        codeInputTextArea.sendKeys(codeToPaste);
        syntaxHighlightingDropDownList.click();
        bashSyntaxHighlighting.click();
        pastExpirationDropDownList.click();
        tenMinutesExpiration.click();
        pastTitle.sendKeys(pastName);
        buttonCreatePaste.click();
        waitForElementLocatedBy(driver, By.xpath("//div[@class='de1']"));
        return new PastebinPasteResultPage(driver);
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
