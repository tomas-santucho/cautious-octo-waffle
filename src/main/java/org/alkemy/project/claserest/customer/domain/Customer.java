package org.alkemy.project.claserest.customer.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    private Long id;
    private String name;
    private String surname;
    private CustomerStatus status;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoice;
}
