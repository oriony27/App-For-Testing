package com.app.testing.utils;

import com.google.gson.Gson;

public final class GsonUtils {
    private static Gson gson = new Gson();

    private GsonUtils() {
        throw new IllegalStateException("This is utility class!");
    }

    public static <T> String toJson(T object) {
        return gson.toJson(object);
    }
}
