package com.jsystems.qa.qagui;

import com.jsystems.qa.qagui.page.LoginPage;
import com.jsystems.qa.qagui.page.MainWordpressPage;
import com.jsystems.qa.qagui.page.UserPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static com.google.common.truth.Truth.assertThat;
import static com.jsystems.qa.qagui.page.LoginPage.*;
import static com.jsystems.qa.qagui.page.MainWordpressPage.loginIconSelector;
import static com.jsystems.qa.qagui.page.UserPage.*;
import static com.jsystems.qa.qagui.page.UserPage.primaryButtonSelector;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("FrontTest")
public class FrontendTest extends ConfigFrontend {

    // clean version

    @Test
    public void frontTest() {
        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
        String text1 = mainWordpressPage.textElement_1.getText();
        assertTrue(text1.equals("WordPress powers"));

        String text2 = mainWordpressPage.textElement_2.getText();
        assertTrue(text2.contains("% of the internet."));
        assertThat(text2).matches("\\d+(% of the internet.)");

    }

    @Test
    public void loginTest() {
        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
        mainWordpressPage.waitForElementToBeVisible(By.cssSelector(loginIconSelector));
        mainWordpressPage.waitForElementToBeClickable(mainWordpressPage.loginIcon);
        mainWordpressPage.loginIcon.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForElementToBeVisible(By.id(usernameOrEmailSelector));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);
        loginPage.waitForElementToBeClickable(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();
        loginPage.waitForElementToBeClickable(By.id(passwordInputSelector));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);
        loginPage.waitForElementToBeClickable(By.cssSelector(primaryButtonSelector));
        loginPage.usernameButton.click();
        UserPage userPage = new UserPage(driver);
        userPage.waitForElementToBeClickable(By.cssSelector(userAvatarSelector));
        userPage.userAvatar.click();
        userPage.waitForElementToBeClickable(By.cssSelector(userDisplayNameSelector));
        String userDisplayNameText = userPage.userDisplayName.getText();
        assertThat(userDisplayNameText).isEqualTo(Configuration.LOGIN);
        userPage.waitForElementToBeVisible(By.cssSelector(UserPage.primaryButtonSelector));

        assertTrue(userPage.saveUserDetailsButton.isDisplayed());
        assertFalse(userPage.saveUserDetailsButton.isEnabled());

    }


    @Test
    public void notificationTest() {

        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginIconSelector)));

        wait.until(ExpectedConditions.elementToBeClickable(mainWordpressPage.loginIcon));
        mainWordpressPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameOrEmailSelector)));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(Configuration.LOGIN);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(passwordInputSelector)));
        loginPage.inputPassword.clear();
        loginPage.inputPassword.sendKeys(Configuration.PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(primaryButtonSelector)));
        loginPage.usernameButton.click();

        UserPage userPage = new UserPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(userAvatarSelector)));
        userPage.userAvatar.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userDisplayNameSelector)));

        userPage.notificationSideLine.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(commentSelector)));
        userPage.commentTopLine.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertTrue(userPage.firstCheckbox.isSelected());

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        userPage.firstCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertFalse(userPage.firstCheckbox.isSelected());
        userPage.firstCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(firstCheckboxSelector)));
        assertTrue(userPage.firstCheckbox.isSelected());

    }

}