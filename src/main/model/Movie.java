package model;

import java.util.ArrayList;

public abstract class Movie {
    private String name; //field
    private String date;
    private ArrayList<Genre> genres = new ArrayList<>();


    //EFFECTS: print out all the information of the given movie
    public String printInfo() {
        return ("Name:" + getName()
                + "---ReleaseDate:" + getDate()
                + "---Genres:" + getAllGenresName());
    }

    //MODIFIES: this
    //EFFECTS: change the name of the movie to the given parameter name
    public void setName(String name) { //pass
        this.name = name;
    }

    //EFFECTS: return the name of the movie
    public String getName() { //return
        return name;
    }

    public abstract String getType();

    //MODIFIES: this
    //EFFECTS: change the price of the movie to the given parameter name
    public void setDate(String date) {
        this.date = date;
    }

    //EFFECTS: return the price of the movie
    public String getDate() {
        return date;
    }

    //MODIFIES: this
    //EFFECTS: if the genre list doesn't contain the given genre, then add it to the list. Otherwise, do nothing
    public void addGenre(Genre genre) {
        if (!this.genres.contains(genre)) {
            genres.add(genre);
            genre.addMovie(this);
        }
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    //EFFECTS: produce the name of all genres in the genre list
    public String getAllGenresName() {
        String nameLine = "";
        for (Genre genre : genres) {
            nameLine += genre.getName() + " ";
        }
        return nameLine.substring(0, nameLine.length() - 1);

    }
}
