package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TimePicker extends HBox {
  public TimePicker() {
    super();
    IntegerComboBox hourPicker = new IntegerComboBox(0, 23);
    IntegerComboBox minutePicker = new IntegerComboBox(0, 59);
    Label divLabel = new Label(" : ");
    this.getChildren().addAll(hourPicker, divLabel, minutePicker);
  }
}
