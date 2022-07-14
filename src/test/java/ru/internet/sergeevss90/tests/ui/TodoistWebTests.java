package ru.internet.sergeevss90.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TodoistWebTests extends TestBase {

    @Test
    @DisplayName("UI authorization via e-mail and password")
    void loginTest() {
        step("Insert login credentials", () -> {
            loginPage.doLogin(user, pass);
        });
        step("Check page content", () -> {
            mainPage.checkFilterContent()
                     .checkCurrentUrl();
        });
    }

    @Test
    @DisplayName("Redirect of unauthorized user to login page")
    void redirectTest() {
        step("Open 'Today' page without authorization", () ->
                mainPage.openPage());
        step("Check redirection", () -> {
            mainPage.checkFilterAvailability();
            loginPage.checkLoginButton()
                     .checkCurrentUrl();
        });
    }


}