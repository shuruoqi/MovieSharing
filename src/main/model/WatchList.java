package model;

import exception.ReputationException;
import exception.VipException;
import ui.CinemaList;
import java.io.IOException;
import java.util.Scanner;

public class WatchList extends MovieList {

    public void add() throws IOException {
        String operation = "add";
        CinemaList cinemaList = new CinemaList();
        try {
            cinemaList.helper(this, operation);
        } catch (ReputationException | VipException e) {
            printAlready(operation);
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        showAll();
        System.out.print("Which to delete: ");
        String name = scanner.nextLine();
        delete(name);
        System.out.println("Delete successfully");
    }

    @Override
    public void load() throws IOException {
        movies = load.load("./data/WatchListFile.txt");
    }

    @Override
    public void save() throws IOException {
        save.save(movies, "./data/WatchListFile.txt");
    }
}
