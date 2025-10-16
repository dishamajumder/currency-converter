import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The main class for the Currency Converter application.
 * This class handles user input and displays the output.
 */
public class Main {

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        // Display supported currencies
        System.out.println("Supported currencies: " + converter.getSupportedCurrencies());

        try {
            // Get the currency to convert from
            System.out.print("Enter the currency code you want to convert from (e.g., USD): ");
            String fromCurrency = scanner.next().toUpperCase();

            // Get the currency to convert to
            System.out.print("Enter the currency code you want to convert to (e.g., INR): ");
            String toCurrency = scanner.next().toUpperCase();

            // Get the amount to convert
            System.out.print("Enter the amount to convert: ");
            double amount = scanner.nextDouble();

            // Perform the conversion
            double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

            // Display the result, formatted to two decimal places
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid number for the amount.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please make sure you are using one of the supported currency codes.");
        } finally {
            scanner.close(); // Important to close the scanner
        }
    }
}
