package com.jsystems.qa.qagui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, 30);
    }
    public void waitForElementToBeClickable(By by, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementToBeClickable(By by) {
        waitForElementToBeClickable(by, 30);
    }
    public void waitForElementToBeClickable(WebElement element, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementToBeClickable(WebElement element) {
        waitForElementToBeClickable(element, 30);
    }
    public void waitForElementToBeVisible(By by, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementToBeVisible(WebElement element, int time) {
        wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeVisible(WebElement element) {
        waitForElementToBeVisible(element, 30);
    }
    public void waitForElementToBeVisible(By by) {
        waitForElementToBeVisible(by, 30);
    }
}
