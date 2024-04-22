package org.alkemy.project.stats.domain;

import org.alkemy.project.account.domain.Country;

import java.util.List;

public record Stats(Country country, List<MarketStats> markets) {
}
