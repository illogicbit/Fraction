public class Fraction {
    /*
    - Calculate the GCD/GCF of two numbers
    */
    public int computeGCD(int FirstNumber, int SecondNumber){
        int remainder;
        do{
            remainder = FirstNumber % SecondNumber;
            FirstNumber = SecondNumber;
            SecondNumber = remainder;
        }while(remainder != 0);
        return FirstNumber;
    }
    
    /*
    - Reduces fraction to the lowest term
    - Remove parameters if just reducing either fraction 1 or 2. 
     */
    public String reduce(int numerator, int denominator){ 
        int GCD = computeGCD(numerator, denominator);
        if(numerator % denominator == 0){ //For proper fractions
            return String.format("%d", numerator/denominator);
        }else{ //For improper fractions
            return String.format("%d/%d",numerator/GCD, denominator/GCD);
        }
    }
}
