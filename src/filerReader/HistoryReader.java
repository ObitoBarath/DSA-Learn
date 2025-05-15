package filerReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HistoryReader {


    public static void main(String[] args) {
        String historyFile = System.getProperty("user.home") + "/.bash_history";

        try (BufferedReader reader = new BufferedReader(new FileReader(historyFile))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("History file not found. Are you using Bash?");
        } catch (IOException e) {
            System.err.println("Error reading the history file: " + e.getMessage());
        }
    }
}
