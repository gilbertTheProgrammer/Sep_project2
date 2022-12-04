package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuViewController<pizzas> implements Initializable
{
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    protected Button backButton;

    @FXML
    protected Button cancelButton;

    @FXML
    protected Button orderButton;

    @FXML
    protected ListView<String> pizzaMenu;

    String[] pizzas = {"1. Margherita (Pizza Sauce, cheese)",
                        "2. Hawaii (Pizza Sauce, cheese, ham, pineapple)",
                        "3. Italiano (Pizza Sauce, cheese, ham, spaghetti, meat sauce)"};

    @FXML
    protected ListView<String> drinkMenu;

    String[] drinks = {"1. Coca-cola",
                        "2. Fanta",
                        "3. Sprite"};
    @FXML
    protected ListView<String> extraMenu;

    String[] extra = {"1. Chilli cheese",
                        "2. Onions",
                            "3. Salat"};

    @FXML
    protected TextArea summaryWindow;

    @FXML
    protected  Button clearButton;



    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void backButtonOnAction(ActionEvent event) throws IOException{


        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void orderButtonOnAction(ActionEvent event) throws IOException{



        root = FXMLLoader.load(getClass().getResource("OrderView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @Override public void initialize(URL url, ResourceBundle resourceBundle)
    {
        pizzaMenu.getItems().addAll(pizzas);
        drinkMenu.getItems().addAll(drinks);
        extraMenu.getItems().addAll(extra);

        summaryWindow.setWrapText(true);

    }

    public void selectedPizza()
    {
        summaryWindow.appendText(pizzaMenu.getSelectionModel().getSelectedItem());

    }
    public void selectedDrink()
    {
        summaryWindow.appendText(drinkMenu.getSelectionModel().getSelectedItem());

    }
    public void selectedExtra()
    {
        summaryWindow.appendText(extraMenu.getSelectionModel().getSelectedItem());

    }

    public void clearSummary(){
        summaryWindow.clear();
    }


}
