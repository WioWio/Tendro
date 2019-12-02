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
    private double priceKPoint;
    private int days;
    private double daysPoint;
    private double daysKPoint;
    private int prePayPrecent;
    private int prePayDays;
    private int factPayPrecent;
    private int factPayDays;
    private double conditionPoint;
    private double conditionKPoint;

    public TenderMember()
    {
        countOfMembers++;
        index = countOfMembers;
        pricePoint = new SimpleDoubleProperty(0);
    }

    public int getIndex() { return index; }
    public String getName() { return name; }
    public String getPrice() { return price.toString(); }
    public Double getPricePoint() { return pricePoint.get(); }
    public DoubleProperty pricePointProperty() { return pricePoint;}
    public double getPriceKPoint() { return priceKPoint; }
    public int getDays() { return days; };
    public double getDaysPoint() { return daysPoint; }
    public double getDaysKPoint() { return daysKPoint; }
    public void setPrice(double price) { this.price = price; }
    public void setPricePoint(Double point) { this.pricePoint.set(point); }
}
