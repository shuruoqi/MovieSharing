package ui;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WLOperation implements MLOperation {
    public ArrayList<Movie> cinemaList;//field
    Watchlist watchlist;
    Loadable load;
    Saveable save;

    Movie spiderman = new Movie("Spiderman", 1430, 15);
    Movie ironman = new Movie("Ironman", 1630, 16);
    Movie captainAmerica = new Movie("Captain America", 1700, 16);
    Movie thor = new Movie("Thor", 1400, 17);

    //EFFECTS: Build a new list and add objects into it
    public void operationSetUp() {
        watchlist = new Watchlist();
        watchlist.watchListSetUp();
        cinemaList = new ArrayList<>();
        cinemaList.add(spiderman);
        cinemaList.add(ironman);
        cinemaList.add(captainAmerica);
        cinemaList.add(thor);
    }

    //EFFECTS: set up watchList according to the storage
    public void start() throws IOException {
        load = new Load();
        watchlist.watchList = load.load("WatchListFile.txt");
    }

    //REQUIRES: the input equals to the movie's name
    //EFFECTS: execute printAll() method to the given movie
    //         add the given movie into the watchList
    public void chooseMovie() {
        String movieChoice = watchlist.chooseMovieScanner();
        for (Movie next : cinemaList) { //loop
            if (next.getName().equals(movieChoice)) { //condition
                watchlist.printAll(next);
                if (watchlist.addToWatchlistResult(watchlist.addToWatchlistScanner())) {
                    watchlist.insertMovieToWatchlist(next);
                }
            }
        }
    }

    //REQUIRES: the input equals to the string "Yes" or "No"
    //MODIFIES: chooseMovieLoopState
    //EFFECTS: if entering "NO", loopState = true. Otherwise, loopState = false
    public void continueToChooseMovie() {
        watchlist.continueToChooseMovieResult(watchlist.continueToChooseMovieScanner());
    }

    //EFFECTS: continue to choose movies or quit base on user's choice
    public void chooseMovieLoop() {
        while (watchlist.chooseMovieLoopState) {
            chooseMovie();
            continueToChooseMovie();
        }
    }

    //REQUIRES: the input equals to the movie's name
    //EFFECTS: remove the given movie from the watchList
    public void deleteMovie() {
        String movieChoice = watchlist.deleteMovieScanner();
        Movie toBeRemoved = new Movie("", 0000, 0);
        for (Movie next : watchlist.getWatchList()) {
            if (next.getName().equals(movieChoice)) {
                if (watchlist.deleteFromWatchlistResult(watchlist.deleteFromWatchlistScanner())) {
                    toBeRemoved = next;
                }
            }
        }
        watchlist.watchList.remove(toBeRemoved);
    }

    //REQUIRES: the input equals to the string "Yes" or "No"
    //MODIFIES: deleteMovieLoopState
    //EFFECTS: if entering "NO", loopState = true. Otherwise, loopState = false
    public void continueToDeleteMovie() {
        watchlist.continueToDeleteMovieResult(watchlist.continueToDeleteMovieScanner());
    }

    //EFFECTS: continue to delete movies or quit base on user's choice
    public void deleteMovieLoop() throws IOException {
        save = new Save();
        if (watchlist.deleteFromWatchlistResult(watchlist.deleteFromWatchlistScanner())) {
            while (watchlist.deleteMovieLoopState) {
                deleteMovie();
                continueToDeleteMovie();
            }
        }
        save.save(watchlist.getWatchList(),"WatchListFile.txt");
    }

    //EFFECTS: print all the names of the movies in the watchList
    public void printWatchlist() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Movie next : watchlist.getWatchList()) {
            nameList.add(next.getName());
        }
        System.out.println("Your watchlist : " + nameList);
    }
}
