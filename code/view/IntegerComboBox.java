package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class IntegerComboBox extends ComboBox<Integer> {
  private final static double STANDART_WIDTH = 20;

  public IntegerComboBox(int fromValue, int toValue){
    super();
    super.setPrefWidth(STANDART_WIDTH);
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int i=fromValue;i<=toValue;i++){
      arrayList.add(i);
    }
    ObservableList<Integer> list = FXCollections.observableArrayList(arrayList);
    super.setItems(list);
  }
}
