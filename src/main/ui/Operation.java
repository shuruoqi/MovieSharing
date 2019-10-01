package ui;

import model.Load;
import model.Movie;
import model.Save;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operation {
    public ArrayList<Movie> movieList;//field
    Watchlist watchlist;
    boolean chooseMovieLoopState = true;
    boolean deleteMovieLoopState = true;
    Scanner scanner;
    Load load;
    Save save;

    Movie spiderman = new Movie("Spiderman", 1430, 15);
    Movie ironman = new Movie("Ironman", 1630, 16);
    Movie captainAmerica = new Movie("Captain America", 1700, 16);
    Movie thor = new Movie("Thor", 1400, 17);

    //EFFECTS: Build a new list and add objects into it
    public void operationSetUp() {
        watchlist = new Watchlist();
        watchlist.watchListSetUp();
        movieList = new ArrayList<>();
        movieList.add(spiderman);
        movieList.add(ironman);
        movieList.add(captainAmerica);
        movieList.add(thor);
    }

    //EFFECTS:
    public void start() throws IOException {
        load = new Load();
        load.load("WatchListFile.txt");
        watchlist.watchList = load.movies;
    }

    //REQUIRES: the input equals to the movie's name
    //EFFECTS: execute printAll() method to the given movie
    //         add the given movie into the watchList
    public void chooseMovie() {
        String movieChoice = watchlist.chooseMovieScanner();
        for (Movie next : movieList) { //loop
            if (next.getName().equals(movieChoice)) { //condition
                watchlist.printAll(next);
                if (watchlist.addToWatchlistResult(watchlist.addToWatchlistScanner())) {
                    watchlist.insertMovieToWatchlist(next);
                }
            }
        }
    }

    //REQUIRES: the input equals to the string "Yes" or "No"
    //MODIFIES: deleteMovieLoopState
    //EFFECTS: if entering "NO", loopState = true. Otherwise, loopState = false
    public void continueToDeleteMovie() {
        scanner = new Scanner(System.in);
        System.out.println("Continue to delete movie? [Yes] [No]");
        String choose = scanner.nextLine();
        if (choose.equals("Yes")) {
            deleteMovieLoopState = true;
        } else {
            deleteMovieLoopState = false;
        }
    }

    //EFFECTS: continue to choose movies or quit base on user's choice
    public void chooseMovieLoop() {
        while (chooseMovieLoopState) {
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
    //MODIFIES: chooseMovieLoopState
    //EFFECTS: if entering "NO", loopState = true. Otherwise, loopState = false
    public void continueToChooseMovie() {
        scanner = new Scanner(System.in);
        System.out.println("Continue to choose movie? [Yes] [No]");
        String choose = scanner.nextLine();
        if (choose.equals("Yes")) {
            chooseMovieLoopState = true;
        } else {
            chooseMovieLoopState = false;
        }
    }

    //EFFECTS: continue to delete movies or quit base on user's choice
    public void deleteMovieLoop() throws IOException {
        save = new Save();
        if (watchlist.deleteFromWatchlistResult(watchlist.deleteFromWatchlistScanner())) {
            while (deleteMovieLoopState) {
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
