public class FractionArithmetic {
    public int computeGCD(int FirstDenominator, int SecondDenominator){
    int remainder;
    do{
      remainder = FirstDenominator % SecondDenominator; //Check for the remainder
      FirstDenominator = SecondDenominator; //Assign the value of the second denominator to the first
      SecondDenominator = remainder; //Assign the value of the remainder to the second denominator
    }while(remainder != 0);
    return FirstDenominator; //Display the previous remainder before reaching 0
    }  

    public String reduce(int numerator, int denominator){
        return String.format("%d/%d", numerator/computeGCD(numerator, denominator), denominator/computeGCD(numerator, denominator));
    }
}
