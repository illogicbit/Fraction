import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionTester implements ActionListener{

    MixedFraction[] mixedFraction = new MixedFraction[2];
    String equation = "";
    public static void main(String[] args) {
        FractionGUI fractionFrame = new FractionGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnInput = (JButton) e.getSource();
        equation += btnInput.getText();

    }

    //Method to identify the fraction/s in the equations (Max of 2)
    public void identifyPartsAndValidate(String equation){

        //Create a regex search pattern and matcher
        Pattern fractionPattern = Pattern.compile("Sf\\(-*[0-9]+/-*[0-9]+\\)|Mf\\(-*[0-9]+\\(-*[0-9]+/-*[0-9]+\\)\\)");
        Matcher findFractions = fractionPattern.matcher(equation);

        //Loop through the equation to find substring of text similar to the identified pattern, then check for its length to determine whether it's a simple or mixed fraction.
        int index = 0;
        while (findFractions.find()) {
            //Separate the fraction into individual signed integers and create a new MixedFraction class to be stored in an array.
            String[] fractionToSeparate = findFractions.group().replaceAll("[SMf]", "").replaceAll("[()/]", " ").trim().split(" ");
            if (fractionToSeparate.length > 2) {
                mixedFraction[index] = new MixedFraction(Integer.parseInt(fractionToSeparate[0]), new Fraction(Integer.parseInt(fractionToSeparate[1]), Integer.parseInt(fractionToSeparate[2])));
            } else {
                mixedFraction[index] = new MixedFraction(new Fraction(Integer.parseInt(fractionToSeparate[0]), Integer.parseInt(fractionToSeparate[1])));
            }
            index++;
        }
    }

    public void arithmeticOperations(String equation){
        identifyPartsAndValidate(equation);

        //Identify the operator using a regex pattern matcher.
        char operator = ' ';
        Pattern operatorPattern = Pattern.compile("[-+/*]+Mf|[-+/*]+Sf");
        Matcher findOperator = operatorPattern.matcher(equation);

        if(findOperator.find())
            operator = findOperator.group().replaceAll("[SMf]", "").charAt(0);

        //Input other method calls and functions after this comment. This guarantees that the input is validated to avoid errors.

        //Put arithmetic operations below.
        switch (operator){
            //Print statements for testing.
            case '+':
                System.out.println(mixedFraction[0].addition(mixedFraction[1]));
                break;
            case '-':
                System.out.println(mixedFraction[0].subtraction(mixedFraction[1]));
                break;
            case '/':
                System.out.println(mixedFraction[0].divideBy(mixedFraction[1]));
                break;
            case '*':
                System.out.println(mixedFraction[0].multiplyBy(mixedFraction[1]));
                break;
            default:

        }
    }

    public void fractionToDouble(String equation) throws InvalidInputException {
        identifyPartsAndValidate(equation);
        //Print statement for testing
        System.out.println(mixedFraction[0].toDouble());
        //Code to convert fraction to double.
    }

    public void reduceFraction(String equation) throws InvalidInputException {
        identifyPartsAndValidate(equation);
        //Print statement for testing.
        System.out.println(mixedFraction[0].reduce());
        //Code to reduce fraction.
    }

    //Start of custom exceptions
    public class InvalidInputException extends Exception {
        public InvalidInputException(String errorMessage) {
            super(errorMessage);
        }
    }

}
