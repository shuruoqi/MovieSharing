package ui;

import model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class Watchlist {
    public ArrayList<Movie> watchList;
    Scanner scanner;

    //EFFECTS: construct a new watchList
    public void watchListSetUp() {
        watchList = new ArrayList<Movie>();
    }

    //EFFECTS: return the watchlist
    public ArrayList<Movie> getWatchList() {
        return watchList;
    }

    //EFFECTS: print out all the information of the given movie
    public void printAll(Movie m) {
        System.out.println("Movie name:" + m.getName());
        System.out.println("Price:" + m.getPrice());
        System.out.println("Show time:" + m.getShowTime());
    }

    //EFFECTS: asking for user input for movie choice,
    //         return the user input string
    public String chooseMovieScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Which movie would you like to watch?");
        return scanner.nextLine();
    }

    //EFFECTS: asking for user input for whether adding to the watchlist,
    //         return the user input string
    public String addToWatchlistScanner() {
        scanner = new Scanner(System.in);
        System.out.println("Add to the watchlist? [Yes] [No]");
        return scanner.nextLine();
    }

    //EFFECTS: if entering "Yes", then return true. Otherwise, return false
    public Boolean addToWatchlistResult(String choice) {
        if (choice.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: add the given movie to watchlist if it is not already in it
    public void insertMovieToWatchlist(Movie movie) {
        if (watchList.contains(movie)) {
            System.out.println("Already in the watchlist.");
        } else {
            watchList.add(movie);
        }
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
}
