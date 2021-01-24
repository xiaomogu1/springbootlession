
package com.staxrt.tutorial.repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CurrencyForeign {

    @SerializedName("rates")
    @Expose
    private Rates rates;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("date")
    @Expose
    private String date;

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rates", rates).append("base", base).append("date", date).toString();
    }

}
