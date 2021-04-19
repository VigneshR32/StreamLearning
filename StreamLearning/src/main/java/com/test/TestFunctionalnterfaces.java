package com.test;

import com.selenium.functionalinterface.DriverFactory;
import com.selenium.functionalinterface.TableFactory;
import com.table.TableClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class TestFunctionalnterfaces {

    public WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(@Optional("chrome")String browser){
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.getWebDrier(browser);

    }

    @Test(dataProvider = "predicateprovider")
    public void openGoogle(Predicate<List<WebElement>> predicate){
        this.webDriver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
//        List<WebElement> webElementList = this.webDriver.findElements(By.tagName("a"));
//        Predicate<WebElement> predicateFilters = (e)->e.getText().trim().contains("s");
//        Predicate<WebElement> predicate = (e)->e.getText().trim().length()==0;
//        webElementList.removeIf(predicate);
//        webElementList.removeIf(predicateFilters);
//        webElementList.forEach(e->System.out.println(e.getText()));
//        this.webDriver.findElements(By.tagName("a")).stream().filter(e->e.getText().trim().length()>0 && !e.getText().toLowerCase().contains("s"))
//                .map(e->e.getText().toUpperCase())
//                .forEach(System.out::println);
        TableClass tableClass = new TableClass(this.webDriver);
        tableClass.clickCheckBox(predicate);
    }

    @DataProvider(name = "predicateprovider")
    public Object[] dataProvider(){
        TableFactory tableFactory = new TableFactory();
        return new Object[]{
                tableFactory.getPredicate("AU"),
                tableFactory.getPredicate("USA"),
                tableFactory.getPredicate("male"),
                tableFactory.getPredicate("female"),
                tableFactory.getPredicate("maleAU"),
                tableFactory.getPredicate("femaleAU")
        };
    }


    @AfterTest
    public void endTest(){
        this.webDriver.quit();
    }
}
