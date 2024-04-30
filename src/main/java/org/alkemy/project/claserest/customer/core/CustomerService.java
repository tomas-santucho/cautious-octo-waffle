package org.alkemy.project.claserest.customer.core;

import lombok.AllArgsConstructor;
import org.alkemy.project.claserest.customer.CustomerNotFoundException;
import org.alkemy.project.claserest.customer.data.CustomerRepository;
import org.alkemy.project.claserest.customer.domain.Customer;
import org.alkemy.project.claserest.customer.domain.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;


    public Page<Customer> getAll() {
        return repository.findAll(PageRequest.of(0, 10));
    }

    public Customer find(Long id) throws CustomerNotFoundException {
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Page<Customer> getAllByStatus(CustomerStatus status) {
        return repository.findByStatus(status);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }
}
