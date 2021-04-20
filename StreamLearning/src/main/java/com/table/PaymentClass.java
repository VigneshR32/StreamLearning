package com.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;
import java.util.regex.Pattern;

public class PaymentClass {

    private WebDriver webDriver;
    public PaymentClass(WebDriver webDriver){
        this.webDriver=webDriver;
        this.webDriver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
        PageFactory.initElements(this.webDriver,this);
    }

    @FindBy(id="coupon")
    public WebElement promoCode;

    @FindBy(id="couponbtn")
    public WebElement btnApply;

    @FindBy(id = "cc")
    public WebElement creditCard;

    @FindBy(id="year")
    public WebElement year;

    @FindBy(id="cvv")
    public WebElement cvv;
    @FindBy(id="buy")
    public WebElement buy;

    @FindBy(id="status")
    public WebElement status;

    public void fillPaymentDetails(String coupon, String cc, String year, String cvv){
        if(coupon.length()>0)  promoCode.sendKeys(coupon);btnApply.click();
        if(cc.length()>0)
        creditCard.sendKeys(cc);
        if(year.length()>0)
        this.year.sendKeys(year);
        if(cvv.length()>0)
        this.cvv.sendKeys(cvv);
        buy.click();
    }

    public String getStatus(){
        return status.getText().trim();
    }


}
