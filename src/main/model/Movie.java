package model;

public abstract class Movie {
    private String name; //field
    private String quality;
    private double size;

    //MODIFIES: this
    //EFFECTS: initialize a movie that has name, showtime and size
    public Movie(String name, String quality, double size) { //Constructor
        this.name = name;
        this.quality = quality;
        this.size = size;
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
}
