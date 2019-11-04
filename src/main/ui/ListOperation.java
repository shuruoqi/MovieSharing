package ui;

import exception.ReputationException;
import exception.VipException;
import model.*;

import java.io.IOException;
import java.util.Scanner;

public class ListOperation {
    Menu menu;
    MovieOperation movieOperation;
    WatchList watchList;
    DownloadList downloadList;
    CinemaList cinemaList;
    Scanner scanner;
    boolean loopState;

    void start() throws IOException {
        loopState = true;
        menu = new Menu();
        movieOperation = new MovieOperation();
        cinemaList = new CinemaList();
        watchList = new WatchList();
        downloadList = new DownloadList();
        scanner = new Scanner(System.in);

        cinemaList.load();
        watchList.load();
        downloadList.load();

        System.out.println("Welcome!");
        while (loopState) {
            loopState = loop();
        }
        cinemaList.save();
        watchList.save();
        downloadList.save();

    }

    private boolean loop() {
        menu.printChoices();
        return evaluate(menu.getChoice());
    }

    private boolean evaluate(int choice) {
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

    public void helper(MovieList movieList, String operation) throws ReputationException, VipException {
        String name = scanner.nextLine();
        Movie movie = cinemaList.getMovie(name);
        movie.printInfo();
        movieList.add(movie);
        printSuccess(operation);
    }

    public void printQuestion(String operation) {
        System.out.println("Which movie would you like to " + operation + "?");
    }

    public void printSuccess(String operation) {
        System.out.println(operation + " successfully");
    }

    public void addMovie() {
        String operation = "add";
        printQuestion(operation);
        try {
            helper(watchList,operation);
        } catch (ReputationException | VipException e) {
            watchList.printAlready(operation);
        }
    }

    public void deleteMovie() {
        String operation = "delete";
        watchList.showAll();
        printQuestion(operation);
        String name = scanner.nextLine();
        watchList.delete(name);
        printSuccess(operation);
    }

    public void download() {
        String operation = "download";
        printQuestion(operation);
        try {
            helper(downloadList, operation);
        } catch (ReputationException e) {
            downloadList.printAlready(operation);
        } catch (VipException e) {
            System.out.println("VIP movies are not downloadable, but they are accessible online.");
        } finally {
            System.out.println("Enjoy the movie!");
        }
    }

    public void upload() {
        String operation = "upload";
        try {
            movieOperation.identifyType();
            movieOperation.enterInfo();
            cinemaList.add(movieOperation.movie);
            printSuccess(operation);
        } catch (ReputationException | VipException e) {
            cinemaList.printAlready(operation);
        }
    }

    public void printMoviesOfGivenGenre() {
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
