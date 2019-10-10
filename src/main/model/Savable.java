package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Savable {
    void save(ArrayList<Movie> movies, String textFile) throws IOException;
}
