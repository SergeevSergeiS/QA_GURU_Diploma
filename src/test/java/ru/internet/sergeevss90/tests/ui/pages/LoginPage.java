package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.WebDriverRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    public LoginPage checkCurrentUrl() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url = "https://todoist.com/auth/login";
        assertEquals(url, currentUrl);
        return this;
    }
}
