package driver;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static driver.DriverCreation.getDriver;

public class Listener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        byte [] file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(file);

    }
    @Attachment(value = "Screenshots", type = "image")
    private byte[] saveScreenshot (byte [] bytes) {
        return bytes;
    }
}
