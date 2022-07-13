package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodayPage {

    public SelenideElement simpleContentFilter = $(".simple_content");

    public TodayPage checkFilterContent() {
        simpleContentFilter.shouldHave(Condition.exactOwnText("Today"));
        return this;
    }

    public TodayPage checkCurrentUrl() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String url = "https://todoist.com/app/today";
        assertEquals(url, currentUrl);
        return this;
    }
    public TodayPage openPage() {
        open("app/today");
        return this;
    }

    public TodayPage checkFilterAvailability() {
        simpleContentFilter.shouldNotBe(Condition.visible);
        return this;
    }
}
