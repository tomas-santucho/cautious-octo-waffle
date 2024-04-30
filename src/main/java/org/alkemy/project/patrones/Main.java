package org.alkemy.project.patrones;

public class Main {
    public static void main(String[] args) {
        var factory = FactoryX.getInstance();


        var factory2 = FactoryX.getInstance();

        var alumno = factory2.createObject("Juan");
    }
}
