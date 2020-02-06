import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    String first = "1";
    String second = "2";
    Team team1 = new Team(first);
    Team team2 = new Team(second);
    TeamPointer firstTeamPointer = new TeamPointer(team1);
    TeamPointer secondTeamPointer = new TeamPointer(team2);

    //pola tekstowe
    private JTextField team1TextField;
    private JTextField team2TextField;
    private JTextArea resultTextField;
    private JTextArea showFirstTeam;
    private JTextArea showSecondTeam;

    //etykiety
    private JLabel team1Label;
    private JLabel team2Label;
    private JLabel ownerLabel;

    // przycisk
    private JButton letsPlay;
    private JButton exit;
    private JButton loadFirstTeam;
    private JButton loadSecondTeam;


    Window() throws HeadlessException {


        setSize(700, 700); // ustaw rozmiar
        setTitle("Match Analyzer"); // ustaw tytuł
        setLayout(null);
        //opis
        team1Label = new JLabel("Gospodarze", JLabel.CENTER); // opis, tytuł, wyrównanie
        team1Label.setBounds(120, 5, 70, 20);

        team2Label = new JLabel("Goście", JLabel.CENTER); // opis, tytuł, wyrównanie
        team2Label.setBounds(440, 5, 70, 20);

        ownerLabel = new JLabel("RS Java Solutions. All rights reserved");
        ownerLabel.setBounds(440,560, 500,100);

        //Pole tekstowe
        team1TextField = new JTextField();
        team1TextField.setBounds(60, 30, 220, 30); //ustaw położenie i wymiary
        team1TextField.setToolTipText("Wklej punkty drużyny gospodarzy"); //dymek
        team1TextField.setText(team1.getName());

        team2TextField = new JTextField();
        team2TextField.setBounds(380, 30, 220, 30);
        team2TextField.setToolTipText("Wklej punkty drużyny gości");
        team2TextField.setText(team2.getName());

        showFirstTeam = new JTextArea();
        showFirstTeam.setBounds(60, 100, 220, 220);
        showFirstTeam.setToolTipText("Punktacja gospodarzy");


        showSecondTeam = new JTextArea();
        showSecondTeam.setBounds(380, 100, 220, 220);
        showSecondTeam.setToolTipText("Punktacja gości");

        resultTextField = new JTextArea();
        resultTextField.setBounds(200, 400, 250, 200);
        resultTextField.setToolTipText("Wynik");

        loadFirstTeam = new JButton("Wczytaj punktację gospodarzy");
        loadFirstTeam.setBounds(60, 60, 220, 30);
        loadFirstTeam.addActionListener(this);//dodanie action listenera do ramki

        loadSecondTeam = new JButton("Wczytaj punktację gości");
        loadSecondTeam.setBounds(380, 60, 220, 30);
        loadSecondTeam.addActionListener(this);//dodanie action listenera do ramki

        letsPlay = new JButton("Let's PLAY !");
        letsPlay.setBounds(120, 340, 450, 40);
        letsPlay.addActionListener(this);//dodanie action listenera do ramki

        exit = new JButton("Wyjście");
        exit.setBounds(480, 440, 80, 20);
        exit.addActionListener(this);

        add(team1TextField);
        add(team2TextField);
        add(team1Label);
        add(team2Label);
        add(letsPlay);
        add(exit);
        add(resultTextField);
        add(showFirstTeam);
        add(showSecondTeam);
        add(loadFirstTeam);
        add(loadSecondTeam);
        add(ownerLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        Object source = e.getSource();
        if (source == exit) {
            dispose();
        } else if (source == loadFirstTeam) {

            showFirstTeam.setWrapStyleWord(true);
            showFirstTeam.setText(team1.showTeam()
                    + firstTeamPointer.showScoreStatus());
        } else if (source == loadSecondTeam) {

            showSecondTeam.setWrapStyleWord(true);
            showSecondTeam.setText(team2.showTeam()
                    + secondTeamPointer.showScoreStatus());
        } else if (source == letsPlay){
            TeamConfrontation match = new TeamConfrontation(firstTeamPointer, secondTeamPointer);
           // match.battle();
            resultTextField.setWrapStyleWord(true);

            resultTextField.setText(match.estimatedPoints()
                    + "\n\n" + match.battle() + "\n\nRóżnica punktów wynosi + "
                    + match.differencePoints());
        }
    }
}
