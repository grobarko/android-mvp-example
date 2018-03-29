package com.vlatko.mvp.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StringUtils {

    @Inject
    public StringUtils() {
        // This utility class is not publicly instantiable
    }

    public boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
