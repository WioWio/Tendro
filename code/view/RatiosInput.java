package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class RatiosInput extends HBox {
  private final static double STANDART_RATIO_WIDTH = 40;

  private TextField priceK;
  private TextField daysK;
  private TextField conditionK;

  public RatiosInput(){
    super();

    Label ratioLabel = new Label("Коэффициенты:  ");
    Label priceLabel = new Label("цены ");
    Label daysLabel = new Label(" срока выполнения ");
    Label conditionLabel = new Label(" условий оплаты ");
    priceK = new TextField();
    priceK.setText("0.6");
    daysK = new TextField();
    daysK.setText("0.1");
    conditionK = new TextField();
    conditionK.setText("0.3");
    priceK.setPrefWidth(STANDART_RATIO_WIDTH);
    daysK.setPrefWidth(STANDART_RATIO_WIDTH);
    conditionK.setPrefWidth(STANDART_RATIO_WIDTH);

    super.getChildren().addAll(ratioLabel,priceLabel,priceK,daysLabel,daysK,
            conditionLabel,conditionK);
  }

  public double getPriceK(){ return Double.parseDouble(priceK.getText()); }
  public double getDaysK() { return Double.parseDouble(daysK.getText()); }
  public double getConditionK() {return Double.parseDouble(conditionK.getText()); }
}
