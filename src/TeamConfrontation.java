public class TeamConfrontation {

    private TeamPointer hosts;
    private TeamPointer guests;

    public TeamConfrontation(TeamPointer team1, TeamPointer team2) {
        this.hosts = team1;
        this.guests = team2;
    }

    String estimatedPoints() {
        return "Szacowana ilość punktów drużyny:\n " + hosts.getName() + " = " + hostsPoints() +
                "\nSzacowana ilość punktów drużyny:\n " + guests.getName() + " = " + guestPoints();
    }

    private double hostsPoints() {
        return hosts.getTotalScore() * 1.0;
    }

    private double guestPoints() {
        return guests.getTotalScore() * 0.88;
    }

    double differencePoints() {
        double difference = Math.abs(hostsPoints() - guestPoints());
        difference *=100;
        difference = Math.round(difference);
        difference /=100;
        return difference;
    }

    String battle() {
        String result;
        if (hostsPoints() > guestPoints() && differencePoints() < 10) {
            result = "Ten mecz wygra lub zremisuje \ndrużyna " + hosts.getName();
        }  else if (hostsPoints() > guestPoints() && differencePoints() > 10){
            result = "Ten mecz wygra drużyna " + hosts.getName();
        } else if (hostsPoints() == guestPoints()) {
            result = "Liczba punktów obydwu drużyn\n jest taka sama przewiduję remis";
        } else if (guestPoints() > hostsPoints() && differencePoints() < 10){
            result = "Ten mecz wygra lub zremisuje \ndrużyna " + guests.getName();
        } else {
            result = "Ten mecz wygra drużyna " + guests.getName();
        }
        return result;
    }
}
