package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;

public class TenderMember {
    private static int countOfMembers=0;
    private int index;
    private String name;
    private Double price=0.0;
    private DoubleProperty pricePoint;
    private DoubleProperty priceKPoint;
    private Integer days=0;
    private DoubleProperty daysPoint;
    private DoubleProperty daysKPoint;
    private int prePayPrecent;
    private int prePayDays;
    private int factPayPrecent;
    private int factPayDays;
    private DoubleProperty conditionPoint;
    private DoubleProperty conditionKPoint;
    private DoubleProperty generalPoint;

    public TenderMember()
    {
        countOfMembers++;
        index = countOfMembers;

        pricePoint = new SimpleDoubleProperty(0);
        priceKPoint = new SimpleDoubleProperty(0);
        daysPoint = new SimpleDoubleProperty(0);
        daysKPoint = new SimpleDoubleProperty(0);
        conditionKPoint = new SimpleDoubleProperty(0);
        conditionPoint = new SimpleDoubleProperty(0);
        generalPoint = new SimpleDoubleProperty(0);
    }

    public int getIndex() { return index; }
    public String getName() { return name; }
    public String getPrice() { return price.toString(); }
    public double getPricePoint() { return pricePoint.get(); }
    public double getPriceKPoint() { return priceKPoint.get(); }
    public String getDays() { return days.toString(); };
    public double getDaysPoint() { return daysPoint.get(); }
    public double getDaysKPoint() { return daysKPoint.get(); }
    public double getConditionPoint() { return conditionPoint.get(); }
    public double getConditionKPoint() { return conditionKPoint.get(); }
    public double getGeneralPoint() { return generalPoint.get(); }

    public DoubleProperty pricePointProperty() { return pricePoint; }
    public DoubleProperty priceKPointProperty() { return priceKPoint; }
    public DoubleProperty daysPointProperty() { return daysPoint; }
    public DoubleProperty daysKPointProperty() { return daysKPoint; }
    public DoubleProperty conditionPointProperty() { return conditionPoint; }
    public DoubleProperty conditionKPointProperty() { return conditionKPoint; }
    public DoubleProperty generalPointProperty() { return generalPoint; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setPricePoint(double point) { this.pricePoint.set(point); }
    public void setPriceKPoint(double point) { this.priceKPoint.set(point); }
    public void setDays(int days) { this.days = days; }
    public void setDaysPoint(double point) { this.priceKPoint.set(point); }
    public void setDaysKPoint(double point) { this.priceKPoint.set(point); }
    public void setConditionPoint(double point) { this.conditionPoint.set(point); }
    public void setConditionKPoint(double point) { this.conditionKPoint.set(point); }
    public void setGeneralPoint(double point) { this.generalPoint.set(point); }
}
