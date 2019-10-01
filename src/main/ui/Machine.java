package ui;

import java.io.IOException;

public class Machine {

    public static void main(String[] args) throws IOException {
        Operation operation = new Operation();
        System.out.println("Welcome!");
        operation.operationSetUp();
        operation.start();
        operation.chooseMovieLoop();
        operation.printWatchlist();
        operation.deleteMovieLoop();
        operation.printWatchlist();
        System.out.println("Bye!");
    }
}
