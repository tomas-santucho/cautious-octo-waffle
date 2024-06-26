package org.alkemy.project.stats.rest;

import org.alkemy.project.stats.core.StatsService;
import org.alkemy.project.stats.domain.Stats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(final StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Stats>> get() {
        return ResponseEntity.ok(statsService.get());
    }
}
