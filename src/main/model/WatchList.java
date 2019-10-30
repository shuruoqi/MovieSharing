package model;

import java.io.IOException;
import java.util.ArrayList;

public class WatchList extends MovieList {

    @Override
    public void load() throws IOException {
        movies = load.load("./data/WatchListFile.txt");
    }

    @Override
    public void save() throws IOException {
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
