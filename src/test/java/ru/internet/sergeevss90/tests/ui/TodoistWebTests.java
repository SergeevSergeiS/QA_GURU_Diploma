package ru.internet.sergeevss90.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("web")
public class TodoistWebTests extends TestBase {

    @Test
    @DisplayName("UI authorization via e-mail and password")
    void loginTest() {
        step("Authorize", () ->
            loginPage.doLogin());
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
    @DisplayName("Main filters availability")
    void checkMainPAgeFiltersTest() {
        step("Authorize", () ->
                loginPage.doLogin());
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
    @DisplayName("Task adding process")
    void addNewTaskTest() {
        step("Authorize", () ->
                loginPage.doLogin());
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
        step("Finish task creation", () ->
            taskPage.addNewTask());
        step("Check result", () ->
            taskPage.checkTooltip());
    }

    @Test
    @DisplayName("Project adding process")
    void createProjectTest() {
        step("Authorize", () ->
                loginPage.doLogin());
        step("Open project creation menu", () ->
                projectPage.startProjectCreation());
        step("Add project name", () ->
                projectPage.inputProjectName());
        step("Finish project creation", () ->
                projectPage.addNewProject());
        step("Check result", () ->
                projectPage.checkProjectCreation());
    }

    @Test
    @DisplayName("'Upcoming' filter shows today's date")
    void nowDateFilterUpcomingTest() {
        step("Authorize", () ->
                loginPage.doLogin());
        step("Open upcoming filter", () ->
                mainPage.openFilterUpcoming());
        step("Check displayed date", () ->
                mainPage.checkUpcomingDate());
    }
}