import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tendro");
        primaryStage.setResizable(true);
        primaryStage.setScene(mainView.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}