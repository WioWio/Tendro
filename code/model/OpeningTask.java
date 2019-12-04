package model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.TimerTask;

public class OpeningTask extends TimerTask {
  private String tenderName;

  public OpeningTask(String tenderName){
    this.tenderName = tenderName;
  }

  @Override
  public void run() {
    String text = "Через 15 минут вскрытие пакетов по тендеру " + tenderName;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText(text);
    alert.getButtonTypes().set(1, ButtonType.OK);
    alert.showAndWait();
  }
}
