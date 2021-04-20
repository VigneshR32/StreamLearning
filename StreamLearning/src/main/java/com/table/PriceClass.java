package com.table;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Comparator;

public class PriceClass {

    public void minimumPriceSelect(WebDriver webDriver){
        webDriver.findElements(By.xpath("//table[@id='prods']//tr")).stream()
                .skip(1)
                .map(e->e.findElements(By.tagName("td")))
                .min(Comparator.comparing(t->Integer.parseInt(t.get(2).getText())))
                .get().get(3).findElement(By.tagName("input")).click();
        webDriver.findElement(By.id("result")).click();
    }

    public String getStatus(WebDriver webDriver){
        return webDriver.findElement(By.id("status")).getText();
    }
}
