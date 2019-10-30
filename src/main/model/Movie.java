package model;

import java.util.ArrayList;

public abstract class Movie {
    private String name; //field
    private String quality;
    private double size;
    private ArrayList<Genre> genres = new ArrayList<>();


    //EFFECTS: print out all the information of the given movie
    public void printInfo() {
        System.out.print("Movie name:" + getName()
                + "   Quality:" + getQuality() + "   Size:" + getSize() + "   Genres:");
        printAllGenres();
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
    public void setSize(double size) {
        this.size = size;
    }

    //EFFECTS: return the price of the movie
    public double getSize() {
        return size;
    }

    //MODIFIES: this
    //EFFECTS: change the showtime of the movie to the given parameter name
    public void setQuality(String quality) {
        this.quality = quality;
    }

    //EFFECTS: return the showtime of the movie
    public String getQuality() {
        return quality;
    }

    public void addGenre(Genre genre) {
        if (!this.genres.contains(genre)) {
            genres.add(genre);
            genre.addMovie(this);
        }
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public String getAllGenresName() {
        String nameLine = "";
        for (Genre genre : genres) {
            nameLine += genre.getName() + " ";
        }
        return nameLine.substring(0, nameLine.length() - 1);

    }

    public void printAllGenres() {
        for (Genre genre : genres) {
            System.out.print(genre.getName());
        }
    }
}
