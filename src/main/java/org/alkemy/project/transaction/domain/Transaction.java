package org.alkemy.project.transaction.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.alkemy.project.account.domain.Account;
import org.alkemy.project.account.domain.Market;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;

    private BigDecimal amount;


    private LocalDateTime date;

    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "marketId", referencedColumnName = "id")
    private Market market;


    // Constructors
    public Transaction() {
    }

    public Transaction(Long transactionId, Account account, BigDecimal amount,
                       LocalDateTime date, TransactionType transactionType, Market market) {
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
        this.market = market;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}