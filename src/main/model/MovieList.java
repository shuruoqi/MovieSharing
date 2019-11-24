package model;

import exception.RepetitionException;
import exception.UpcomingException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class MovieList {
    public ArrayList<Movie> movies;
    public Load load = new Load();
    Save save = new Save();

    public MovieList() {
        movies = new ArrayList<>();
    }

    public abstract void load() throws IOException;

    public abstract void save() throws IOException;

    public ArrayList<Movie> getList() {
        return movies;
    }

    //EFFECTS: If the movie of th given name is found in the movie list, then remove it. Otherwise, do nothing
    //MODIFIES: this
    public void delete(String name) {
        Movie toBeRemoved = null;
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                toBeRemoved = m;
            }
        }
        movies.remove(toBeRemoved);
    }

    //EFFECTS: If the movie of th given name is found in the movie list, then return the movie. Otherwise, return null
    public Movie getMovie(String name) {
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    //EFFECTS: return a list that contains all the info of all the movies in the movie list
    public ArrayList<String> showAll() {
        ArrayList<String> allInfo = new ArrayList<>();
        for (Movie m : movies) {
            allInfo.add(m.printInfo());
        }
        return allInfo;
    }

    //EFFECTS: Add the given movie to the movie list.
    //         If the movie is already in the movie list, throw RepetitionException
    //MODIFIES: this
    public void add(Movie movie) throws RepetitionException, UpcomingException {
        if (checkRepetition(movie)) {
            throw new RepetitionException();
        } else {
            movies.add(movie);
        }
    }

    //EFFECTS: Print successful information
    public void printAlready(String operation) {
        System.out.println("Already " + operation + "ed!");
    }

    //EFFECTS: return true if the movie list contains the movie with the given name. Otherwise, return false
    public boolean checkRepetition(Movie movie) {
        for (Movie next : getList()) {
            if (movie.getName().equals(next.getName())) {
                return true;
            }
        }
        return false;
    }
}
