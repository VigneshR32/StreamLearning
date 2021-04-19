package com.selenium.functionalinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    public DriverFactory(){
        webDriverMap.put("chrome",chromeBrowser);
        webDriverMap.put("ie",chromeBrowser);
        webDriverMap.put("firefox",firefoxBrowser);
    }

    public Supplier<WebDriver> chromeBrowser = ()->{
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    };

    public Supplier<WebDriver> internetBrowser = ()->{
        System.setProperty("webdriver.ie.driver","./driver/IEDriverserver.exe");
        WebDriver webDriver = new InternetExplorerDriver();
        return webDriver;
    };

    public Supplier<WebDriver> firefoxBrowser = ()->{
        System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        return webDriver;
    };

    Map<String, Supplier<WebDriver>> webDriverMap = new HashMap<>();

    public WebDriver getWebDrier(String browser){
        return webDriverMap.get(browser).get();
    }


}
