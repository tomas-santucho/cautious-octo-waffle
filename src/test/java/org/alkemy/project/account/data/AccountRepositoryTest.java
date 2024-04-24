package org.alkemy.project.account.data;

import org.alkemy.project.account.domain.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.alkemy.project.MarketProvider.providesMarket;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {

    private final AccountRepository accountRepository = new AccountRepository();

    @BeforeEach
    void setUp() {
        // Clear the repository to prevent test contamination
        accountRepository.clear();

        // Preload the repository with some accounts
        var account1 = new Account(1L, "Test Account 1", List.of(providesMarket(1L)), BigDecimal.TEN);
        var account2 = new Account(2L, "Test Account 2", List.of(providesMarket(2L)), BigDecimal.TWO);
        accountRepository.save(account1);
        accountRepository.save(account2);
    }

    @Test
    @DisplayName("Save account successfully and verify it exists")
    public void testSaveAccount() {
        // Given
        var account = new Account(3L, "Test Account 3", List.of(providesMarket(3L)), BigDecimal.ZERO);

        // When
        var savedAccount = accountRepository.save(account);

        // Then
        assertNotNull(savedAccount);
        assertEquals(account.getId(), savedAccount.getId());
    }

    @Test
    @DisplayName("WHEN deleteById is called THEN the account should be deleted")
    public void testDeleteById() {
        // When
        var id = 1L;
        accountRepository.deleteById(id);

        // Then
        assertEquals(accountRepository.findById(id), Optional.empty());
    }

    @Test
    @DisplayName("WHEN an account is searched by ID THEN it should find it")
    public void testFindById() {
        // When
        var foundAccount = accountRepository.findById(1L);

        // Then
        assertTrue(foundAccount.isPresent());
        assertEquals(Long.valueOf(1L), foundAccount.get().getId());
    }

    @Test
    @DisplayName("Return all accounts")
    public void testFindAll() {
        // When
        var accounts = accountRepository.findAll();

        // Then
        assertEquals(2, accounts.size());
    }

    @Test
    @DisplayName("WHEN a description is searched THEN it should be found")
    public void testFindByDescription() {
        // Given
        var description = "Test Account 1";

        // When
        var result = accountRepository.findByDescription(description);

        // Then
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("WHEN checking existence of an account THEN return true if exists")
    public void testExists() {
        // Given
        var account = new Account(1L, "Test Account 1", List.of(providesMarket(1L)), BigDecimal.ZERO);

        // When
        var exists = accountRepository.exists(account);

        // Then
        assertTrue(exists);
    }

    @Test
    @DisplayName("WHEN finding any account by predicate THEN return an Optional of account")
    public void testFindAny() {
        // When
        var foundAccount = accountRepository.findAny(acc -> acc.getMarkets().stream()
                .anyMatch(market -> market.getId().equals(2L)));

        // Then
        assertTrue(foundAccount.isPresent());
        assertEquals(Long.valueOf(2L), foundAccount.get().getId());
    }

    @Test
    @DisplayName("WHEN calling getTotalBalance THEN it should return the correct one")
    public void testBalance() {
        // When
        var balance = accountRepository.getTotalBalance();

        // Then
        assertEquals(balance, BigDecimal.valueOf(12));
    }

}