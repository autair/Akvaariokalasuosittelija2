package akvaariokalasuosittelija.akvaariokalaprojekti.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataParser {

    private Scanner scanner;

    public DataParser() {

    }

    public List<String> getParsedData(File location) {
        try {
            scanner = new Scanner(location);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        List<String> parsedData = new ArrayList<>();

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    continue;
                }
                parsedData.add(line);

            }

            scanner.close();

        } catch (NullPointerException e) {
            System.err.println("Tapahtui virhe: " + e.getMessage());
        }

        return parsedData;
    }

}
