package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {

    //EFFECTS: save all the movies in the movie list to the given file
    public void save(ArrayList<Movie> movies, String textFile) throws IOException {
        PrintWriter writer = new PrintWriter(textFile, "UTF-8");
        for (Movie m : movies) {
            writer.println(m.getName() + ","
                    + m.getType() + ","
                    + m.getDate() + ","
                    + m.getAllGenresName());
        }
        writer.close();
    }
}
