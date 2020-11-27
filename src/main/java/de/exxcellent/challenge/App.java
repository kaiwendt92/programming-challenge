package de.exxcellent.challenge;

import de.exxcellent.challenge.football.FootballReader;
import de.exxcellent.challenge.weather.WeatherReader;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        /**
         * Due to my lack of knowledge when it comes to testing, since i've never actually did that in my jobs by now,
         * i am not sure how to handle this part right here.
         * When executing my tests both results are printed into the console.
         * I know that i can use the values in args which i am passing in "runWeather()" and "runFootball()" but when using the passed values to instantiate my Classes,
         * i am no longer able to execute my app.main itself.
         * */
        WeatherReader weatherReader = new WeatherReader("weather.csv");
        FootballReader footballReader = new FootballReader("football.csv");

        String dayWithSmallestTempSpread = weatherReader.getDayWithSmallestTempSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = footballReader.getTeamByAbsoluteGoalDifference(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
