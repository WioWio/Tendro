package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.PayCondition;

public class PayConditionSelector extends Application {
  private static final int STANDART_WIDTH = 100;
  private static final int STANDART_HEIGHT = 100;

  private String memberName;
  private PayCondition payCondition;

  private boolean prePay;

  public PayConditionSelector(String memberName, PayCondition payCondition){
    this.memberName = memberName;
    this.payCondition = payCondition;
  }

  @Override
  public void init(){

  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle(memberName);
    stage.setResizable(false);

    GridPane gridPane = new GridPane();

    CheckBox prePayCheckBox = new CheckBox();
    prePayCheckBox.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
      prePay = newValue;
      if (!newValue){

      }
    });
    gridPane.add(prePayCheckBox,0,0);

    final Label prePayLabel = new Label("аванс");
    gridPane.add(prePayLabel,0,1);

    TextField prePayPrecent = new TextField();
    prePayPrecent.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER){
        int iPrecent = Integer.parseInt(prePayPrecent.getText());
        if (iPrecent>100) { iPrecent = 100; }
        if (iPrecent <= 0) { iPrecent = 1; }
        String sPrecent ="";
        sPrecent+=iPrecent;
        prePayPrecent.setText(sPrecent);
      }
    });
    gridPane.add(prePayPrecent,0,2);

    Label precentLabel = new Label ("%");
    gridPane.add(precentLabel,0,3);

    TextField prePayDays = new TextField();
    prePayDays.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER){
        reformDaysField(prePayDays);
      }
    });
    gridPane.add(prePayPrecent,0,4);

    Label daysLabel = new Label("дней");
    gridPane.add(daysLabel,0,5);

    TextField factPayDays = new TextField();
    factPayDays.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode() == KeyCode.ENTER){
        reformDaysField(factPayDays);
      }
    });
    gridPane.add(factPayDays,1,4);

    Button saveButton = new Button("Save");
    saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        payCondition.setPayCondition(Integer.parseInt(prePayPrecent.getText()),
                Integer.parseInt(prePayDays.getText()),Integer.parseInt(factPayDays.getText()));
        Platform.exit();
      }
    });
    gridPane.add(saveButton,2,2);

  }

  void reformDaysField (TextField textField){
    int iDays = Integer.parseInt(textField.getText());
    if (iDays<=0) { iDays = 1; }
    String sDays ="";
    sDays+=iDays;
    textField.setText(sDays);
  }
}
