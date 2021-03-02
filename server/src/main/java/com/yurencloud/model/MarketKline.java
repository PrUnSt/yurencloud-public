package com.yurencloud.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class MarketKline implements Serializable {
    private Date time;
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     *
     */
    private String kline;

    public String getKline() {
        return kline;
    }

    public void setKline(String kline) {
        this.kline = kline;
    }
}