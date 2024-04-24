package org.alkemy.project.account.data;

import org.alkemy.project.AlkemyRepository;
import org.alkemy.project.account.domain.Account;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class AccountRepository implements AlkemyRepository<Account> {
    private final static List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(final Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        //TODO add method
    }

    @Override
    public Optional<Account> findById(Long id) {
        //TODO add method
        return Optional.empty();
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public void clear() {
        accounts.clear();
    }

    @Override
    public boolean exists(Account value) {
        //TODO add method
        return false;
    }

    @Override
    public Optional<Account> findAny(Predicate<Account> predicate) {
        //TODO add method
        return Optional.empty();
    }

    public Optional<Account> findByDescription(final String description) {
        //TODO add method
        return Optional.empty();
    }

    public BigDecimal getTotalBalance() {
        //TODO add method
        return BigDecimal.ZERO;
    }
}
