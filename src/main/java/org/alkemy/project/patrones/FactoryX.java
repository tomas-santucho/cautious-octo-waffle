package org.alkemy.project.patrones;

import java.util.Objects;

public class FactoryX {
    private static FactoryX factoryX;

    private FactoryX() {
        factoryX = new FactoryX();
    }

    public static FactoryX getInstance() {
        return Objects.requireNonNullElseGet(factoryX, FactoryX::new);
    }

    public Alumno createObject(final String name) {
        return new Alumno(name);
    }

}
