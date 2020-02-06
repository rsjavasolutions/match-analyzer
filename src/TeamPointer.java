public class TeamPointer {

    private String name;
    private int pointsWinHome;
    private int pointsWinOut;
    private int pointsDrawHome;
    private int pointsDrawOut;
    private int pointsLossHome;
    private int pointsLossOut;
    private double scoreAverage;
    private int totalScore;

    TeamPointer(Team team) {
        name = team.getName();
        pointsWinHome = team.getWinHome() * 5;
        pointsWinOut = team.getWinOut() * 6;
        pointsDrawHome = team.getDrawHome() * 3;
        pointsDrawOut = team.getDrawOut() * 4;
        pointsLossHome = team.getLossHome() * 1;
        pointsLossOut = team.getLossOut() * 2;
        scoreAverage = team.getGoalsAverage();
        totalScore = pointsWinHome + pointsWinOut
                + pointsDrawHome + pointsDrawOut
                + pointsLossHome + pointsLossOut;
    }

    int getTotalScore() {
        return totalScore;
    }

    String getName() {
        return name;
    }

    String showScoreStatus() {
        return "\n\nTotal punktów dla drużyny: \n"
                + name + " wynosi: " + totalScore + "\n\n"
                + "Średnia goli: " + scoreAverage;
    }
}
