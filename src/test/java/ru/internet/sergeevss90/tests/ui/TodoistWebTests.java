package ru.internet.sergeevss90.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TodoistWebTests extends TestBase {

    @Test
    @DisplayName("UI authorization via e-mail and password")
    void loginTest() {
        step("Insert login credentials", () -> {
            loginPage.doLogin();
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

    @Test
    @DisplayName("Main filters check")
    void checkMainPAgeFiltersTest() {
        step("Insert login credentials", () -> {
            loginPage.doLogin();
        });
        step("Check 'Inbox' filter", () -> {
            mainPage.openFilterInbox()
                    .checkCurrentUrl();
        });
        step("Check 'Today' filter", () -> {
            mainPage.openFilterToday()
                    .checkCurrentUrl();
        });
        step("Check 'Labels' filter", () -> {
            mainPage.openFilterLabels()
                    .checkCurrentUrl();
        });
        step("Check 'Upcoming' filter", () -> {
            mainPage.openFilterUpcoming()
                    .checkFilterUpcoming();
        });
    }

    @Test
    @DisplayName("Check task adding")
    void addNewTaskTest() {
        step("Insert login credentials", () -> {
            loginPage.doLogin();
        });
        step("Open task creation menu", () ->
            taskPage.startTaskCreation());
        step("Add name and description", () -> {
            taskPage.inputTaskName();
            taskPage.inputTaskDescription();
        });
        step("Choose priority", () -> {
            taskPage.openPriorityFlag();
            taskPage.setPriority();
        });
        step("Adding task", () ->
            taskPage.addNewTask());
        step("Checking task creation", () ->
            taskPage.checkTooltip());
    }
}