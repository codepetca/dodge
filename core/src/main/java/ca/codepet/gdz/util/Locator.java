package ca.codepet.gdz.util;

import java.util.HashMap;
import java.util.Map;

public class Locator {
    private static final Map<Class<?>, Object> services = new HashMap<>();

    public static <T> void register(Class<T> type, T service) {
        services.put(type, service);
    }

    public static <T> T get(Class<T> type) {
        return type.cast(services.get(type));
    }

}
