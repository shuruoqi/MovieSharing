package ui;

import exception.ReputationException;
import exception.VipException;
import model.DownloadList;
import model.Movie;
import model.MovieList;
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

    void start() throws IOException {
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

    private boolean loop() throws IOException {
        printChoices();
        choice = Integer.parseInt(scanner.nextLine());
        return evaluate(choice);
    }

    private boolean evaluate(int choice) throws IOException {
        if (choice == 1) {
            watchList.showAll();
        } else if (choice == 2) {
            watchList.add();
        } else if (choice == 3) {
            watchList.delete();
        } else if (choice == 4) {
            downloadList.download();
        } else if (choice == 5) {
            cinemaList.upload();
        } else if (choice == 6) {
            cinemaList.printMoviesOfGivenGenre();
        } else if (choice == 7) {
            System.out.println("See you!");
            return false;
        }
        return true;
    }
}
