package model;

public class PayCondition {
    private int prePayPrecent;
    private int prePayDays;
    private int factPayPrecent;
    private int factPayDays;

    public void setPayCondition(int prePayPrecent, int prePayDays, int factPayDays){
        this.prePayPrecent = prePayPrecent;
        this.prePayDays = prePayDays;
        this.factPayDays = factPayDays;
        this.factPayPrecent = 100 - prePayPrecent;
    }

    public String toString(){
        String condition="";
        if (prePayPrecent!=0){
            condition += prePayPrecent + "% аванс в течение " + prePayDays + "дн.";
            if (factPayPrecent!=0){
                condition += ",\n";
            }
        }
        if (factPayPrecent!=0){
            condition+= factPayPrecent + " по факту в течение " + factPayDays + "дн.";
        }
        return condition;
    }
}
