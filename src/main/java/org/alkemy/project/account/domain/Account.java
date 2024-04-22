package org.alkemy.project.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Account {
    @Id
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "accounts")
    private List<Market> markets;

    public Account() {
    }

    public Account(Long id, String description, List<Market> markets) {
        this.id = id;
        this.description = description;
        this.markets = markets;
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
}