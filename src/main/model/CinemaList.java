package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CinemaList extends MovieList {
    public Movie movie;
    public HashMap<Genre, ArrayList<Movie>> genreMap = new HashMap<>();

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
    public void load() throws IOException {
        movies = load.load("./data/CinemaListFile.txt");
        for (Movie movie : movies) {
            updateMap(movie);
        }
    }

    @Override
    public void save() throws IOException {
        save.save(movies, "./data/CinemaListFile.txt");
    }
}
