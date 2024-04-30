package org.alkemy.project.claserest.customer.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Invoice {
    @Id
    private Long id;
    private LocalDateTime localDateTime;

    private InvoiceStatus invoiceStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
