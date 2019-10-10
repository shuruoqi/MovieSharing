package model;

public abstract class Movie {
    private String name; //field
    private String quality;
    private double size;

    //EFFECTS: print out all the information of the given movie
    public void printInfo() {
        System.out.println("Movie name:" + getName()
                + "---Quality:" + getQuality() + "---Size:" + getSize());
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
