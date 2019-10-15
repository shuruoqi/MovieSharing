package model;

import ui.Savable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save implements Savable {

    public void save(ArrayList<Movie> movies, String textFile) throws IOException {
        PrintWriter writer = new PrintWriter(textFile, "UTF-8");
        for (Movie m : movies) {
            writer.println(m.getName() + "," + m.getType() + "," + m.getQuality() + "," + m.getSize());
        }
        writer.close();
    }
}
