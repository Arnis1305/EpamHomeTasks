package webdrivertask.test;

import webdrivertask.model.Estimation;
import webdrivertask.page.CloudGoogleEstimationResultPage;
import webdrivertask.page.CloudGoogleHomePage;
import webdrivertask.service.EstimationCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloudGoogleEstimationTest extends CommonConditions {
    @Test
    public void googleCloudCalculatorEstimateTest() {
        Estimation testEstimation = EstimationCreator.withCpuAndGpuFrankfurt();
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
        Assert.assertEquals(vmClass, testEstimation.getVmClass());
        Assert.assertEquals(instanceType, testEstimation.getInstanceType());
        Assert.assertEquals(estimateRegion, testEstimation.getEstimateRegion());
        Assert.assertEquals(estimateLocalSSD, testEstimation.getEstimateLocalSsd());
        Assert.assertEquals(commitmentTerm, testEstimation.getCommitmentTerm());
    }
}
