package spsmb.sqlite;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowCovid extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a TableView with a list of persons
        TableView<Covid> table = new TableView<>(CovidTableUtil.getCovidList());

        // Add columns to the TableView
        table.getColumns().addAll(
                CovidTableUtil.getDatum(),
                CovidTableUtil.getPrumer(),
                CovidTableUtil.getMuzi(),
                CovidTableUtil.getZeny(),
                CovidTableUtil.getCelkem()
        );
        VBox root = new VBox(table);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simplest TableView");
        stage.show();
    }
}
