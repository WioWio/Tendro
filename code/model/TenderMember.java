package model;

public class TenderMember {
    private static int countOfMembers=0;
    private int index;
    private String name;
    private double price;
    private double pricePoint;
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
    }

    public int getIndex() { return index; };
    public String getName() { return name; };
    public double getPrice() { return price; };
    public double getPricePoint() { return pricePoint; };
    public double getPriceKPoint() { return priceKPoint; };
    public int getDays() { return days; };
    public double getDaysPoint() { return daysPoint; };
    public double getDaysKPoint() { return daysKPoint; };
    public void setPrice(double price) { this.price = price; };
    public void setPricePoint(double point) { this.pricePoint = point; };
}
