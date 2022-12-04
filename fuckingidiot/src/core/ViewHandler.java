package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene mainScene;


  public ViewHandler(){
  stage = new Stage();

  }

  public void start(){
    openMainView();
  }

  private void openMainView()
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/MainView.fxml"));
      Parent root = loader.load();

      MainViewController mainController = loader.getController();
      mainController.init(this);

      mainScene = new Scene(root);
      stage.setScene((mainScene));
      stage.setTitle("Pizzeria Home");
      stage.show();


    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

}

