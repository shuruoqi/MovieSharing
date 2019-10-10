package ui;

import model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class MovieList {
    public ArrayList<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
    }

    public abstract void load() throws IOException;

    public abstract void save() throws IOException;

    public abstract ArrayList<Movie> getList();

    void delete(String name) {
        Movie temp = null;
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                temp = m;
            }
        }
        movies.remove(temp);
    }

    Movie getMovie(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public void showAll() {
        for (Movie m : movies) {
            m.printInfo();
        }
    }

    public void add(Movie movie) {
        if (checkRepetition(movie)) {
            printAlready();
        } else {
            movies.add(movie);
        }
    }

    public abstract void printAlready();

    public boolean checkRepetition(Movie movie) {
        for (Movie next : getList()) {
            if (movie.getName().equals(next.getName())) {
                return true;
            }
        }
        return false;
    }
}
