package view;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController
{
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler){
    this.viewHandler = viewHandler;
  }

  String AdminName = "MICHAL";
  String AdminPassword = "michal";

  private Parent root;
  private Scene scene;
  private Stage stage;

  @FXML
  private Circle circle1;

  @FXML
  private Circle circle2;

  @FXML
  private Circle circle3;

  @FXML
  protected Button playButton;


  @FXML
  protected Button signInButton;

  @FXML
  protected Button cancelButton;

  @FXML
  protected Button seeMenuButton;

  @FXML
  protected Button loginButton;

  @FXML
  private TextField emailTextField;

  @FXML
  private PasswordField passwordTextField;

  @FXML
  private Label loginMessageLabel;

  public void loginButtonOnAction(ActionEvent event) throws IOException
  {
    if(emailTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){

      loginMessageLabel.setText("Wrong username or password !");
            /*
            validateLogin();

             */
    }else if (emailTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == true){

    loginMessageLabel.setText("Insert username and password :");

    //END OF CHANGING LABEL INFORMATION

  }else if (emailTextField.getText() == AdminName && passwordTextField.getText() == AdminPassword){

    root = FXMLLoader.load(getClass().getResource("ManageView.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }
  }

  public void seeMenuButtonOnAction(ActionEvent event) throws IOException
  {
    root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void cancelButtonOnAction(ActionEvent event)
  {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }

  public void signUpButtonOnAction(ActionEvent event) throws IOException
  {
    root = FXMLLoader.load(getClass().getResource("SignUpView.fxml"));
    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

}
