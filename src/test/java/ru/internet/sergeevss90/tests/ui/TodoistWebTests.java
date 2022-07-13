package ru.internet.sergeevss90.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.tests.ui.pages.MainPage;
import ru.internet.sergeevss90.tests.ui.pages.TodayPage;

import static io.qameta.allure.Allure.step;

public class TodoistWebTests extends TestBase {

    @Test
    @DisplayName("UI authorization via e-mail and password")
    void loginTest() {
        step("Insert login credentials", MainPage::login);
        step("Check page content", () -> {
            todayPage.checkFilterContent()
                     .checkCurrentUrl();
        });
    }

    @Test
    @DisplayName("Re-direct to login page without authorization")
    void redirectTest() {
        step("Open 'Today' page without authorization", () ->
                todayPage.openPage());
        step("Check redirection", () -> {
            todayPage.checkFilterAvailability();
            loginPage.checkCurrentUrl();
        });
    }
}