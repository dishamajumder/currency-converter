import java.util.HashMap;
import java.util.Map;

/**
 * Handles the logic for currency conversion.
 * This class stores exchange rates and performs the conversion.
 */
public class CurrencyConverter {

    private Map<String, Double> exchangeRates;

    /**
     * Constructor to initialize the CurrencyConverter with some default exchange rates.
     * Rates are relative to USD (United States Dollar).
     */
    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // As of late 2023, these are example rates.
        // In a real-world application, you would fetch these from an API.
        exchangeRates.put("USD", 1.00);    // United States Dollar
        exchangeRates.put("EUR", 0.94);    // Euro
        exchangeRates.put("GBP", 0.82);    // British Pound
        exchangeRates.put("JPY", 149.83);  // Japanese Yen
        exchangeRates.put("INR", 83.25);   // Indian Rupee
        exchangeRates.put("AUD", 1.57);    // Australian Dollar
        exchangeRates.put("CAD", 1.37);    // Canadian Dollar
        exchangeRates.put("CHF", 0.90);    // Swiss Franc
    }

    /**
     * Returns the supported currency codes.
     * @return A set of supported currency codes.
     */
    public java.util.Set<String> getSupportedCurrencies() {
        return exchangeRates.keySet();
    }

    /**
     * Converts an amount from one currency to another.
     *
     * @param amount      The amount of money to convert.
     * @param fromCurrency The currency code to convert from (e.g., "USD").
     * @param toCurrency   The currency code to convert to (e.g., "EUR").
     * @return The converted amount.
     * @throws IllegalArgumentException if the currency codes are not supported.
     */
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code provided.");
        }

        // 1. Convert the 'from' currency to USD (the base currency)
        double amountInUsd = amount / exchangeRates.get(fromCurrency);

        // 2. Convert the USD amount to the 'to' currency
        double convertedAmount = amountInUsd * exchangeRates.get(toCurrency);

        return convertedAmount;
    }
}
