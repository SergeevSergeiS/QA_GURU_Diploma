package ru.internet.sergeevss90.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TodayPage {

    public SelenideElement simpleContentFilter = $(".simple_content");

    public TodayPage checkFilterContent() {
        simpleContentFilter.shouldHave(Condition.exactOwnText("Today"));
        return this;
    }
}
