public class FractionArithmetic {

  public int computeGCD(int FirstDenominator, int SecondDenominator){
    int remainder = 0;
    do{
      remainder = FirstDenominator % SecondDenominator;
      FirstDenominator = SecondDenominator;
      SecondDenominator = remainder;
    }while(remainder != 0);
    return FirstDenominator;
  }  

  public void reduce(int numerator, int denominator){
     System.out.printf("result is %d/%d or %.1f.", numerator, denominator, ((double) numerator/denominator));
  }
}
