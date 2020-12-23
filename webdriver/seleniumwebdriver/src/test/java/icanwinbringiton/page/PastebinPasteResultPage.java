package icanwinbringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPasteResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea[@class='textarea']")
    WebElement resultOfPaste;

    @FindBy(xpath = "//h1")
    WebElement pastebinPageTitle;

    @FindBy(xpath = "//a[@class='btn -small h_800']")
    WebElement codeHighlightingType;

    public PastebinPasteResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOutputCodeFromPaste() {
        return resultOfPaste.getText();
    }

    public String getPageTitle() {
        return pastebinPageTitle.getText();
    }

    public String getCodeHighlightingType() {
        return codeHighlightingType.getText();
    }
}
