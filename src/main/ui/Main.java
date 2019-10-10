package ui;

import model.CLOperation;
import model.DLOperation;
import model.WLOperation;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        WLOperation wloperation = new WLOperation();
        DLOperation dloperation = new DLOperation();
        CLOperation cloperation = new CLOperation();
        System.out.println("Welcome!");
        cloperation.operationSetUp();
        cloperation.chooseMovieLoop();
        wloperation.operationSetUp();
        wloperation.start();
        wloperation.chooseMovieLoop();
        wloperation.printNameList();
        wloperation.deleteMovieLoop();
        wloperation.printNameList();
        dloperation.operationSetUp();
        dloperation.start();
        dloperation.chooseMovieLoop();
        dloperation.printNameList();
        System.out.println("Bye!");
    }
}
