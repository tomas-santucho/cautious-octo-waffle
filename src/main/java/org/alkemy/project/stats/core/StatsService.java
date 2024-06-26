package org.alkemy.project.stats.core;

import org.alkemy.project.account.data.MarketRepository;
import org.alkemy.project.account.domain.Country;
import org.alkemy.project.stats.domain.MarketStats;
import org.alkemy.project.stats.domain.PercentageData;
import org.alkemy.project.stats.domain.Stats;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StatsService {
    private final MarketRepository marketRepository;

    public StatsService(final MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public List<Stats> get() { //TODO en otra iteracion esto se deberia poder hacer sin usar Object
        var rawResults = marketRepository.findMarketDistributionRaw();
        var groupedData = new HashMap<Country, List<MarketStats>>();

        rawResults.forEach(data -> {
            var country = (Country) data[0];
            var marketCode = (String) data[1];
            var accountCount = (Long) data[2];

            groupedData.computeIfAbsent(country, k -> new ArrayList<>()).add(new MarketStats(marketCode, new PercentageData(BigDecimal.valueOf(accountCount))));
        });

        var statsList = new ArrayList<Stats>();
        groupedData.forEach((country, markets) -> {
            statsList.add(new Stats(country, markets));
        });

        return statsList;
    }
}
