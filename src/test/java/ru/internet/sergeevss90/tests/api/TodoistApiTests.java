package ru.internet.sergeevss90.tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.internet.sergeevss90.models.CreateCredentials;
import ru.internet.sergeevss90.models.UpdateCredentials;

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
        CreateCredentials createCredentials = new CreateCredentials();
        createCredentials.setName(projectName);
        given()
                .spec(creationRequest)
                .body(createCredentials)
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
        UpdateCredentials oldCreateCredentials = new UpdateCredentials();
        oldCreateCredentials.setName(outdatedTaskName);
        long id =
                given()
                        .spec(creationRequest)
                        .body(oldCreateCredentials)
                        .when()
                        .post("/projects")
                        .then()
                        .spec(response200)
                        .log().body()
                        .body("name", is(outdatedTaskName))
                        .extract().jsonPath().getLong("id");
        UpdateCredentials newCreateCredentials = new UpdateCredentials();
        newCreateCredentials.setName(updatedTaskName);
        newCreateCredentials.setId(id);

        given()
                .spec(creationRequest)
                .body(newCreateCredentials)
                .when()
                .post("/projects/" + id)
                .then()
                .log().body()
                .spec(response204);
    }

    @Test
    @DisplayName("Adding a new task")
    void createNewTaskTest() {
        CreateCredentials createCredentials = new CreateCredentials();
        createCredentials.setContent(taskName);
        createCredentials.setProjectId(projectNumber);

        given()
                .spec(creationRequest)
                .body(createCredentials)
                .when()
                .post("/tasks")
                .then()
                .spec(response200)
                .log().body()
                .body("content", is(taskName));
    }
}