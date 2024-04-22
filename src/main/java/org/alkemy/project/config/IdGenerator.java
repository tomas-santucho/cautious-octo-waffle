package org.alkemy.project.config;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    public static long generateId() {
        return ThreadLocalRandom.current().nextLong();
    }
}
