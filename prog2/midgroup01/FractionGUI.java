import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.*;

//For pattern matching
//NOTE: Requires both MixedFraction and Fraction class in the same package to work.
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FractionGUI extends JFrame {
    private String equation = null;
    private MixedFraction[] mixedFraction = new MixedFraction[2];

    private JTextArea display = new JTextArea(1,30);
    private BorderLayout brLay = new BorderLayout();
    private GridLayout btnLay = new GridLayout(6, 4, 4, 4);
    private JPanel bgPanel = new JPanel(new BorderLayout());
    private JPanel btnPanel = new JPanel();
    private Color bgColor = new Color(250, 230, 230);
    private Color btnColor = new Color(250, 170, 170);
    private Color fontColor = new Color(140, 70, 80);
    private Color altbtnColor = new Color(200,160,160);
    private Font btnFont = new Font("Arial", Font.PLAIN, 20);
    private Dimension txtDim = new Dimension(430, 100);

    public FractionGUI() {
        setTitle("Fraction Calculator");
        setSize(430, 600);
        setLayout(brLay);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bgPanel.setBackground(bgColor);
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        btnPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnPanel.setLayout(btnLay);

        String[] btnLabel = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/", "Sf", "Mf", "<", ">", "S->D", "Red"}; //Button Label
        for (String lbl : btnLabel) {
            RoundBtn btn = new RoundBtn();
            btn.setText(lbl);
            btn.setFont(btnFont);
            btn.setBackground(btnColor);
            btn.setForeground(fontColor);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btnPanel.setBackground(bgColor);
            btnPanel.add(btn);

            btn.addMouseListener(new MouseAdapter() { //mouse hover effect
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    btn.setBackground(altbtnColor);
                    btn.setForeground(btnColor);
                }
                public void mouseExited(MouseEvent e){
                    super.mouseEntered(e);
                    btn.setBackground(btnColor);
                    btn.setForeground(fontColor);
                }
            });
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Display cursor.
                    Caret cursor = display.getCaret();
                    cursor.setVisible(true);

                    //Apply specific functions to buttons (Edit or rework, switch case for inputs and to test methods).
                    try{
                        switch(btn.getText()){
                            case "Sf":
                                display.insert("Sf(/)", display.getCaretPosition());
                                display.setCaretPosition(display.getCaretPosition() - 2);
                                break;
                            case "Mf":
                                display.insert("Mf((/))", display.getCaretPosition());
                                display.setCaretPosition(display.getCaretPosition() - 4);
                                break;
                            case "=":
                                    arithmeticOperations(equation);
                                break;
                            case "<":
                                display.setCaretPosition(display.getCaretPosition() - 1);
                                break;
                            case ">":
                                display.setCaretPosition(display.getCaretPosition() + 1);
                                break;
                            case "C":
                                display.setText("");
                                break;
                            case "S->D":
                                fractionToDouble(equation);
                                break;
                            case "Red":
                                reduceFraction(equation);
                                break;
                            default:
                                display.insert(btn.getText(), display.getCaretPosition());
                        }
                        equation = display.getText();
                    }catch (InvalidInputException error){
                        JOptionPane.showMessageDialog(getContentPane(), error.getMessage());
                    }catch (IndexOutOfBoundsException error){
                        JOptionPane.showMessageDialog(getContentPane(), "Fraction count must not exceed 2!");
                    }catch (NullPointerException error){
                        JOptionPane.showMessageDialog(getContentPane(), "One or more fraction(s) is/are invalid!");
                    }catch (ArithmeticException error){
                        JOptionPane.showMessageDialog(getContentPane(), "Denominator must be greater than zero!");
                    }
                }

            });


        }
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setFont(btnFont);
        display.setPreferredSize(txtDim);
        display.setBackground(bgColor);


        bgPanel.add(display, BorderLayout.NORTH);
        bgPanel.add(btnPanel, BorderLayout.CENTER);

        add(bgPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //Method to identify the fraction/s in the equations (Max of 2)
    public void identifyPartsAndValidate(String equation) throws InvalidInputException {

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

    public void arithmeticOperations(String equation) throws InvalidInputException{
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
                throw new InvalidInputException("Invalid operator!");
        }
    }

    public void fractionToDouble(String equation) throws InvalidInputException{
        identifyPartsAndValidate(equation);
        //Print statement for testing
        System.out.println(mixedFraction[0].toDouble());
        //Code to convert fraction to double.
    }

    public void reduceFraction(String equation) throws InvalidInputException{
        identifyPartsAndValidate(equation);
        //Print statement for testing.
        System.out.println(mixedFraction[0].reduce());
        //Code to reduce fraction.
    }

    public class RoundBtn extends JButton {
        private int cornerRadius = 5;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FractionGUI calc = new FractionGUI();
        });
    }

    //Start of custom exceptions
    public class InvalidInputException extends Exception {
        public InvalidInputException(String errorMessage) {
            super(errorMessage);
        }
    }
}
