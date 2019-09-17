package ui;

import java.util.Scanner;

public class Movie {
    private String name; //field
    private int showTime;
    private int price;

    public Movie(String name, int showTime, int price) { //Constructor
        this.name = name;
        this.showTime = showTime;
        this.price = price;
    }



    public void setName(String name) { //pass
        this.name = name;
    }

    public String getName() { //return
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int getShowTime() {
        return showTime;
    }
}
