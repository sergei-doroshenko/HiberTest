package acl.domain;

import acl.domain.CurrencyDO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sergei on 11.09.2015.
 */
public class ExchangeCurrencyRatesDO extends DomainObject {
    private static final long serialVersionUID = 6647846220963366446L;

    private Date date;
    private CurrencyDO currencyFrom;
    private CurrencyDO currencyTo;
    private BigDecimal exchangeRate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CurrencyDO getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(CurrencyDO currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public CurrencyDO getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(CurrencyDO currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
