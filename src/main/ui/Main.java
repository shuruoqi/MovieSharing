package ui;

import exception.ReputationException;
import exception.UpcomingException;
import model.Movie;
import model.PublicMovie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static ListOperation listOperation;

    public static void main(String[] args) throws IOException, ParseException, ReputationException, UpcomingException {
        listOperation = new ListOperation();

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("Jsonfile.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonarray = (JSONArray) jsonObject.get("results");
        for (Object o : jsonarray) {
            JSONObject movie = (JSONObject) o;
            String name = (String) movie.get("title");
            String date = (String) movie.get("release_date");
            Movie m = new PublicMovie();
            m.setName(name);
            m.setDate(date);
            listOperation.cinemaList.add(m);
        }
        listOperation.start();
    }
}
