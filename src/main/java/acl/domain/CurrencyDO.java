package acl.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sergei on 11.09.2015.
 */
public class CurrencyDO extends DomainObject {
    private static final long serialVersionUID = -3191470358907339109L;

    private String letterCode;
    private String digitCode;
    private String symbol;
    private Boolean defaultCurrency = false;

    private Collection<ExchangeCurrencyRatesDO> rates;

    public CurrencyDO() {
        rates = new ArrayList<>();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    public String getDigitCode() {
        return digitCode;
    }

    public void setDigitCode(String digitCode) {
        this.digitCode = digitCode;
    }

    public Boolean getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Boolean defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Collection<ExchangeCurrencyRatesDO> getRates() {
        return rates;
    }

    public void setRates(Collection<ExchangeCurrencyRatesDO> rates) {
        this.rates = rates;
    }
}
