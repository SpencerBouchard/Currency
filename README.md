# CurrencyConverter
This program takes currency amounts in Euros (EUR), US Dollars (USD) and Japanese Yen (JPY) as command line parameters and converts them to Canadian Dollars (CAD).

The correct format for the command line parameters is at least one digit (possibly more) followed by a '.' followed by exactly 2 digits followed by a 3 character currency code (ignoring upper or lower case).<br>

Some examples of valid parameters are:<br>

0.34USD<br>
30.00eur<br>
55768.34jPY<br>

Some examples of invalid parameters are:<br>

.34USD<br>
30EUR<br>
5768.931JPY<br>

This program checks if the parameters are valid and it does not crash if they are not valid.<br>

The min length of a valid input is 7<br>
A valid input must end with one of the 3 character codes (EUR,USD,JPY)<br>
The 3 characters before that must be a decimal point then two digits<br>
All the characters before that, no matter how many there are need to be digits<br>
 
This program has 2 modes of operation:<br>

1) If no command line parameters are given the program displays the normal information header as well as instructions for the user on the correct usage of the program (how command line parameters should be formatted to be valid). The program then pauses before ending.<br>

Example with no command line parameters:<br>

Lastname, Firstname<br>

Description of the program<br>
Including instructions for use<br>

Press enter to end...<br>

2) If one or more command line parameter(s) is provided the program will not display the information header and will output the converted amounts one per line. If any of the inputs are invalid then the corresponding line will display an error message but the program will continue with converting the next parameter until all have been converted. The program then pauses before ending.<br>

Example with command line parameters: 12.50EUR 125.00USD 13EUR 15.67USD 50000.00JPY 1.00JPY<br>

€12.50 EUR is $19.00 CAD.<br>
$125.00 USD is $161.25 CAD.<br>
Error: invalid input 13EUR.<br>
$15.67 USD is $20.21 CAD.<br>
¥50000.00 JPY is $550.00 CAD.<br>
¥1.00 JPY is $0.01 CAD.<br>

Press enter to end...<br>

For the format of the output, both the input amount and the converted amount are displayed with the correct currency symbol and exactly 2 places after the decimal point. Also the values are rounded correctly to those 2 digits after the decimal point using printf.<br>

The program uses the following exchange rates from the day the program was coded:<br>
1 EUR is 1.52 CAD<br>
1 USD is 1.29 CAD<br>
1 JPY is 0.011 CAD<br>
