package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Movielist {
    Scanner scanner;

    public abstract void listSetUp() throws IOException;

    public abstract ArrayList<Movie> getList();

    public String startScanner() {
        scanner = new Scanner(System.in);
        startScannerQ();
        return scanner.nextLine();
    }

    public abstract void startScannerQ();

    public Boolean startResult(String choice) {
        if (choice.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: print out all the information of the given movie
    public void printAllInfo(Movie m) {
        System.out.println("Movie name:" + m.getName());
        System.out.println("Quality:" + m.getQuality());
        System.out.println("Size:" + m.getSize());
    }

    //EFFECTS: asking for user input for movie choice,
    //         return the user input string
    public String chooseMovieScanner() {
        scanner = new Scanner(System.in);
        chooseMovieScannerQ();
        return scanner.nextLine();
    }

    public abstract void chooseMovieScannerQ();

    //EFFECTS: asking for user input for whether adding to the watchlist,
    //         return the user input string
    public String addToListScanner() {
        scanner = new Scanner(System.in);
        addToListScannerQ();
        return scanner.nextLine();
    }

    public abstract void addToListScannerQ();

    //EFFECTS: if entering "Yes", then return true. Otherwise, return false
    public Boolean addToListResult(String choice) {
        if (choice.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    public String continueToChooseMovieScanner() {
        scanner = new Scanner(System.in);
        continueToChooseMovieScannerQ();
        return scanner.nextLine();
    }

    public abstract void continueToChooseMovieScannerQ();

    public abstract Boolean continueToChooseMovieResult(String choice);


    public void insertMovieToList(Movie movie) {
        if (checkRepetition(movie)) {
            printAlready();
        } else {
            getList().add(movie);
        }
    }

    public abstract void printAlready();

    public boolean checkRepetition(Movie movie) {
        for (Movie next : getList()) {
            if (movie.getName().equals(next.getName())) {
                return true;
            }
        }
        return false;
    }
}
