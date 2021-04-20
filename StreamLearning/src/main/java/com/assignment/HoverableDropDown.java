package com.assignment;

import com.selenium.functionalinterface.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class HoverableDropDown {
    private WebDriver webDriver;
    private Actions actions;

    @BeforeTest
    public void setupBrowser(){
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.getWebDrier("chrome");
        this.actions=new Actions(webDriver);
    }

    @Test(dataProvider = "linkProvider")
    public void selectMinimumPriceRow(String path){
        this.webDriver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        Arrays.stream(path.split(Pattern.quote("|")))
                .map(s->By.linkText(s))
                .map(s->webDriver.findElement(s))
                .map(s->this.actions.moveToElement(s))
                .forEach(s->s.perform());
    }


    @DataProvider(name="linkProvider")
    public Object[] testData(){
        Object[] objects = {
                "Dropdown|Dropdown Link 2", "Dropdown|Dropdown Link 4","Dropdown|Dropdown Link 5|Dropdown Submenu Link 5.4|Dropdown Submenu Link 5.4.2"
        };
        return objects;
    }



    @AfterTest
    public void closeBrowser(){
        this.webDriver.quit();
    }

}
