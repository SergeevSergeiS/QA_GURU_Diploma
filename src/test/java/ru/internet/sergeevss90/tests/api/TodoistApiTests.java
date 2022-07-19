package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.models.Credentials;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ru.internet.sergeevss90.models.Specs.*;

@Tag("api")
public class TodoistApiTests extends TestBase {

   @Test
    @DisplayName("Get all user's projects")
    void getAllProjectsTest() {
        given()
                .spec(getRequest)
                .when()
                .get("/projects")
                .then()
                .spec(response200)
                .log().body();
    }

    @Test
    @DisplayName("Get one user's project")
    void getSingleProjectTest() {
        given()
                .spec(getRequest)
                .when()
                .get("/projects/" + projectNumber)
                .then()
                .spec(response200)
                .log().body();
    }

    @Test
    @DisplayName("Adding a new project")
    void createNewProjectTest() {
        Credentials credentials = new Credentials();
        credentials.setName(projectName);
        given()
                .spec(creationRequest)
                .body(credentials)
                .when()
                .post("/projects")
                .then()
                .spec(response200)
                .log().body()
                .body("name", is(projectName));
    }

    @Test
    @DisplayName("Updating project")
    public void updateProjectTest() {
        Credentials oldCredentials = new Credentials();
        oldCredentials.setName(outdatedTaskName);
        long id =
                given()
                        .spec(creationRequest)
                        .body(oldCredentials)
                        .when()
                        .post("/projects")
                        .then()
                        .spec(response200)
                        .log().body()
                        .body("name", is(outdatedTaskName))
                        .extract().jsonPath().getLong("id");
        Credentials newCredentials = new Credentials();
        newCredentials.setName(updatedTaskName);
        newCredentials.setId(id);

        given()
                .spec(creationRequest)
                .body(newCredentials)
                .when()
                .post("/projects/" + id)
                .then()
                .log().body()
                .spec(response204)
                .body("name", is(updatedTaskName));
    }

    @Test
    @DisplayName("Adding a new task")
    void createNewTaskTest() {
        Credentials credentials = new Credentials();
        credentials.setContent(taskName);
        credentials.setProjectId(projectNumber);

        given()
                .spec(creationRequest)
                .body(credentials)
                .when()
                .post("/tasks")
                .then()
                .spec(response200)
                .log().body()
                .body("content", is(taskName));
    }
}