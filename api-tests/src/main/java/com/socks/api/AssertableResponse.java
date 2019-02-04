package com.socks.api;

import com.socks.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {

    private final ValidatableResponse response;

    @Step("api response should have {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        log.info("check for " +  condition);
        condition.check(response);
        return this;
    }

}
