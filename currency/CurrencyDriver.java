package currency;

import util.Utilities;

/**
 * This is the driver program for a currency converter that converts command
 * line arguments in eur, usd, and jpy to cad.
 *
 * @author Spencer Bouchard
 *
 */
public class CurrencyDriver {
    
    // My information
    public static final String NAME = "Spencer Bouchard";
    public static final String SCHOOL = "Saint Mary's University\n"
            + "Bachelor of Science Undergraduate\n"
            + "Major in Computer Science";
    public static final String EMAIL = "Spencer.Bouchard97@gmail.com";
    
    // Constant conversion rates
    public static final double EUR_CAD = 1.48;
    public static final double USD_CAD = 1.26;
    public static final double JPY_CAD = 0.011;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

        //if there are no command line parameters
        if (args.length == 0) {

            //call the method that displays the info header
            Utilities.displayInfo(NAME, SCHOOL, EMAIL,
                    "\nThis program takes currency amounts in Euros (EUR), "
                    + "US Dollars (USD) and Japanese \nYen (JPY) as "
                    + "command line parameters and converts them to "
                    + "Canadian Dollars (CAD).\nThe correct format for"
                    + " the command line parameters is at least one "
                    + "digit (possibly \nmore) followed by a '.' "
                    + "followed by exactly 2 digits followed by a 3 "
                    + "character\ncurrency code (ignoring upper or "
                    + "lower case). ");

            //call the method to pause
            Utilities.pause("Press enter to end... ");
        } //if there are command line parameters
        else 
        {
            
            Utilities.displayInfo(NAME, SCHOOL, EMAIL, "");
            
            //create a new currencyConverter object 
            //by providing the conversion rates to the constructor
            CurrencyConverter c = 
                    new CurrencyConverter(EUR_CAD, USD_CAD, JPY_CAD);

            //for each command line parameter
            for (String s : args) {
                //call the object's convert method on that parameter.
                c.convert(s);
            }
            //call the method to pause
            Utilities.pause("\nPress enter to end...");
        }

    } // END main

} // END class CurrencyConverter
