package model;

import java.io.IOException;

public interface MLOperation {

    void operationSetUp();

    void start() throws IOException;

    void printNameList();

    void chooseMovieLoop();

    void deleteMovieLoop() throws IOException;
}
