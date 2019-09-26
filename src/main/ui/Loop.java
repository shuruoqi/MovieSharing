package ui;

public class Loop {

    //EFFECTS: add loan print or quit base on user's choice
    public void operationLoop() {
        Operation operation = new Operation();
        operation.operationSetUp();

        while (operation.loopState) {
            operation.chooseMovie();
            operation.exit();
        }
    }
}
