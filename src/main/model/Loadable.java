package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Loadable {
    ArrayList<Movie> load(String textfile) throws IOException;
}