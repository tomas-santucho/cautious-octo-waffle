package org.alkemy.project.account.core;

import org.alkemy.project.account.data.AccountRepository;
import org.alkemy.project.account.domain.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(final Account account) {
        return accountRepository.save(account);
    }

    public Account update(final Account account) {
        return accountRepository.save(account);
    }

    public void delete(final Long id) {
        accountRepository.deleteById(id);
    }

    public Optional<Account> get(final Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
