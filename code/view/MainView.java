package view;

import controller.TenderController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.TenderMember;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainView {
    private TenderController tenderController;

    private static final double STANDART_WINDOW_WIDTH = 970;
    private static final double STANDART_WINDOW_HEIGHT = 550;
    private static final double STANDART_DATE_PICKER_WIDTH = 100;
    private static final double STANDART_NAME_WIDTH = 450;
    private static final double STANDART_SPACE = 10;

    private Scene scene;

  private TenderTabel tenderTabel;

    public MainView(TenderController tenderController){
        this.tenderController = tenderController;
        this.buildScene();
    }

    private void buildScene(){
      Label productLabel = new Label("Название тендера: ");
      TextField productField = new TextField();
      productField.setPrefWidth(STANDART_NAME_WIDTH);
      productField.setOnKeyPressed(keyEvent -> {
        if (keyEvent.getCode() == KeyCode.ENTER){
          tenderController.setProductName(productField.getText());
        }
      });
      HBox productName = new HBox();
      productName.getChildren().setAll(productLabel,productField);

      Label dateOpeningLabel = new Label("Вскрытие пакетов: ");
      DatePicker calendarPicker = new DatePicker(LocalDate.of(2019,11,4));
      calendarPicker.setValue(LocalDate.now());
      calendarPicker.setPrefWidth(STANDART_DATE_PICKER_WIDTH);
      TimePicker timePicker = new TimePicker();
      HBox openingDate = new HBox();
      openingDate.setSpacing(STANDART_SPACE);
      openingDate.getChildren().addAll(dateOpeningLabel,calendarPicker,timePicker);

      RatiosInput ratiosInput = new RatiosInput();

      tenderTabel = new TenderTabel(tenderController);
      tenderTabel.setMaxWidth(STANDART_WINDOW_WIDTH - STANDART_SPACE*3);
      tenderTabel.setMaxHeight(STANDART_WINDOW_HEIGHT/2);

      Button addButton = new Button("+");
      addButton.setShape(new Circle(STANDART_SPACE));
      addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
          tenderController.addNewTenderMember();
        }
      });

      Button editCondition = new Button("Изменить условия оплаты");
      editCondition.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
          tenderController.conditionEdit();
        }
      });

      VBox winners = new VBox();
      Background background = new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,
              new Insets(0)));
      winners.setBackground(background);
      winners.setMaxWidth(STANDART_WINDOW_WIDTH/2);

      Button countButton = new Button("Посчитать");
      countButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
          if (tenderController.getTenderMemberList().size() == 0) { return; }

          tenderController.setRatio(ratiosInput);
          tenderController.countWinner();
          winners.getChildren().clear();
          HBox winner1 = new HBox();
          winner1.getChildren().addAll(new Label("ПОБЕДИТЕЛЬ 1: "),
                  new Label(tenderController.getWinner1().getName()));
          winners.getChildren().add(winner1);
          if (tenderController.getWinner2()!=null) {
            HBox winner2 = new HBox();
            winner2.getChildren().addAll(new Label("ПОБЕДИТЕЛЬ 2: "),
                    new Label(tenderController.getWinner2().getName()));
            winners.getChildren().add(winner2);
          }
        }
      });

      HBox buttons = new HBox();
      buttons.setSpacing(STANDART_SPACE);
      buttons.getChildren().setAll(addButton,editCondition,countButton);

      VBox mainLayout = new VBox();
      background = new Background(new BackgroundFill(Color.GHOSTWHITE,CornerRadii.EMPTY,
              new Insets(10)));
      mainLayout.setBackground(background);
      mainLayout.setSpacing(STANDART_SPACE);
      mainLayout.setPadding(new Insets(STANDART_SPACE));
      mainLayout.getChildren().setAll(productName, openingDate, ratiosInput, tenderTabel,
              buttons,winners);
      mainLayout.relocate(STANDART_SPACE,STANDART_SPACE);
      scene = new Scene(mainLayout, STANDART_WINDOW_WIDTH, STANDART_WINDOW_HEIGHT, Color.GHOSTWHITE);
    }

    public Scene getScene(){
        return this.scene;
    }

}
