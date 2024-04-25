package org.alkemy.project.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.alkemy.project.account.domain.Account;
import org.alkemy.project.account.domain.Country;
import org.alkemy.project.account.domain.Market;
import org.alkemy.project.transaction.domain.Transaction;
import org.alkemy.project.transaction.domain.TransactionType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabaseLoader implements CommandLineRunner {


    @PersistenceContext
    private EntityManager entityManager;

    public DatabaseLoader(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (isDatabaseEmpty()) {
            loadDemoData();
        }
    }

    private boolean isDatabaseEmpty() {
        return ((Long) entityManager.createQuery("SELECT COUNT(a) FROM Account a").getSingleResult()) == 0;
    }

    private void loadDemoData() {
        var marketAR1 = new Market(IdGenerator.generateId(), "MAE", "Mercado Argentino", Country.ARGENTINA, new ArrayList<>(), new ArrayList<>());
        var marketAR2 = new Market(IdGenerator.generateId(), "ROFEX", "Rosario Futures Exchange", Country.ARGENTINA, new ArrayList<>(), new ArrayList<>());
        var marketUY1 = new Market(IdGenerator.generateId(), "UFEX", "Uruguay Futures Exchange", Country.URUGUAY, new ArrayList<>(), new ArrayList<>());

        entityManager.persist(marketAR1);
        entityManager.persist(marketAR2);
        entityManager.persist(marketUY1);

        var rand = new Random();
        var markets = List.of(marketAR1, marketAR2, marketUY1);
        for (int i = 1; i <= 100; i++) {
            var chosenMarket = markets.get(rand.nextInt(markets.size()));
            var account = new Account(IdGenerator.generateId(), "Demo Account " + i, List.of(chosenMarket), new ArrayList<>());
            chosenMarket.getAccounts().add(account);
            var transaction = new Transaction(IdGenerator.generateId(), account, BigDecimal.valueOf(100 + (10000000 - 100) * new Random().nextDouble()),
                    LocalDateTime.now(), TransactionType.getRandomTransactionType(), new Market());
            chosenMarket.getTransactions().add(transaction);
            entityManager.persist(account);
        }
    }


}