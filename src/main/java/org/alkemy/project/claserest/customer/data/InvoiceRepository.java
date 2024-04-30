package org.alkemy.project.claserest.customer.data;

import org.alkemy.project.claserest.customer.domain.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Page<Invoice> findByCustomerId(Long id);
}
