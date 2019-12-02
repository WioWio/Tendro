import controller.TenderController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

public class Main extends Application {
  private MainView mainView;
  private TenderController tenderController;

  @Override
  public void init() {
    tenderController = new TenderController();
    mainView = new MainView(tenderController);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Tendro");
    primaryStage.setResizable(true);
    primaryStage.setScene(mainView.getScene());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}