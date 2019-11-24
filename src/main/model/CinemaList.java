package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaList extends MovieList {
    public Movie movie;
    public HashMap<Genre, ArrayList<Movie>> genreMap = new HashMap<>();

    //MODIFIES: this
    //EFFECTS: If the genreMap contains all the genres of the given movie, add the given movie to all its genres' lists.
    //         Otherwise, put the non-included genre and the given movie into the genreMap
    public void updateMap(Movie movie) {
        for (Genre genre : movie.getGenres()) {
            if (genreMap.containsKey(genre)) {
                ArrayList<Movie> originalList = genreMap.get(genre);
                originalList.add(movie);
            } else {
                genreMap.put(genre, genre.getMovies());
            }
        }
    }

    @Override
    //MODIFIES: this
    //EFFECTS: load all the movies into the genreMap
    public void load() throws IOException {
        movies = load.load("./data/CinemaListFile.txt");
        for (Movie movie : movies) {
            updateMap(movie);
        }
    }

    @Override
    //EFFECTS: save all the movies from the genreMap
    public void save() throws IOException {
        save.save(movies, "./data/CinemaListFile.txt");
    }
}
