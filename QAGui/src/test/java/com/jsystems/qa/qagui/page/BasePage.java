package com.jsystems.qa.qagui.page;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
