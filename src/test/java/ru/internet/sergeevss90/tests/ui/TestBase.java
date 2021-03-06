package ru.internet.sergeevss90.tests.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import ru.internet.sergeevss90.helpers.Attach;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;
import ru.internet.sergeevss90.tests.ui.pages.LoginPage;
import ru.internet.sergeevss90.tests.ui.pages.MainPage;
import ru.internet.sergeevss90.tests.ui.pages.ProjectPage;
import ru.internet.sergeevss90.tests.ui.pages.TaskPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;



import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {


    public static String deviceHost = System.getProperty("deviceHost");
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    TaskPage taskPage = new TaskPage();
    ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        BrowserWebDriver.configure();
    }

    @AfterEach
    public void addAttachments() {

        String sessionId;

        switch (deviceHost) {
            case "web":
                sessionId = Attach.sessionId();
                Attach.addBrowserConsoleLogs();
                addAttached();
                if (BrowserWebDriver.isVideoOn()) {
                    Attach.addVideo(sessionId);
                }
                break;
            case "browserstack":
                sessionId = Attach.sessionId();
                addAttached();
                Attach.video(sessionId);
                break;
            default:
                sessionId = "";
                addAttached();
        }
    }

    private void addAttached() {
        Attach.addScreenshotAs("Last screenshot");
        Attach.addPageSource();
        Attach.addBrowserConsoleLogs();
        closeWebDriver();
    }
}