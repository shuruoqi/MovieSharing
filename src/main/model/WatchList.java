package model;

import ui.Loadable;
import ui.Savable;

import java.io.IOException;
import java.util.ArrayList;

public class WatchList extends MovieList {

    @Override
    public void load() throws IOException {
        Loadable loadWL = new Load();
        movies = loadWL.load("./data/WatchListFile.txt");
    }

    @Override
    public void save() throws IOException {
        Savable save = new Save();
        save.save(movies, "./data/WatchListFile.txt");
    }

    @Override
    public ArrayList<Movie> getList() {
        return movies;
    }

    @Override
    public void printAlready() {
        System.out.println("Already in the watchlist.");
    }

}
