package com.m77can.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonUtil {
    static final ObjectMapper COMMON_OBJECT_MAPPER;

    static {
        COMMON_OBJECT_MAPPER = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    }

    public static <T> T parse(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return COMMON_OBJECT_MAPPER.readValue(jsonString, clazz);
    }

    public static <T> T parse(String jsonString, TypeReference<T> typeReference) throws JsonProcessingException {
        return COMMON_OBJECT_MAPPER.readValue(jsonString, typeReference);

    }

    public static String toString(Object object) throws JsonProcessingException {
        return COMMON_OBJECT_MAPPER.writeValueAsString(object);
    }

    public static JsonNode getJsonNode(String jsonString) throws JsonProcessingException {
        return COMMON_OBJECT_MAPPER.readTree(jsonString);
    }

}


