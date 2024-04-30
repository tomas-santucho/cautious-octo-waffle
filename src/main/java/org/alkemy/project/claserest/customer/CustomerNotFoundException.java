package org.alkemy.project.claserest.customer;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(Long id) {
        super("Id not found. " + id);
    }
}