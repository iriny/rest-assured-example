package com.socks.tests.brutal;

import com.socks.api.conditions.Condition;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTestOrganized {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://35.231.186.189";
    }

    private UserApiService userApiService = new UserApiService();

    @Test
    public void userValidRegistration() {
        User user = new User()
                .setFirstName("test")
                .setLastName("test123")
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setEmail("test@mail.com")
                .setPassword("test123");

        // expect
        userApiService
                .registerUser(user)
                .shouldHave(statusCode(200));
    }
}
