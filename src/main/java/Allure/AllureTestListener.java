package Allure;

import BrowserFactory.BrowserFactory;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class AllureTestListener implements ITestListener {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info(result.id() + " " + result.getName() + " on Success");
        getScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info(result.id() + " " + result.getName() + " on Fail");
         getScreenshot();
    }


    @Attachment(value="Page screen", type="image/png")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) BrowserFactory.getDriver("Chrome"))
                .getScreenshotAs(OutputType.BYTES);
    }

}
