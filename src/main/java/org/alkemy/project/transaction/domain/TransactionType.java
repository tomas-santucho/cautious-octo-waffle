package org.alkemy.project.transaction.domain;

import java.util.Random;

public enum TransactionType {
    INCOME, EXPENSE, TRANSFER;

    private static final Random random = new Random();

    public static TransactionType getRandomTransactionType() {
        var values = TransactionType.values();
        int index = random.nextInt(values.length);
        return values[index];
    }
}
