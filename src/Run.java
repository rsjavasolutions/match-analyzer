import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) throws IOException {

        Window window = new Window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zamykanie w procesach po zamknięciu
        window.setVisible(true);//widoczne
    }
}
