package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save implements Saveable {

    public void save(ArrayList<Movie> movies, String textfile) throws IOException {
        PrintWriter writer = new PrintWriter(textfile, "UTF-8");
        for (Movie m : movies) {
            System.out.println(m.getName() + "," + m.getType() + "," + m.getQuality() + "," + m.getSize());
            writer.println(m.getName() + "," + m.getType() + "," + m.getQuality() + "," + m.getSize());
        }
        writer.close();
    }
}
