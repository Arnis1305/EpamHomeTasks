package webdrivertask.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdrivertask.model.ComputeEngine;
import webdrivertask.service.ComputeEngineCreator;

import java.util.List;

public class CloudGooglePricingCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstance;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    WebElement machineSeriesDropDownList;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement checkboxAddGpu;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement numberOfGPUDropDownList;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement gpuTypeDropDownList;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[10]/div[1]/md-input-container/md-select")
    WebElement localSSDDropDownList;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[11]/div[1]/md-input-container/md-select")
    WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]/div[1]/md-input-container/md-select")
    WebElement committedUsageDropDownList;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    WebElement addToEstimateButton;

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleEstimationResultPage createEstimate() {
        ComputeEngine computeEngine = ComputeEngineCreator.withCpuGpuAndSsd();
        numberOfInstance.sendKeys(computeEngine.getNumberOfInstances());
        machineSeriesDropDownList.click();
        List<WebElement> machineSeries = driver.findElements(By.xpath("//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getMachineSeries()+ "')]"));
        waitThenClick(driver, machineSeries.get(0));
        machineTypeDropDownList.click();
        List<WebElement> machineType = driver.findElements(By.xpath("//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getMachineType() +"')]"));
        waitThenClick(driver, machineType.get(0));
        waitThenClick(driver, checkboxAddGpu);
        waitThenClick(driver, numberOfGPUDropDownList);
        WebElement numberOfGpu = driver.findElement(By.xpath("//div[@id='select_container_395']//md-content//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getNumberOfGpu() + "')]"));
        waitThenClick(driver, numberOfGpu);
        gpuTypeDropDownList.click();
        WebElement gpuType = driver.findElement(By.xpath("//div[@id='select_container_397']//md-select-menu//md-content//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getGpuType() + "')]"));
        waitThenClick(driver, gpuType);
        localSSDDropDownList.click();
        WebElement localSsd = driver.findElement(By.xpath("//div[@id='select_container_356']//md-select-menu//md-content//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getLocalSsd() + "')]"));
        waitThenClick(driver, localSsd);
        datacenterLocationDropDownList.click();
        WebElement datacenterLocation = driver.findElement(By.xpath("//div[@id='select_container_93']//md-select-menu//md-content//md-option//div[@class='md-text ng-binding'][contains(text(), '" + computeEngine.getDatacenterLocation() + "')]"));
        waitThenClick(driver, datacenterLocation);
        committedUsageDropDownList.click();
        WebElement committedUsage = driver.findElement(By.xpath("//div[@id='select_container_100']//md-select-menu//md-content//md-option//div[@class='md-text'][contains(text(), '" + computeEngine.getCommittedUsage() + "')]"));
        waitThenClick(driver, committedUsage);
        addToEstimateButton.click();
        return new CloudGoogleEstimationResultPage(driver);
    }

    private void  waitThenClick(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}