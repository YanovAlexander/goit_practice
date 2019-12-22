package com.goit.practice.http.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goit.practice.http.User;

import java.util.List;

public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T extends User> String writeValueAsString(T value) throws JsonProcessingException {
        return MAPPER.writeValueAsString(value);
    }

    public static <T extends User> List<User> readValue(String body, TypeReference<List<User>> valueType) throws JsonProcessingException {
        return MAPPER.readValue(body, valueType);
    }

    public static <T> T readValue(String body, Class<T> valueType) throws JsonProcessingException {
        return MAPPER.readValue(body, valueType);
    }
}
