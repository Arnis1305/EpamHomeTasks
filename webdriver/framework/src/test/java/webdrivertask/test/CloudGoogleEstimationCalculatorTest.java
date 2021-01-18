package webdrivertask.test;

import webdrivertask.page.CloudGoogleEstimationResultPage;
import webdrivertask.page.CloudGoogleHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloudGoogleEstimationCalculatorTest extends CommonConditions {
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
}

