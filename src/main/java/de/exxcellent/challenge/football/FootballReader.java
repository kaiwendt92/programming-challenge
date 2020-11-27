package de.exxcellent.challenge.football;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FootballReader {
    String finalPath = "";

    public FootballReader(String type) {
        String pathToDocument = "C:/Users/kaiwe/Documents/programming-challenge/src/main/resources/de/exxcellent/challenge/";
        pathToDocument += type;
        this.finalPath = pathToDocument;
        System.out.println(finalPath);
    }

    public String getTeamByAbsoluteGoalDifference() {
        String line = "";
        String[] values;
        int minDelta;
        String minDeltaTeam = "";

        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader(this.finalPath));
                br.readLine();

                String firstLine = br.readLine();
                String[] firstLineArr = firstLine.split(",");
                minDelta = Math.abs(Integer.valueOf(firstLineArr[5]) - Integer.valueOf(firstLineArr[6]));

                while ((line = br.readLine()) != null) {
                    values = line.split(",");

                    int mxt = Integer.valueOf(values[5]);
                    int mnt = Integer.valueOf(values[6]);
                    int delta = Math.abs(mxt - mnt);

                    if (delta < minDelta) {
                        minDeltaTeam = values[0];
                        minDelta = delta;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return minDeltaTeam;
    }
}
