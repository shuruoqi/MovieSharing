package model;

public class Movie {
    private String name; //field
    private int showTime;
    private int price;

    //MODIFIES: this
    //EFFECTS: initialize a movie that has name, showtime and price
    public Movie(String name, int showTime, int price) { //Constructor
        this.name = name;
        this.showTime = showTime;
        this.price = price;
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

    //MODIFIES: this
    //EFFECTS: change the price of the movie to the given parameter name
    public void setPrice(int price) {
        this.price = price;
    }

    //EFFECTS: return the price of the movie
    public int getPrice() {
        return price;
    }

    //MODIFIES: this
    //EFFECTS: change the showtime of the movie to the given parameter name
    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    //EFFECTS: return the showtime of the movie
    public int getShowTime() {
        return showTime;
    }
}
