package model;

import java.io.IOException;

public class WatchList extends MovieList {

    @Override
    public void load() throws IOException {
        movies = load.load("./data/WatchListFile.txt");
    }

    @Override
    public void save() throws IOException {
        save.save(movies, "./data/WatchListFile.txt");
    }
}
