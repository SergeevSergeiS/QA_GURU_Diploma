package ru.internet.sergeevss90.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static ru.internet.sergeevss90.helpers.AllureRestAssuredCustomListener.withCustomTemplates;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.filters(withCustomTemplates());
    }
}