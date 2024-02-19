package prog2.prelimgroup;

import java.util.Scanner;

public class FractionArithmetic {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Fraction fr1 = new Fraction(); // fraction 1
        Fraction fr2 = new Fraction(); // fraction 2
        int c; // for case
        char choice = 'Y'; // for loop control
        while (choice == 'Y') { // loop for input
            Greeting();
            System.out.print("Enter your choice: ");

            if (kbd.hasNextInt()) {
                c = kbd.nextInt();
                kbd.nextLine();
                switch (c) {
                    case 1 -> { //input num1
                        System.out.println("Enter the numerator for Fraction 1: ");
                        int num1 = intInput(kbd);
                        fr1.setNumerator(num1);
                        while (true) {
                            System.out.println("Enter the denominator for Fraction 1:");
                            int den1 = intInput(kbd);
                            if (den1 == 0) {
                                System.out.println("Enter a non-zero denominator.");
                            } else {
                                fr1.setDenominator(den1);
                                break;
                            }
                        }
                    }
                    case 2 -> { //input num2
                        System.out.println("Enter the numerator for Fraction 2: ");
                        int num2 = intInput(kbd);
                        fr2.setNumerator(num2);
                        while (true) {
                            System.out.println("Enter the denominator for Fraction 2:");
                            int den2 = intInput(kbd);
                            if (den2 == 0) {
                                System.out.println("Enter a non-zero denominator.");
                            } else {
                                fr2.setDenominator(den2);
                                break;
                            }
                        }
                    }
                    case 3 -> { //add
                        Fraction result = fr1.addition(fr2);
                        System.out.println("Result: " + result.toString());
                        choice = askLoop(kbd, choice);
                    }
                    case 4 -> { // sub
                        Fraction result = fr1.subtract(fr2);
                        System.out.println("Result: " + result.toString());
                        choice = askLoop(kbd, choice);
                    }
                    case 5 -> { //multiply
                        Fraction result = fr1.multiplyBy(fr2);
                        System.out.println("Result: " + result.toString());
                        choice = askLoop(kbd, choice);
                    }
                    case 6 -> { // divide
                        Fraction result = fr1.divideBy(fr2);
                        System.out.println("Result: " + result.toString());
                        System.out.printf("Result: " + "%.2f\n", result.toDouble());
                        choice = askLoop(kbd, choice);
                    }
                    case 7 -> { //reduce
                        //1
                        Fraction reducedFraction1 = fr1.reduce();
                        System.out.println("Reduced Fraction 1: " + reducedFraction1.toString());
                        //2
                        Fraction reducedFraction2 = fr2.reduce();
                        System.out.println("Reduced Fraction 2: " + reducedFraction2.toString());
                        choice = askLoop(kbd, choice);
                    }
                    case 8 -> {
                        choice = 'N';
                    }
                    default -> System.out.println("Invalid choice. Please enter another valid option. ");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                kbd.nextLine();// eat invalid

            }


        }
        System.out.println("Program Terminated");
        System.exit(0);
    }

    public static void Greeting() { //GUI for the user
        System.out.println("___________________________________");
        System.out.println("|Fraction Calculator              |");
        System.out.println("|       What do you want to do?   |");
        System.out.println("|1. Enter the value of Fraction 1 |");
        System.out.println("|2. Enter the value of Fraction 2 |");
        System.out.println("|3. Add the Fractions             |");
        System.out.println("|4. Subtract the Fractions        |");
        System.out.println("|5. Multiply the Fractions        |");
        System.out.println("|6. Divide the Fractions          |");
        System.out.println("|7. Reduce the Fractions          |");
        System.out.println("|8. Exit                          |");
        System.out.println("___________________________________");
    }

    public static int intInput(Scanner kbd) {
        while (!kbd.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            kbd.nextLine();
        }
        return kbd.nextInt();
    }

    public static char askLoop(Scanner kbd, char userChoice){
        do{
            System.out.print("Would you like to run the program again? [Y/N]: ");
            userChoice = kbd.nextLine().toUpperCase().charAt(0);
        }while(userChoice != 'Y' && userChoice != 'N');
        return userChoice;


    }
}
