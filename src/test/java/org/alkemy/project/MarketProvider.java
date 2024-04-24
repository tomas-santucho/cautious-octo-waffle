package org.alkemy.project;

import org.alkemy.project.account.domain.Country;
import org.alkemy.project.account.domain.Market;

import java.util.List;

public class MarketProvider {
    public static Market providesMarket(final Long id) {
        return new Market(1L, "2222", "description" + id, Country.ARGENTINA, List.of());
    }
}
