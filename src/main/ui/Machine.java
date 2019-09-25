package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    public ArrayList<Movie> movieList;
    public Scanner scanner;

    public static void main(String[] args) {
        Operation operation = new Operation(); //local
        welcome();
        operation.operationSetUp();
        operation.chooseMovie();
        bye();
    }

    // EFFECTS: print out Welcome!
    public static void welcome() {
        System.out.println("Welcome!");
    }

    // EFFECTS: print out Bye!
    public static void bye() {
        System.out.println("Bye!");
    }

}
