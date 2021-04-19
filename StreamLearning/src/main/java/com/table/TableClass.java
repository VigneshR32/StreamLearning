package com.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class TableClass {
    private WebDriver webDriver;
    public TableClass(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void clickCheckBox(Predicate<List<WebElement>> predicate){
        this.webDriver.findElements(By.tagName("tr")).stream().skip(1)
                .map(e->e.findElements(By.tagName("td")))
//                .filter(f->f.get(1).getText().equalsIgnoreCase("male"))
                .filter(predicate)
                .map(g->g.get(3))
                .map(h->h.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }
}
