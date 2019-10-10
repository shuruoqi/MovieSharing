package ui;

import model.DownloadList;
import model.Movie;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    WatchList watchList;
    DownloadList downloadList;
    CinemaList cinemaList;
    Scanner scanner;
    int choice;
    boolean cycle;

    void start() throws IOException {
        cycle = true;
        cinemaList = new CinemaList();
        watchList = new WatchList();
        downloadList = new DownloadList();

        cinemaList.load();
        watchList.load();
        downloadList.load();

        System.out.println("Welcome!");
        while (cycle) {
            scanner = new Scanner(System.in);

            cycle = loop();
        }
        cinemaList.save();
        watchList.save();
        downloadList.save();

    }

    private void printChoices() {
        System.out.println("Please select one.");
        System.out.println("[1] check watchlist");
        System.out.println("[2] add to watchlist");
        System.out.println("[3] delete from watchlist");
        System.out.println("[4] download");
        System.out.println("[5] upload");
        System.out.println("[6] exit");
    }

    private boolean loop() {
        printChoices();
        choice = Integer.parseInt(scanner.nextLine());

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
            System.out.println("See you!");
            return false;
        }
        return true;
    }

    private void add() {
        System.out.println("Which movie would you like to watch?");
        String name = scanner.nextLine();
        Movie movie = cinemaList.getMovie(name);
        watchList.add(movie);
        movie.printInfo();
        System.out.println("Add successfully");
    }

    private void delete() {
        watchList.showAll();
        System.out.print("Which to delete: ");
        String name = scanner.nextLine();
        watchList.delete(name);
        System.out.println("Delete successfully");
    }

    private void download() {
        System.out.println("Which movie would you like to download?");
        watchList.showAll();
        String name = scanner.nextLine();
        Movie movie = watchList.getMovie(name);
        downloadList.add(movie);
        downloadList.showAll();
        System.out.println("Movies download successfully");
    }


}
