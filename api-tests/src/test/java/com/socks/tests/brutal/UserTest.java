package com.socks.tests.brutal;

import com.socks.api.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class UserTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://35.231.186.189";
    }

    @Test
    public void userValidRegistration() {
        User user = new User()
                .setFirstName("")
                .setLastName("test123")
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setEmail("test@mail.com")
                .setPassword("test123");

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }
}
