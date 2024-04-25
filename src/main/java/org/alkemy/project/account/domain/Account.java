package org.alkemy.project.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.alkemy.project.transaction.domain.Transaction;

import java.util.List;

@Entity
public class Account {
    @Id
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "accounts")
    private List<Market> markets;


    @OneToMany(mappedBy = "account") // Establish one-to-many relationship
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(Long id, String description, List<Market> markets, List<Transaction> transactions) {
        this.id = id;
        this.description = description;
        this.markets = markets;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}