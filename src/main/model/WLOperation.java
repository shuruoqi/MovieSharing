package model;

import model.*;
import ui.Cinemalist;
import ui.Watchlist;

import java.io.IOException;
import java.util.ArrayList;

public class WLOperation {
    Cinemalist cinemalist;
    Watchlist watchlist;
    Loadable loadWL;
    Loadable loadCL;
    Saveable saveWL;

    //EFFECTS: Build a new list and add objects into it
    public void operationSetUp() throws IOException {
        cinemalist = new Cinemalist();
        cinemalist.listSetUp();
        watchlist = new Watchlist();
        watchlist.listSetUp();

    }

    //EFFECTS: set up watchList according to the storage
    public void start() throws IOException {
        loadWL = new Load();
        watchlist.watchList = loadWL.load("./data/WatchListFile.txt");
        loadCL = new Load();
        cinemalist.cinemaList = loadCL.load("./data/CinemaListFile.txt");
    }

    //REQUIRES: the input equals to the movie's name
    //EFFECTS: execute printAll() method to the given movie
    //         add the given movie into the watchList
    public void chooseMovie() {
        String movieChoice = watchlist.chooseMovieScanner();
        for (Movie next : cinemalist.cinemaList) { //loop
            if (next.getName().equals(movieChoice)) { //condition
                watchlist.printAllInfo(next);
                if (watchlist.addToListResult(watchlist.addToListScanner())) {
                    watchlist.insertMovieToList(next);
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
        Movie toBeRemoved = null;
        for (Movie next : watchlist.getList()) {
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
        saveWL = new Save();
        if (watchlist.deleteFromWatchlistResult(watchlist.deleteFromWatchlistScanner())) {
            while (watchlist.deleteMovieLoopState) {
                deleteMovie();
                continueToDeleteMovie();
            }
        }
        saveWL.save(watchlist.getList(),"./data/WatchListFile.txt");
    }

    //EFFECTS: print all the names of the movies in the watchList
    public void printNameList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Movie next : watchlist.getList()) {
            nameList.add(next.getName());
        }
        System.out.println("Your watchlist : " + nameList);
    }
}
