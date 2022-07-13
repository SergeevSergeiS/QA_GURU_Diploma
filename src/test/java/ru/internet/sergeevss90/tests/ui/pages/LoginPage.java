package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public SelenideElement loginButton = $(byText("Log in"));

    public LoginPage checkCurrentUrl() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url = "https://todoist.com/auth/login?success_page=%2Fapp%2Ftoday";
        assertEquals(url, currentUrl);
        return this;
    }

    public LoginPage checkLoginButton() {
        loginButton.shouldBe(Condition.visible);
        return this;
    }
}
