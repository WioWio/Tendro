package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainView {
    static final double STANDART_WIDTH = 400;
    static final double STANDART_HEIGHT = 500;

    private Scene scene;
    private VBox mainLayout;
    private Label productLabel;
    private Label dateOpeningLabel;
    private Label ratioLabel;
    private Label priceLabel;
    private Label dateDeliveryLabel;
    private Label payConditionsLabel;
    private TextField productField;

    private TenderTabel tenderTabel;

    public MainView(){
        productLabel = new Label("prod");
        dateOpeningLabel = new Label("dateOp");

        productField = new TextField();

        tenderTabel = new TenderTabel();

        mainLayout = new VBox();
        mainLayout.getChildren().setAll(productLabel,productField,dateOpeningLabel,tenderTabel);

        scene = new Scene(mainLayout, STANDART_WIDTH, STANDART_HEIGHT);
    }

    public Scene getScene(){
        return this.scene;
    }
}
