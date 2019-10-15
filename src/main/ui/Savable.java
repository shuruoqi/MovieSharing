package ui;

import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

public interface Savable {
    void save(ArrayList<Movie> movies, String textFile) throws IOException;
}
