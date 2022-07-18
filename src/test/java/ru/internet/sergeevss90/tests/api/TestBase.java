package ru.internet.sergeevss90.tests.api;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ru.internet.sergeevss90.config.api.ApiConfig;

import static ru.internet.sergeevss90.helpers.AllureRestAssuredCustomListener.withCustomTemplates;

public class TestBase {
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    static String projectNumber;

    @BeforeAll
    static void setUp() {
        RestAssured.filters(withCustomTemplates());
        projectNumber = config.projectNumber();
    }
}