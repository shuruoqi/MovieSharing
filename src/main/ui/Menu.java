package ui;

import exception.ReputationException;
import exception.VipException;
import model.DownloadList;
import model.Genre;
import model.Movie;
import model.WatchList;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    WatchList watchList;
    DownloadList downloadList;
    CinemaList cinemaList;
    Scanner scanner;
    int choice;
    boolean loopState;

    void start() throws IOException, ReputationException, VipException {
        loopState = true;
        cinemaList = new CinemaList();
        watchList = new WatchList();
        downloadList = new DownloadList();

        cinemaList.load();
        watchList.load();
        downloadList.load();

        System.out.println("Welcome!");
        while (loopState) {
            scanner = new Scanner(System.in);

            loopState = loop();
        }
        cinemaList.save();
        watchList.save();
        downloadList.save();

    }

    private void printChoices() {
        System.out.println("[1] check watchlist");
        System.out.println("[2] add to watchlist");
        System.out.println("[3] delete from watchlist");
        System.out.println("[4] download");
        System.out.println("[5] upload");
        System.out.println("[6] Movie Genres");
        System.out.println("[7] exit");
    }

    private boolean loop() {
        printChoices();
        choice = Integer.parseInt(scanner.nextLine());
        return evaluate(choice);
    }

    private boolean evaluate(int choice) {
        if (choice == 1) {
            watchList.showAll();
        } else if (choice == 2) {
            add();
        } else if (choice == 3) {
            delete();
        } else if (choice == 4) {
            download();
        } else if (choice == 5) {
            cinemaList.upload();
        } else if (choice == 6) {
            printMoviesOfGivenGenre();
        } else if (choice == 7) {
            System.out.println("See you!");
            return false;
        }
        return true;
    }

    private void add() {
        try {
            System.out.println("Which movie would you like to watch?");
            String name = scanner.nextLine();
            Movie movie = cinemaList.getMovie(name);
            watchList.add(movie);
            movie.printInfo();
            System.out.println("Add successfully");
        } catch (ReputationException | VipException e) {
            watchList.printAlready();
        }
    }

    private void delete() {
        watchList.showAll();
        System.out.print("Which to delete: ");
        String name = scanner.nextLine();
        watchList.delete(name);
        System.out.println("Delete successfully");
    }

    private void download() {
        try {
            System.out.println("Which movie would you like to download?");
            watchList.showAll();
            String name = scanner.nextLine();
            Movie movie = watchList.getMovie(name);
            downloadList.add(movie);
            downloadList.showAll();
            System.out.println("Movies download successfully");
        } catch (ReputationException e) {
            downloadList.printAlready();
        } catch (VipException e) {
            System.out.println("VIP movies are not downloadable, but they are accessible online.");
        } finally {
            System.out.println("Enjoy the movie!");
        }
    }

    private void printMoviesOfGivenGenre() {
        System.out.println("Which movie Genre would you like to choose?");
        String genreName = scanner.nextLine();
        for (Genre genre : cinemaList.genreMap.keySet()) {
            if (genre.equals(new Genre(genreName))) {
                for (Movie movie : genre.getMovies()) {
                    System.out.print(movie.getName() + " ");
                }
            }
        }
    }
}
