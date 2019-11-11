package network;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWebPage {
    public static BufferedReader br = null;

    public static void read() throws IOException {
        String apikey = "960a8b4b8aed849f72d97f69a6deb3c3";
        String moviequery = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
        String theURL = moviequery + apikey;
        URL url = new URL(theURL);
        br = new BufferedReader(new InputStreamReader(url.openStream()));
    }

    public static void main(String[] args) throws IOException {
        try {
            read();
            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            FileWriter fw = new FileWriter("Jsonfile.json");
            fw.write(String.valueOf(sb));
            fw.flush();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
