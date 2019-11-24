package model;

import java.io.IOException;

public class WatchList extends MovieList {

    @Override
    //EFFECTS: load all the movies into the movie list
    //MODIFIES: this
    public void load() throws IOException {
        movies = load.load("./data/WatchListFile.txt");
    }

    @Override
    //EFFECTS: save all the movies from the movie list
    public void save() throws IOException {
        save.save(movies, "./data/WatchListFile.txt");
    }
}
