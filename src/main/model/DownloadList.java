package model;

import exception.ReputationException;
import exception.VipException;

import java.io.IOException;
import java.util.ArrayList;

public class DownloadList extends MovieList {

    public void add(Movie movie) throws ReputationException, VipException {
        if (checkRepetition(movie)) {
            throw new ReputationException();
        } else if (movie.getType().equals("VIP")) {
            throw new VipException();
        } else {
            movies.add(movie);
        }
    }

    @Override
    public void load() throws IOException {
        movies = load.load("./data/DownloadListFile.txt");
    }

    @Override
    public void save() throws IOException {
        save.save(movies, "./data/DownloadListFile.txt");
    }

    @Override
    public ArrayList<Movie> getList() {
        return movies;
    }

    @Override
    public void printAlready() {
        System.out.println("Already downloaded.");
    }
}
