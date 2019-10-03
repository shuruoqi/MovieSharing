package ui;

import model.MLOperation;

import java.io.IOException;

public class Machine {

    public static void main(String[] args) throws IOException {
        MLOperation wloperation = new WLOperation();
        System.out.println("Welcome!");
        wloperation.operationSetUp();
        wloperation.start();
        wloperation.chooseMovieLoop();
        wloperation.printNameList();
        wloperation.deleteMovieLoop();
        wloperation.printNameList();
        System.out.println("Bye!");
    }
}
