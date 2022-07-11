package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public static SelenideElement inputUsername = $("#labeled-input-1");
    public static SelenideElement inputPassword = $("#labeled-input-3");

    public static void login() {
        open("/auth/login");
        System.out.println(BrowserWebDriver.config.todoistLogin());
        System.out.println(BrowserWebDriver.config.todoistPassword());
        inputUsername.setValue(BrowserWebDriver.config.todoistLogin());
        inputPassword.setValue(BrowserWebDriver.config.todoistPassword()).pressEnter();
    }
}
