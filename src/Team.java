import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Team {

    private String fileName;
    private String name;
    private int winHome;
    private int winOut;
    private int drawHome;
    private int drawOut;
    private int lossHome;
    private int lossOut;
    private int goals;
    private double goalsAverage;

    Team(String fileName) {
        try {
            this.fileName = fileName;
            this.name = nameOfTeam();
            this.winHome = Integer.parseInt(scoreArray()[10]);
            this.winOut = Integer.parseInt(scoreArray()[18]);
            this.drawHome = Integer.parseInt(scoreArray()[11]);
            this.drawOut = Integer.parseInt(scoreArray()[19]);
            this.lossHome = Integer.parseInt(scoreArray()[12]);
            this.lossOut = Integer.parseInt(scoreArray()[20]);
            this.goals = Integer.parseInt(scoreArray()[5]);
            this.goalsAverage = goalAverage();
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }

    }

    private double goalAverage(){
        double matchNumbers = Integer.parseInt(scoreArray()[1]);
        double average = goals/matchNumbers;
        average *= 100;
        average = Math.round(average);
        average /= 100;
        return average;
    }

    String[] scoreArray() {

        String onlyDigits = allFileData().get(1);
        return onlyDigits.split("\\s");
    }

    String nameOfTeam() {
        return allFileData().get(0);
    }

   List<String> allFileData(){

        String file = "team" + fileName + ".txt";
        Path path = Paths.get(file);

        List<String> text = new ArrayList<>();
        try {
            text = Files.readAllLines(path);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return text;
    }

    double getGoalsAverage() {
        return goalsAverage;
    }

    String getName() {
        return name;
    }

   int getWinHome() {
        return winHome;
    }

     int getWinOut() {
        return winOut;
    }

    int getDrawHome() {
        return drawHome;
    }

    int getDrawOut() {
        return drawOut;
    }

    int getLossHome() {
        return lossHome;
    }

    int getLossOut() {
        return lossOut;
    }

    String showTeam() {
        return "Drużyna: " + name
                + "\nwygrane u siebie: " + winHome
                + "\nwygrane na wyjeździe: " + winOut
                + "\nremisy u siebie: " + drawHome
                + "\nremisy na wyjeździe: " + drawOut
                + "\nprzegrane u siebie: " + lossHome
                + "\nprzegrane na wyjeździe: " + lossOut
                + "\nstrzelone gole: " + goals;
    }
}