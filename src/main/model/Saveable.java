package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Saveable {
    void save(ArrayList<Movie> movies, String textfile) throws IOException;
}
