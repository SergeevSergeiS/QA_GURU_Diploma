package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.internet.sergeevss90.models.Specs.*;

public class TodoistApiTests extends TestBase {

    @Test
    @Tag("api")
    @DisplayName("Get all projects")
    void getAllProjectsUserTest() {
        given()
                .spec(requestGet)
                .when()
                .get("/projects")
                .then()
                .spec(response200)
                .log().body();
    }
}
