package org.alkemy.project.claserest.customer.rest;

import lombok.AllArgsConstructor;
import org.alkemy.project.claserest.customer.CustomerNotFoundException;
import org.alkemy.project.claserest.customer.core.CustomerService;
import org.alkemy.project.claserest.customer.domain.Customer;
import org.alkemy.project.claserest.customer.domain.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/")
    public ResponseEntity<Page<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/status/active")
    public ResponseEntity<Page<Customer>> getAllByStatusActive() {
        return ResponseEntity.ok(service.getAllByStatus(CustomerStatus.ACTIVE));
    }

    @GetMapping("/status/inactive")
    public ResponseEntity<Page<Customer>> getAllByStatusInactive() {
        return ResponseEntity.ok(service.getAllByStatus(CustomerStatus.INACTIVE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.find(id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.save(customer));
    }

    @PutMapping("/")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.save(customer));
    }
}
