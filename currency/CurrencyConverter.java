package currency;

/**
 * This file uses methods to validate input, convert the currency, and then 
 * finally output the results in the correct format.
 * 
 * @author Spencer Bouchard 
 */
public class CurrencyConverter {
    
    double EUR_CAD, USD_CAD, JPY_CAD;
    String currencyType;
    Double originalCurr;
    
    /**
     * Constructor that sets the instance constants
     * 
     * @param EUR_CAD Euro to Canadian Dollar rate
     * @param USD_CAD United States Dollar to Canadian Dollar rate
     * @param JPY_CAD Japanese Yen to Canadian Dollar rate
     */
    public CurrencyConverter(double EUR_CAD, double USD_CAD, double JPY_CAD){
        this.EUR_CAD = EUR_CAD;
        this.USD_CAD = USD_CAD;
        this.JPY_CAD = JPY_CAD;
    }
    
    /**
     * Takes 1 string as input and checks it valid, converts and outputs the 
     * result.
     * 
     * @param s Currency to be validated, converted and output
     */ 
    public void convert(String s){
        
        if(checkingParamValid(s) == true) {
              
            double nonroundedValue = convertCurrency(s);
            currencyType = s.substring(s.length()-3);
            originalCurr = Double.parseDouble(s.substring(0, 
                           s.length()-3));
            outputResults(nonroundedValue, currencyType, originalCurr);
        
        }
        
    } // end of convert method
    
    /**
     * Checks that a single argument from the command line is a valid entry
     * for currency conversion. If it is the method returns true, else returns
     * false.
     * 
     * @param arg      single argument from command line array
     * @return valid   If the argument is valid or not
     */
    private boolean checkingParamValid(String arg){
 
        boolean valid = true;
          
        // Variable Declartion/Initialization
        String currencyType = arg.substring(arg.length()-3);
        String cents = arg.substring(arg.length()-5, arg.length()-3);
        String decimal = "N/A";
        
           
        if(arg.length() >= 7) 
        {
            decimal = arg.substring(arg.length()-6,arg.length()-5);   
        }
            
        if(arg.length() < 7) 
        { 
            System.out.println("Error: Invalid input " + arg);
            valid = false; 
        } 
        else if( Character.isDigit(currencyType.charAt(0)) ||
                 Character.isDigit(currencyType.charAt(1)) || 
                 Character.isDigit(currencyType.charAt(2))) 
        {      
            System.out.println("Error: Invalid input " + arg); 
            valid = false;    
        } 
        else if( !currencyType.equalsIgnoreCase("EUR") && 
                 !currencyType.equalsIgnoreCase("USD") && 
                 !currencyType.equalsIgnoreCase("JPY")) 
        { 
            System.out.println("Error: Invalid input " + arg); 
            valid = false;   
        } 
        else if( !Character.isDigit(cents.charAt(0)) || 
                 !Character.isDigit(cents.charAt(1))) 
        {
            System.out.println("Error: invalid input " + arg);
            valid = false; 
        } 
        else if(!decimal.equals(".")) 
        {
            System.out.println("Error: invalid input " + arg); 
            valid = false;   
        } 
        else 
        { // Makes sure all characters to left of decimal are digits
            String dollar = arg.substring(0, arg.length()-6);
            for(int j = 0; j < arg.length()-6; j++)
            {
                if(!Character.isDigit(dollar.charAt(j))) 
                {
                    System.out.println("Error: invalid input " + arg);
                    valid = false;  
                } 
            } 
        } // END if-else-if statements
        
        return valid;
             
    } // end of checkingParamValid method
              
    /*
    * This method receives a valid currency ready to be converted to CND. Once
    * converted from the correct original currency it is returned as a double.
    *
    * @param arg            valid argument ready for conversion
    * @return convertedCurr the currency converted to CND
    */
    private double convertCurrency(String arg){
    
        // Variable Declaration/Initialization
        double totalCurrency = Double.parseDouble(arg.substring(0, 
               arg.length()-3));
        double convertedCurr = 0;
        String currencyType = arg.substring(arg.length()-3);

        if(currencyType.equalsIgnoreCase("EUR")) 
        {
            convertedCurr = totalCurrency * EUR_CAD;
        } else if(currencyType.equalsIgnoreCase("JPY")) 
        {
            convertedCurr = totalCurrency * JPY_CAD;
        } else if(currencyType.equalsIgnoreCase("USD")) 
        {
            convertedCurr = totalCurrency * USD_CAD;
        }
        
        return convertedCurr;
        
    } // end of convertCurrency method
    
    /*
    * Outputs the result in the proper general formatting of: 
    * €#.## EUR is $#.## CAD. where '€' and 'EUR' changes depending on the 
    * currency.
    *
    * @param arg          the converted currency 
    * @param currencyType the original currency type
    * @param original     the original currency value
    */
    public static void outputResults(Double arg, String currencyType, 
            Double original) {
        
        if(currencyType.equalsIgnoreCase("EUR")) 
        {
            System.out.printf("€%.2f EUR is $%.2f CAD.\n", original, arg);
        } else if(currencyType.equalsIgnoreCase("JPY")) 
        {
            System.out.printf("¥%.2f JPY is $%.2f CAD.\n", original, arg);   
        } else if(currencyType.equalsIgnoreCase("USD"))
        {
            System.out.printf("$%.2f USD is $%.2f CAD.\n", original, arg);
        }
        
    } // END method outputResults
     
} // end of public class CurrencyConverter

/* Test Cases
* 1.00USD 1,00USD 1.abUSD 1,a0USD 1.00usd 1.00ABC 1A1B.00USD 1.00UsD 
* 209173.79JPY 60JPY
*/