package com.assignment;

import com.selenium.functionalinterface.DriverFactory;
import com.table.PriceClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MinimumPriceSelect {

    private WebDriver webDriver;

    @BeforeTest
    public void setupBrowser(){
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.getWebDrier("chrome");
    }

    @Test
    public void selectMinimumPriceRow(){
        this.webDriver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
        PriceClass priceClass = new PriceClass();
        priceClass.minimumPriceSelect(this.webDriver);
        System.out.println(priceClass.getStatus(this.webDriver));
    }

    @AfterTest
    public void closeBrowser(){
        this.webDriver.quit();
    }
}
