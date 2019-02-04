package com.socks.api.services;

import com.socks.api.AssertableResponse;
import com.socks.api.model.User;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.assertion.CookieMatcher.log;

@Slf4j
public class UserApiService {

    public RequestSpecification setup() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new RequestLoggingFilter(),
                        new AllureRestAssured());
    }

    @Step
    public AssertableResponse registerUser(User user) {
        return new AssertableResponse(setup()
                .body(user)
                .when()
                .post("register")
                .then());
    }
}
