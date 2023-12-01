package film;

import ports.ConsoleLogger;

import java.util.ArrayList;

// Este sería el controlador en un MVC
public class FilmManager {

    private final int numberOfFilms;
    private final ConsoleLogger consoleLogger;
    private final ArrayList<Film> films2022;
    private final ArrayList<Film> films2023;

    public FilmManager(int numberOfFilms, ConsoleLogger consoleLogger) {
        this.numberOfFilms = numberOfFilms;
        this.consoleLogger = consoleLogger;
        this.films2022 = new ArrayList<>();
        this.films2023 = new ArrayList<>();
    }

    public ArrayList<Film> getFilms2022() {
        return films2022;
    }

    public ArrayList<Film> getFilms2023() {
        return films2023;
    }

    public void createFilms() {
        for (int i = 0; i < numberOfFilms; i++) {
            consoleLogger.write("Introduce the title of the film " + (i+1));
            String title = consoleLogger.askString();
            consoleLogger.write("Introduce the spectators of the film " + (i+1));
            int spectators = consoleLogger.askPositiveInt();
            consoleLogger.write("Introduce the title of the film " + (i+1));
            int rooms = consoleLogger.askPositiveInt();

            Film film2022 = new Film(title, spectators, rooms);
            film2022.computeGrossProfit();
            film2022.computeNetProfit();

            Film film2023 = new Film(title, (int)spectators/2, (int)rooms/2);
            film2023.computeGrossProfit();
            film2023.computeNetProfit();

            this.films2022.add(film2022);
            this.films2023.add(film2023);
        }
    }
}
