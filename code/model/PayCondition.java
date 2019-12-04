package model;

import javafx.beans.property.StringProperty;

public class PayCondition {
  private TenderMember tenderMember;
    private int prePayPrecent=0;
    private int prePayDays=0;
    private int factPayPrecent=0;
    private int factPayDays=0;

    public PayCondition(TenderMember tenderMember){
      this.tenderMember = tenderMember;
    }

    public void setPayCondition(int prePayPrecent, int prePayDays, int factPayDays){
        this.prePayPrecent = prePayPrecent;
        this.prePayDays = prePayDays;
        this.factPayDays = factPayDays;
        this.factPayPrecent = 100 - prePayPrecent;
        tenderMember.setCondition(toString());
    }

    public int getPrePayPrecent() { return prePayPrecent; }
    public int getPrePayDays() { return prePayDays; }
    public int getFactPayPrecent() { return factPayPrecent; }
    public int getFactPayDays() { return factPayDays; }

    public String toString(){
        String condition="";
        if (prePayPrecent!=0){
            condition += prePayPrecent + "% аванс в течение " + prePayDays + "дн.";
            if (factPayPrecent!=0){
                condition += ",\n";
            }
        }
        if (factPayPrecent!=0){
            condition+= factPayPrecent + "% по факту в течение " + factPayDays + "дн.";
        }
        return condition;
    }
}
