package ports;

import film.Film;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Esta sería la vista en un MVC
public class ConsoleLogger {

    private final Scanner scanner;

    public ConsoleLogger() {
        this.scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void write (String message) {
        System.out.println(message);
    }

    public int askPositiveInt () {
        int number = this.getScanner().nextInt();
        while (number < 0) {
            System.out.println("Error: Insert a number greater than 0.");
            this.getScanner().nextLine(); // Cleaning the buffer
            number = this.getScanner().nextInt();
        }

        this.getScanner().nextLine(); // Cleaning the buffer
        return number;
    }

    public Date askDate() {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter a date in the format dd/MM/yyyy: ");
            String input = this.getScanner().nextLine();

            try {
                date = dateFormat.parse(input);
                isValid = true;
            } catch (ParseException e) {
                System.out.println("Error: Invalid date format. Please use dd/MM/yyyy.");
            }
        }
        return date;
    }

    public String askString() {
        return this.getScanner().nextLine();
    }

    public double askDouble() {
        double number = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                number = this.getScanner().nextDouble();
                this.getScanner().nextLine(); // Consume the newline character
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                this.getScanner().next(); // Consume the invalid input
            }
        }

        return number;
    }

    public void toJenkinsfile(ArrayList<Film> films) {
        String jenkinsfileData = "pipeline {\n" +
                "    agent any\n" +
                "\n" +
                "    stages {\n" +
                "        stage('Show films data') {\n" +
                "            steps {\n" +
                "               script {\n";
        for (Film film : films) {
            jenkinsfileData += "                   echo '" + film.toString() + "'\n";
        }
        jenkinsfileData +=
                "               }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(jenkinsfileData);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Jenkinsfile"))) {
            writer.write(jenkinsfileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}