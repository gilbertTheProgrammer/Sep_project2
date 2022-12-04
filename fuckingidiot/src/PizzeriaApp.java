
import Network.DatabaseConnection;
import core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;


public class PizzeriaApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {

  ViewHandler viewHandler = new ViewHandler();
  viewHandler.start();

    DatabaseConnection dataBaseConnection = new DatabaseConnection();
    dataBaseConnection.connectionToDataBase("postgres", "postgres", "krisdan29");
  }
}
