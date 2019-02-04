package com.socks.api.conditions;

public class Conditions {

    public StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }
}
