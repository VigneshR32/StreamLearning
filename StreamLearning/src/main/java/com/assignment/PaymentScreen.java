package com.assignment;

import com.selenium.functionalinterface.DriverFactory;
import com.table.PaymentClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

public class PaymentScreen {

    private WebDriver webDriver;

    @BeforeTest
    public void setupBrowser(){
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.getWebDrier("chrome");
    }

    @Test(dataProvider = "paymentInfo")
    public void fillPaymentAndVerifyStatus(String payInfo){
        PaymentClass paymentClass = new PaymentClass(this.webDriver);

        paymentClass.fillPaymentDetails(payInfo.split(Pattern.quote("|"))[0].trim(),payInfo.split(Pattern.quote("|"))[1].trim(),payInfo.split(Pattern.quote("|"))[2].trim(),payInfo.split(Pattern.quote("|"))[3].trim());
        Assert.assertEquals(paymentClass.getStatus(),payInfo.split(Pattern.quote("|"))[4].trim());
    }

    @DataProvider(name="paymentInfo")
    public Object[] paymentDetails(){
        return new Object[]{
                "FREEUDEMY||||PASS","PARTIALUDEMY|4111111111111111|2023|123|PASS","PARTIALUDEMY||||FAIL","|4111111111111111|2023|123|PASS",
                "||||FAIL"

        };
    }

    @AfterTest
    public void closeBrowser(){
        this.webDriver.quit();
    }
}
