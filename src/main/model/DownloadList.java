package model;

import ui.MovieList;

import java.io.IOException;
import java.util.ArrayList;

public class DownloadList extends MovieList {

    @Override
    public void load() throws IOException {
        Loadable loadDL = new Load();
        movies = loadDL.load("./data/DownloadListFile.txt");
    }

    @Override
    public void save() throws IOException {
        Savable save = new Save();
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
