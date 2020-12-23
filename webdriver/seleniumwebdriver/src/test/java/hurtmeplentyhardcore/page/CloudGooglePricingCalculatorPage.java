package hurtmeplentyhardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloudGooglePricingCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstance;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    WebElement machineSeriesDropDownList;

    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement seriesOptionNOne;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement machineTypeNOneStandardEight;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement checkboxAddGpu;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement numberOfGPUDropDownList;

    @FindBy(xpath = "/html/body/div[5]/md-select-menu/md-content/md-option[2]")
    WebElement numberOfGPUEqualsOne;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement gpuTypeNvidiaTeslaVHundred;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[10]/div[1]/md-input-container/md-select")
    WebElement localSSDDropDownList;

    @FindBy(xpath = "/html/body/div[7]/md-select-menu/md-content/md-option[3]")
    WebElement localSSDAmountTwo;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-select")
    WebElement datacenterLocationDropDownList;

    @FindBys({@FindBy(xpath = "//md-option[@value='europe-west3']")})
    List<WebElement> datacenterLocationFrankfurt;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div[1]/md-input-container/md-select")
    WebElement committedUsageDropDownList;

    @FindBy(xpath = "/html/body/div[9]/md-select-menu/md-content/md-option[2]")
    WebElement committedUsageOneYear;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    WebElement addToEstimateButton;

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleEstimationResultPage createEstimate() {
        numberOfInstance.sendKeys("4");
        machineSeriesDropDownList.click();
        waitThenClick(driver, seriesOptionNOne);
        machineTypeDropDownList.click();
        waitThenClick(driver, machineTypeNOneStandardEight);
        waitThenClick(driver, checkboxAddGpu);
        waitThenClick(driver, numberOfGPUDropDownList);
        waitThenClick(driver, numberOfGPUEqualsOne);
        gpuTypeDropDownList.click();
        waitThenClick(driver, gpuTypeNvidiaTeslaVHundred);
        localSSDDropDownList.click();
        waitThenClick(driver, localSSDAmountTwo);
        datacenterLocationDropDownList.click();
        waitThenClick(driver, datacenterLocationFrankfurt.get(2));
        committedUsageDropDownList.click();
        waitThenClick(driver, committedUsageOneYear);
        addToEstimateButton.click();
        return new CloudGoogleEstimationResultPage(driver);
    }

    private void  waitThenClick(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
