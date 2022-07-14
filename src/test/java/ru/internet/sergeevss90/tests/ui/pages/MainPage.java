package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ru.internet.sergeevss90.drivers.web.BrowserWebDriver;
import ru.internet.sergeevss90.helpers.Attach;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    public SelenideElement simpleContentFilter = $(".simple_content");

    public MainPage checkFilterContent() {
        simpleContentFilter.shouldHave(Condition.exactOwnText("Today"));
        return this;
    }

    public MainPage checkCurrentUrl() {
        String pageType = simpleContentFilter.getOwnText();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url;
        switch (pageType) {
            case "Inbox":
                url = "https://todoist.com/app/project/2294649070";
                assertEquals(url, currentUrl);
                break;
            case "Today":
                url = "https://todoist.com/app/today";
                assertEquals(url, currentUrl);
                break;
            case "Filters & Labels":
                url = "https://todoist.com/app/filters-labels";
                assertEquals(url, currentUrl);
                break;
            default:
                assertEquals("", currentUrl);
        }
        return this;
    }
    public MainPage openPage() {
        open("app/today");
        return this;
    }

    public MainPage checkFilterAvailability() {
        simpleContentFilter.shouldNotBe(Condition.visible);
        return this;
    }
}
