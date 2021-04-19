package com.selenium.functionalinterface;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class TableFactory {

    private Predicate<List<WebElement>> predicateUSA = (s)->s.get(2).getText().equalsIgnoreCase("USA");
    private Predicate<List<WebElement>> predicateAU = (s)->s.get(2).getText().equalsIgnoreCase("AU");
    private Predicate<List<WebElement>> predicateMALE = (s)->s.get(1).getText().equalsIgnoreCase("male");
    private Predicate<List<WebElement>> predicateFEMALE = (s)->s.get(1).getText().equalsIgnoreCase("female");

    private Map<String, Predicate<List<WebElement>>> map= new HashMap<>();

    public TableFactory(){
        this.map.put("USA",predicateUSA);
        this.map.put("AU",predicateAU);
        this.map.put("male",predicateMALE);
        this.map.put("female",predicateFEMALE);
        this.map.put("maleAU",predicateMALE.and(predicateAU));
        this.map.put("femaleAU",predicateFEMALE.and(predicateAU));

    }

    public Predicate<List<WebElement>> getPredicate(String predicateName){
        return this.map.get(predicateName);
    }
  }
