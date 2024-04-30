package org.alkemy.project.claserest.customer.data;

import org.alkemy.project.claserest.customer.domain.Customer;
import org.alkemy.project.claserest.customer.domain.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByStatus(CustomerStatus status);


}
