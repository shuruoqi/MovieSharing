package model;

import exception.ReputationException;
import exception.UpcomingException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MovieList {
    public ArrayList<Movie> movies;
    public Load load = new Load();
    Save save = new Save();

    MovieList() {
        movies = new ArrayList<>();
    }

    public abstract void load() throws IOException;

    public abstract void save() throws IOException;

    public ArrayList<Movie> getList() {
        return movies;
    }

    public void delete(String name) {
        Movie toBeRemoved = null;
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                toBeRemoved = m;
            }
        }
        movies.remove(toBeRemoved);
    }

    public Movie getMovie(String name) {
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

    public void add(Movie movie) throws ReputationException, UpcomingException {
        if (checkRepetition(movie)) {
            throw new ReputationException();
        } else {
            movies.add(movie);
        }
    }

    public void printAlready(String operation) {
        System.out.println("Already " + operation + "ed!");
    }

    public boolean checkRepetition(Movie movie) {
        for (Movie next : getList()) {
            if (movie.getName().equals(next.getName())) {
                return true;
            }
        }
        return false;
    }
}
