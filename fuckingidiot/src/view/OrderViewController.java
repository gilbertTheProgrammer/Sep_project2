package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderViewController
{
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    protected Button backButton;








    //BACK BUTTON
    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void orderButtonOnAction(ActionEvent event) throws IOException {



    }





}
