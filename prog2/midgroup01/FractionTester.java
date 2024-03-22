package prog2.midgroup01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import prog2.prelimgroup.Fraction;

public class FractionTester implements ActionListener{

    private Fraction[] fractions = new Fraction[2];
    private static JTextField frac1;
    private static JTextField frac2;
    private static JTextField displayRes;
    private static JTextField displayDbl;
    private static FractionGUI calculator;

    public static void main(String[] args) {
        calculator = new FractionGUI();
        frac1 = calculator.getFraction1();
        frac2 = calculator.getFraction2();
        displayRes = calculator.getDisplayRes();
        displayDbl = calculator.getDisplayDbl();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        try {
            //Check if the button pressed is an operator or the clear button.
            if (btn.getText().equals("Clear")) {
                //Empties the text fields.
                frac1.setText("");
                frac2.setText("");
                displayRes.setText("");
                displayDbl.setText("");

            } else {

                //Identify the fractions in the text fields by calling the identifyFraction() method.
                fractions[0] = identifyFraction(frac1.getText());
                fractions[1] = identifyFraction(frac2.getText());

                MixedFraction fraction1 = (MixedFraction) fractions[0];
                MixedFraction fraction2 = (MixedFraction) fractions[1];

                //Prints the
                System.out.println(fraction1);
                System.out.println(fraction2);

                MixedFraction result = null;

                switch (btn.getText()) {
                    case "+":
                        result = fraction1.addition(fraction2);
                        break;
                    case "-":
                        result = fraction1.subtraction(fraction2);
                        break;
                    case "*":
                        result = fraction1.multiplyBy(fraction2);
                        break;
                    case "÷":
                        result = fraction1.divideBy(fraction2);
                        break;
                }

                if (result.getWholePart() == 0) {
                    displayRes.setText(result.toFraction().toString());
                    displayDbl.setText(String.valueOf(result.toFraction().toDouble()));
                }
                if (result.getNumerator() == 0) {
                    displayRes.setText(String.valueOf(Math.round(result.toDouble())));
                    displayDbl.setText(String.valueOf(result.toFraction().toDouble()));
                    return;
                }
                displayRes.setText(result.reduce().toString());
                displayDbl.setText(String.valueOf(result.toFraction().toDouble()));
            }

        } catch (NullPointerException error) {
            JOptionPane.showMessageDialog(calculator, "One or more fraction(s) is/are invalid!");
        } catch (ArithmeticException error) {
            JOptionPane.showMessageDialog(calculator, "Denominator cannot be zero!");
        } catch (Exception error){
            JOptionPane.showMessageDialog(calculator, "Error!");
        }

    }

    private Fraction identifyFraction(String fraction){
        //Create a regex pattern and matcher to identify the fraction.
        Pattern fractionPattern = Pattern.compile("-? ?[0-9]+ -?[0-9]+ ?/ ?-?[0-9]+|-?[0-9]+ ?/ ?-?[0-9]+|-?[0-9]+");
        Matcher findFraction = fractionPattern.matcher(fraction);

        /*
        Check for the length of the identified fraction, the length equates to the type of fraction we will be returning;
        - 3 means it's a mixed fraction.
        - 2 means it's a simple fraction.
        - 1 means it's a whole number.
         */
        if(findFraction.find()){
            String[] fractionToSplit = findFraction.group().trim().split("[/ ]+");
            if(fractionToSplit.length > 2){
                return new MixedFraction(Integer.parseInt(fractionToSplit[0]), Integer.parseInt(fractionToSplit[1]), Integer.parseInt(fractionToSplit[2]));
            }else if(fractionToSplit.length > 1){
                return new MixedFraction(new Fraction(Integer.parseInt(fractionToSplit[0]), Integer.parseInt(fractionToSplit[1])));
            }else{
                return new MixedFraction(new Fraction(Integer.parseInt(fractionToSplit[0])));
            }
        }else{
            return null;
        }
    }

}
