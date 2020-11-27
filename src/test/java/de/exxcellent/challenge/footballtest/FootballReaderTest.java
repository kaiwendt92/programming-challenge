package de.exxcellent.challenge.footballtest;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.football.FootballReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballReaderTest {

    private static FootballReader footballReader;

    @BeforeEach
    void setUp() {
        footballReader = new FootballReader("football.csv");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void getTeamByAbsoluteGoalDifference() {
        String minDeltaTeam = footballReader.getTeamByAbsoluteGoalDifference();
        assertEquals("Aston_Villa", minDeltaTeam, "My expectations were not met");
    }

    @AfterEach
    void tearDown() {
        footballReader = null;
    }

}