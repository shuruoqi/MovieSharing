package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {

    public void save(ArrayList<Movie> movies, String textFile) throws IOException {
        PrintWriter writer = new PrintWriter(textFile, "UTF-8");
        for (Movie m : movies) {
            writer.println(m.getName() + ","
                    + m.getType() + ","
                    + m.getQuality() + ","
                    + m.getSize() + ","
                    + m.getAllGenresName());
        }
        writer.close();
    }
}
