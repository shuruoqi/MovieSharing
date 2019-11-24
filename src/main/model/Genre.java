package model;

import java.util.ArrayList;
import java.util.Objects;

public class Genre {
    private ArrayList<Movie> movies;
    private String name;

    public Genre(String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //EFFECTS: If the movie list doesn't contain the given movie, add the movie to the movie list and add this genre to
    //         the given movie. Otherwise, do nothing
    public void addMovie(Movie movie) {
        if (!movies.contains(movie)) {
            movies.add(movie);
            movie.addGenre(this);
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Genre genre = (Genre) o;
        return name.equals(genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
