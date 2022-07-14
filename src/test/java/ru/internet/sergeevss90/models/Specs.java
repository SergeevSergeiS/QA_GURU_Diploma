package ru.internet.sergeevss90.models;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    static String token = "307ababb64863f3c4b166a569e421c2be8c3af71";
    static String baseUrl = "https://api.todoist.com/rest/v1";

    public static RequestSpecification requestGet = with()
            .header("Authorization", "Bearer " + token)
            .baseUri(baseUrl);

    public static ResponseSpecification response200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}