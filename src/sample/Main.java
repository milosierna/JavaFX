package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    Stage stage = new Stage();

    ArrayList<Control> controls = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();

        Scene scene = new Scene(root, 1280, 720);


        stage.setTitle("Mac");
        stage.setScene(scene);
        stage.show();



        Control control = new Control(ControlType.BUTTON, "you can click a button");
        controls.add(control);
        Control control2 = new Control(ControlType.TEXT_FIELD, "you write in textfield");
        controls.add(control2);
        Control control3 = new Control(ControlType.TEXT, "you can read a text");
        controls.add(control3);

        tableLayout();
    }
    public void tableLayout(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(40);


        TableView<Control> tableViewControls = new TableView<>();

        TableColumn<Control, ControlType> columnTypes= new TableColumn<>("Control types");
        columnTypes.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Control,String> columnDescription= new TableColumn<>("description");
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));



        tableViewControls.getColumns().addAll(columnTypes,columnDescription);

        tableViewControls.getItems().addAll(controls);

        TextField textFieldSearch = new TextField();
        textFieldSearch.setTooltip(new Tooltip("type sth to search"));
        textFieldSearch.setPromptText("\uD83D\uDD0D search");
        textFieldSearch.setMaxWidth(500);
        textFieldSearch.setOnAction(event ->  {
            tableViewControls.getItems().clear();
            if (textFieldSearch.getText() == null || textFieldSearch.getText().equals(" ")) {
                tableViewControls.getItems().addAll(controls);
            }
            else {
                tableViewControls.getItems().addAll( Controls.filtered(controls, textFieldSearch.getText()));
            }

        });

        root.getChildren().addAll(textFieldSearch, tableViewControls);



        stage.getScene().setRoot(root);





    }

    public static void main(String[] args) {
        launch(args);
    }
}
