package ui;

import model.Movie;
import model.Movielist;

import java.util.ArrayList;
import java.util.Scanner;

public class Watchlist extends Movielist {
    public ArrayList<Movie> watchList;
    Scanner scanner;
    boolean chooseMovieLoopState = true;
    boolean deleteMovieLoopState = true;

    @Override
    //EFFECTS: construct a new watchList
    public void listSetUp() {
        watchList = new ArrayList<Movie>();
    }

    @Override
    public ArrayList<Movie> getList() {
        return watchList;
    }

    @Override
    public void startScannerQ() {
    }

    @Override
    public void chooseMovieScannerQ() {
        System.out.println("Which movie would you like to watch?");
    }

    @Override
    public void addToListScannerQ() {
        System.out.println("Add to the watchlist? [Yes] [No]");
    }

    @Override
    public void continueToChooseMovieScannerQ() {
        System.out.println("Continue to choose movie? [Yes] [No]");
    }

    @Override
    public Boolean continueToChooseMovieResult(String choice) {
        if (choice.equals("Yes")) {
            return chooseMovieLoopState = true;
        } else {
            return chooseMovieLoopState = false;
        }
    }

    @Override
    public void printAlready() {
        System.out.println("Already in the watchlist.");
    }

    //EFFECTS: asking for user input for deleting movie choice,
    //         return the user input string
    public String deleteMovieScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Which movie would you like to remove from your watchlist?");
        return scanner.nextLine();
    }

    //EFFECTS: asking for user input for whether deleting movies from watchList,
    //         return the user input string
    public String deleteFromWatchlistScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Delete movies from watchlist? [Yes] [No]");
        return scanner.nextLine();
    }

    //EFFECTS: if entering "Yes", then return true. Otherwise, return false
    public Boolean deleteFromWatchlistResult(String choice) {
        if (choice.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    public String continueToDeleteMovieScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Continue to delete movie? [Yes] [No]");
        return scanner.nextLine();
    }

    public Boolean continueToDeleteMovieResult(String choice) {
        if (choice.equals("Yes")) {
            return deleteMovieLoopState = true;
        } else {
            return deleteMovieLoopState = false;
        }
    }
}
