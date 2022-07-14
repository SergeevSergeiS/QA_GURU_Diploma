package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Param;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.model.Parameter.Mode.MASKED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    public SelenideElement loginButton = $(byText("Log in"));
    public SelenideElement inputUsername = $("#labeled-input-1");
    public SelenideElement inputPassword = $("#labeled-input-3");

    public void doLogin() {
        open("/auth/login");
        inputUsername.setValue(BrowserWebDriver.config.todoistLogin());
        inputPassword.setValue(BrowserWebDriver.config.todoistPassword()).pressEnter();
    }

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