package ui;

import exception.ReputationException;
import exception.VipException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ReputationException, VipException {
        ListOperation listOperation = new ListOperation();
        listOperation.start();
    }
}
