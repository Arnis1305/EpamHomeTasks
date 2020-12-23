package icanwinbringiton.test;

import icanwinbringiton.page.PastebinHomePage;
import icanwinbringiton.page.PastebinPasteResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {
    private WebDriver driver;
    private static final String CODE_TO_PASTE = "Hello from WebDriver";
    private static final String PAGE_TITLE_BASH_CODE = "how to gain dominance among developers";
    private static final String BASH_CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                            "git push origin master --force";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createPasteWithCodeExpirationAndTitleTest() {
        String resultOfPaste = new PastebinHomePage(driver)
                .openPage()
                .createPasteWithPasteExpirationTenMinutes(CODE_TO_PASTE, "helloweb")
                .getOutputCodeFromPaste();
        Assert.assertEquals(resultOfPaste, CODE_TO_PASTE);
    }

    @Test
    public void createPasteWithSyntaxHighlightingPasteExpirationAndTitleTest() {
        String resultOfPaste = new PastebinHomePage(driver)
                .openPage()
                .createPasteWithSyntaxHighlighting(BASH_CODE, PAGE_TITLE_BASH_CODE)
                .getOutputCodeFromPaste();
        String pastebinPageTitle = new PastebinPasteResultPage(driver)
                .getPageTitle();
        String codeHighlightingType = new PastebinPasteResultPage(driver)
                .getCodeHighlightingType();
        Assert.assertEquals(resultOfPaste, BASH_CODE);
        Assert.assertEquals(pastebinPageTitle, PAGE_TITLE_BASH_CODE);
        Assert.assertEquals(codeHighlightingType, "Bash");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
