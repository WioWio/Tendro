package view;

import controller.TenderController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.TenderMember;

public class MainView {
    TenderController tenderController;

    static final double STANDART_WIDTH = 600;
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

    private Button addButton;
    private Button countButton;

    private TenderTabel tenderTabel;

    public MainView(TenderController tenderController){
        this.tenderController = tenderController;

        productLabel = new Label("prod");
        dateOpeningLabel = new Label("dateOp");

        productField = new TextField();

        tenderTabel = new TenderTabel(tenderController);

        addButton = new Button("+");
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tenderController.addNewTenderMember();
                //tenderTabel.refresh();
            }
        });

        countButton = new Button("count");
        countButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tenderController.countWinner();
            }
        });

        mainLayout = new VBox();
        mainLayout.getChildren().setAll(productLabel,productField,dateOpeningLabel,tenderTabel,
            addButton,countButton);

        scene = new Scene(mainLayout, STANDART_WIDTH, STANDART_HEIGHT);
    }

    public Scene getScene(){
        return this.scene;
    }


}
