package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {

    @Test
    void shouldPostData() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("test data#1") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
               .statusCode(200)
                .body("data",equalTo("test data#2"))
        .header("Content-Type", "application/json; charset=utf-8")
        ;
    }
}
