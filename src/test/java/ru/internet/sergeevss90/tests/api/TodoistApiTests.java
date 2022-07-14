package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;
import static ru.internet.sergeevss90.models.Specs.requestGet;
import static ru.internet.sergeevss90.models.Specs.response200;

public class TodoistApiTests {

    /*@Test
    @DisplayName("Получить все проекты пользователя")
    void getAllProjectsUserTest() {
        given()
                .contentType()
                .body()
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode()
    }*/
}
