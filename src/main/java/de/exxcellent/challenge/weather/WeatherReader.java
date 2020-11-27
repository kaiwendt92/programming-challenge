package de.exxcellent.challenge.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WeatherReader {
    String finalPath = "";

    public WeatherReader(String type) {
        String pathToDocument = "C:/Users/kaiwe/Documents/programming-challenge/src/main/resources/de/exxcellent/challenge/";
        pathToDocument += type;
        this.finalPath = pathToDocument;
        System.out.println(finalPath);
    }

    public String getDayWithSmallestTempSpread() {
        String line = "";
        String[] values;
        int minDelta;
        String minDeltaDay = "";

        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader(this.finalPath));
                br.readLine();

                String firstLine = br.readLine();
                String[] firstLineArr = firstLine.split(",");
                minDelta = Math.abs(Integer.valueOf(firstLineArr[1]) - Integer.valueOf(firstLineArr[2]));

                while ((line = br.readLine()) != null) {
                    values = line.split(",");
                    int mxt = Integer.valueOf(values[1]);
                    int mnt = Integer.valueOf(values[2]);
                    int delta = Math.abs(mxt - mnt);
                    if (delta < minDelta) {
                        minDeltaDay = values[0];
                        minDelta = delta;
                    }
                    ;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return minDeltaDay;
    }

}
