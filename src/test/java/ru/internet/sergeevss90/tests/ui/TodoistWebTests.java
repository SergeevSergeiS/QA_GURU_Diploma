package ru.internet.sergeevss90.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.tests.ui.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class TodoistWebTests extends TestBase {

    @Test
    @DisplayName("Inserting login credentials")
    void loginTest() {
        step("Authorisation", MainPage::login);
    }
}
