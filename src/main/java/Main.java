import film.Film;
import film.FilmManager;
import ports.ConsoleLogger;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        consoleLogger.write("Introduce the number of films to estimate:");
        int numberOfFilms = consoleLogger.askPositiveInt();
        FilmManager filmManager = new FilmManager(numberOfFilms, consoleLogger);
        filmManager.createFilms();
        ArrayList<Film> films2023 = filmManager.getFilms2023();
        for (Film film2023 : films2023) {
            consoleLogger.write(film2023.toString());
        }
    }
}
