package hurtmeplentyhardcore.test;

import hurtmeplentyhardcore.page.CloudGoogleEstimationResultPage;
import hurtmeplentyhardcore.page.CloudGoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CloudGoogleEstimationCalculatorTest {
    private WebDriver driver;
    private static final String VM_CLASS = "VM class: regular";
    private static final String INSTANCE_TYPE = "Instance type: n1-standard-8";
    private static final String ESTIMATE_REGION = "Region: Frankfurt";
    private static final String ESTIMATE_LOCAL_SSD = "Total available local SSD space 2x375 GiB";
    private static final String COMMITMENT_TERM = "Commitment term: 1 Year";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleCloudCalculatorEstimateTest() {
        String vmClass = new CloudGoogleHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricing("Google Cloud Platform Pricing Calculator")
                .redirectToPricingCalculatorPage()
                .createEstimate()
                .getEstimateVMClass();
        String instanceType = new CloudGoogleEstimationResultPage(driver)
                .getEstimateInstanceType();
        String estimateRegion = new CloudGoogleEstimationResultPage(driver)
                .getEstimateRegion();
        String estimateLocalSSD = new CloudGoogleEstimationResultPage(driver)
                .getEstimateAvailableSSD();
        String commitmentTerm = new CloudGoogleEstimationResultPage(driver)
                .getEstimateCommitmentTerm();
        Assert.assertEquals(vmClass, VM_CLASS);
        Assert.assertEquals(instanceType, INSTANCE_TYPE);
        Assert.assertEquals(estimateRegion, ESTIMATE_REGION);
        Assert.assertEquals(estimateLocalSSD, ESTIMATE_LOCAL_SSD);
        Assert.assertEquals(commitmentTerm, COMMITMENT_TERM);
    }

    @Test
    public void googleCloudCalculatorEmailEstimateTest() {
        String estimationCoast = new CloudGoogleHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricing("Google Cloud Platform Pricing Calculator")
                .redirectToPricingCalculatorPage()
                .createEstimate()
                .getEstimateCoast();
        String estimationCoastFromLetter = new CloudGoogleEstimationResultPage(driver)
                .emailEstimate()
                .openTenMinuteMailAndCopyMail()
                .pasteEmailAndSendLetter()
                .getTotalEstimatedMonthlyCostFromLetter();
        Assert.assertTrue(estimationCoast.contains(estimationCoastFromLetter));
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
