package ui;

import exception.ReputationException;
import exception.UpcomingException;
import model.*;

import java.io.IOException;
import java.util.Scanner;

public class ListOperation {
    private Menu menu;
    private MovieOperation movieOperation;
    private WatchList watchList;
    private DownloadList downloadList;
    private CinemaList cinemaList;
    private Scanner scanner;

    void start() throws IOException {
        boolean loopState = true;
        menu = new Menu();
        movieOperation = new MovieOperation();
        cinemaList = new CinemaList();
        watchList = new WatchList();
        downloadList = new DownloadList();
        scanner = new Scanner(System.in);

        loadAll();
        System.out.println("Welcome!");
        while (loopState) {
            loopState = loop();
        }
        saveAll();
    }

    private void loadAll() throws IOException {
        cinemaList.load();
        watchList.load();
        downloadList.load();
    }

    private void saveAll() throws IOException {
        cinemaList.save();
        watchList.save();
        downloadList.save();
    }

    private boolean loop() {
        menu.printChoices();
        return evaluate(menu.getChoice());
    }

    public boolean evaluate(int choice) {
        if (choice == 1) {
            watchList.showAll();
        } else if (choice == 2) {
            addMovie();
        } else if (choice == 3) {
            deleteMovie();
        } else if (choice == 4) {
            download();
        } else if (choice == 5) {
            upload();
        } else if (choice == 6) {
            printMoviesOfGivenGenre();
        } else if (choice == 7) {
            System.out.println("See you!");
            return false;
        }
        return true;
    }

    private void helper(MovieList movieList, String operation) throws ReputationException, UpcomingException {
        String name = scanner.nextLine();
        Movie movie = cinemaList.getMovie(name);
        movie.printInfo();
        movieList.add(movie);
        printSuccess(operation);
    }

    private void printQuestion(String operation) {
        System.out.println("Which movie would you like to " + operation + "?");
    }

    private void printSuccess(String operation) {
        System.out.println(operation + " successfully");
    }

    private void addMovie() {
        String operation = "add";
        printQuestion(operation);
        try {
            helper(watchList,operation);
        } catch (ReputationException | UpcomingException e) {
            watchList.printAlready(operation);
        }
    }

    private void deleteMovie() {
        String operation = "delete";
        watchList.showAll();
        printQuestion(operation);
        String name = scanner.nextLine();
        watchList.delete(name);
        printSuccess(operation);
    }

    private void download() {
        String operation = "download";
        printQuestion(operation);
        try {
            helper(downloadList, operation);
        } catch (ReputationException e) {
            downloadList.printAlready(operation);
        } catch (UpcomingException e) {
            System.out.println("Upcoming movies are not downloadable.");
        }
    }

    private void upload() {
        String operation = "upload";
        try {
            movieOperation.identifyType();
            movieOperation.enterInfo();
            cinemaList.add(movieOperation.movie);
            printSuccess(operation);
        } catch (ReputationException | UpcomingException e) {
            cinemaList.printAlready(operation);
        }
    }

    private void printMoviesOfGivenGenre() {
        System.out.println("Which movie Genre would you like to choose?");
        String genreName = scanner.nextLine();
        for (Genre genre : cinemaList.genreMap.keySet()) {
            if (genre.equals(new Genre(genreName))) {
                for (Movie movie : genre.getMovies()) {
                    System.out.print(movie.getName() + "; ");
                }
                System.out.println(" ");
            }
        }
    }
}
