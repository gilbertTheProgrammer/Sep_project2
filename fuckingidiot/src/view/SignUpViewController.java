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
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpViewController
{
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler){
    this.viewHandler = viewHandler;
  }

  // SOME DATA
  private Parent root;
  private Stage stage;
  private Scene scene;

  @FXML
  protected Button backButton;

  @FXML
  protected Button createAccountButton;

  @FXML
  private TextField firstNameTextField;

  @FXML
  private TextField lastNameTextField;

  @FXML
  private PasswordField passwordTextField;

  @FXML
  private TextField emailTextField;

  @FXML
  private TextField addressTextField;

  @FXML
  private TextField phoNumberTextField;

  @FXML
  private Label createMessageLabel;



  //BACK BUTTON
  public void backButtonOnAction(ActionEvent event) throws IOException
  {

    root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public void createCustomerOnAction() throws SQLException,IOException {


    //CHANGING LABEL INFORMATION :
    if(firstNameTextField.getText().isBlank() == true  && lastNameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == true && emailTextField.getText().isBlank() == true && addressTextField.getText().isBlank() == true && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Insert information about customer please");

    }
    if(firstNameTextField.getText().isBlank() == true  && lastNameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == true && emailTextField.getText().isBlank() == true && addressTextField.getText().isBlank() == false && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Missing information about customer");
    }

    if(firstNameTextField.getText().isBlank() == true  && lastNameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == true && emailTextField.getText().isBlank() == false && addressTextField.getText().isBlank() == true && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Missing information about customer");
    }

    if(firstNameTextField.getText().isBlank() == true  && lastNameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == false && emailTextField.getText().isBlank() == true && addressTextField.getText().isBlank() == true && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Missing information about customer");
    }

    if(firstNameTextField.getText().isBlank() == true  && lastNameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == true && emailTextField.getText().isBlank() == true && addressTextField.getText().isBlank() == true && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Missing information about customer");
    }

    if(firstNameTextField.getText().isBlank() == false  && lastNameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == true && emailTextField.getText().isBlank() == true && addressTextField.getText().isBlank() == true && phoNumberTextField.getText().isBlank() == true) {

      createMessageLabel.setText("Missing information about customer");
    }


    //END OF LABEL CHANGING



  }


  //CREATING CUSTOMER AND INSERTING DATA TO DATABASE
  @FXML
  public User createUser(ActionEvent event) throws SQLException {

    String name = firstNameTextField.getText();
    String lastName = lastNameTextField.getText();
    String address = addressTextField.getText();
    String email = emailTextField.getText();
    String phoneNumber = phoNumberTextField.getText();
    String password = passwordTextField.getText();

    try(Connection connection = DriverManager.getConnection ("jdbc:postgresql://localhost:5433/postgres?currentSchema=pizzeria" , "postgres","krisdan29")) {
      String user = "user";
      PreparedStatement statement = connection.prepareStatement("INSERT INTO "+'"'+user+'"'+" (name,last_name,email,password,address,phone_nr) VALUES(?,?,?,?,?,?);");

      statement.setString(1,name);
      statement.setString(2,lastName);
      statement.setString(3,email);
      statement.setString(4,address);
      statement.setString(5,phoneNumber);
      statement.setString(6,password);

      statement.executeUpdate();


      if (firstNameTextField.getText().isBlank() == false && lastNameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false && emailTextField.getText().isBlank() == false && addressTextField.getText().isBlank() == false && phoNumberTextField.getText().isBlank() == false){
        firstNameTextField.getText();
        lastNameTextField.getText();
        addressTextField.getText();
        emailTextField.getText();
        phoNumberTextField.getText();
        passwordTextField.getText();
        System.out.println("user added to database");
      }else {
        System.out.println("Failed");
      }

      return new User (name,lastName,email,address,phoneNumber,password);

    }

  }
}
