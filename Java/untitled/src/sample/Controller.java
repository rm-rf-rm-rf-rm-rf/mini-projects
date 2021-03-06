package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

public class Controller {
    private Task<ObservableList<String>> task;

    public void initialize(){
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                return FXCollections.observableArrayList(
                  "Tim Buchalka",
                  "Bill Rogers",
                  "Jack Jill",
                  "Joan Andrews",
                  "Mary Johnson",
                  "Bob Mcdonald"
                );
            }
        };
    }

    @FXML
    public void buttonPressed(){
        new Thread(task).start();
    }
}
