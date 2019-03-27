package com.jaycee.rda;

import com.jaycee.rda.util.Util;

import java.util.Date;

/**
 * Instruction model
 */
public class Instruction {
    private String source;
    private String instId;
    private Date lastTradingDate;
    private Date deliveryDate;
    private String market;
    private String label;
    private String exchangeCode;
    private String tradable;

    public Instruction(){

    }

    public Instruction(String source, String instId, Date lastTradingDate, Date deliveryDate, String market, String label, String exchangeCode, String tradable){
        this.source = source;
        this.instId = instId;
        this.lastTradingDate = lastTradingDate;
        this.deliveryDate = deliveryDate;
        this.market = market;
        this.label = label;
        this.exchangeCode = exchangeCode;
        this.tradable = tradable;

    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public Date getLastTradingDate() {
        return lastTradingDate;
    }

    public void setLastTradingDate(Date lastTradingDate) {
        this.lastTradingDate = lastTradingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTradable() {
        return tradable;
    }

    public void setTradable(String tradable) {
        this.tradable = tradable;
    }

    public String toString(){
        String pipe ="|";
        StringBuilder sb = new StringBuilder();
        return sb.append(pipe)
                .append(Util.padRight("LAST_TRADING_DATE",20))
                .append(pipe)
                .append(Util.padRight("DELIVERY_DATE",20))
                .append(pipe)
                .append(Util.padRight("MARKET", 20))
                .append(pipe)
                .append(Util.padRight("LABEL",20))
                .append(pipe)
                .append(Util.padRight("TRADABLE", 20))
                .append(pipe)
                .append("\n")

                .append(pipe)
                .append(Util.padRight(Util.toStr(lastTradingDate),20))
                .append(pipe)
                .append(Util.padRight(Util.toStr(deliveryDate),20))
                .append(pipe)
                .append(Util.padRight(market, 20))
                .append(pipe)
                .append(Util.padRight(label,20))
                .append(pipe)
                .append(Util.padRight(tradable.equals("")?"TURE":tradable.toUpperCase(), 20))
                .append(pipe)
                .toString();
    }
}
