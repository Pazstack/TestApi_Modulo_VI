import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void validarUsuarioPorId() {
        RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .when()
            .get("/users/1")
            .then()
            .statusCode(200)
            .body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void crearUsuarioSimulado() {
        RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-Type", "application/json")
            .body("{\"name\": \"Paz\", \"email\": \"paz@example.com\"}")
            .when()
            .post("/users")
            .then()
            .statusCode(201);
    }

    @Test
    public void eliminarUsuarioSimulado() {
        RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .when()
            .delete("/users/1")
            .then()
            .statusCode(200);
    }
}
