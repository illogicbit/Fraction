package prog2.midgroup01;

import prog2.prelimgroup.Fraction;

/**
 * A class designed to hold a mixed fraction.
 * Stores the fractional part and whole number portion and allows operations between regular fractions and mixed fractions.
 *
 * @see Fraction
 */
public class MixedFraction extends Fraction {
    private int whole;

    /**
     * Creates a fraction with a default value of <i>0 0/1</i>
     */
    public MixedFraction() {
        super();
        this.whole = 0;
    }

    /**
     * Creates a fraction with a whole number and an existing fraction.
     * <i>Automatically converts an improper fraction into a mixed fraction.</i>
     *
     * @param whole    Whole number part of the mixed fraction
     * @param fraction Fractional portion of the mixed fraction.
     */
    public MixedFraction(int whole, Fraction fraction) {
        //Automatically convert the fraction into a proper fraction and add the
        super(fraction.getNumerator() % fraction.getDenominator(), fraction.getDenominator());
        this.whole = whole + fraction.getNumerator() / fraction.getDenominator();
    }

    /**
     * Creates a fraction with the given parameters.
     *
     * @param whole
     * @param numerator
     * @param denominator
     */
    public MixedFraction(int whole, int numerator, int denominator) {
        super(numerator % denominator, denominator);
        this.whole = whole + numerator / denominator;
    }

    /**
     * Creates a fraction from a proper or improper fraction
     * If the fraction is improper, it is automatically converted into a mixed fraction
     *
     * @param fraction Fraction to convert to a mixed fraction
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.getNumerator() % fraction.getDenominator(), fraction.getDenominator());
        this.whole = fraction.getNumerator() / fraction.getDenominator();
    }

    public void setWholePart(int whole) {
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction) {
        this.setNumerator(fraction.getNumerator());
        this.setDenominator(fraction.getDenominator());
    }

    public int getWholePart() {
        return this.whole;
    }

    public Fraction getFractionPart() {
        return new Fraction(this.getNumerator(), getDenominator());
    }

    /**
     * Converts this mixed fraction to an improper fraction
     *
     * @return Improper fraction representation of the fraction
     */
    public Fraction toFraction() {
        int newNumerator = this.getDenominator() * this.whole + this.getNumerator(); //Calculates the improper fraction
        return new Fraction(newNumerator, this.getDenominator());
    }

    /**
     * Adds this fraction to another fraction
     * (This Fraction) + (Other Fraction)
     *
     * @param other Fraction to add
     * @return Sum of the operation
     */
    public MixedFraction addition(MixedFraction other) {
        Fraction temp = this.toFraction();
        return new MixedFraction(temp.addition(other.toFraction()));
    }

    /**
     * Adds this fraction to another fraction
     * (This Fraction) + (Other Fraction)
     *
     * @param other Fraction to add
     * @return Sum of the operation
     */
    public MixedFraction subtraction(MixedFraction other) {
        Fraction temp = this.toFraction();
        return new MixedFraction(temp.subtraction(other.toFraction()));
    }

    /**
     * Adds this fraction to another fraction
     * (This Fraction) + (Other Fraction)
     *
     * @param other Fraction to add
     * @return Sum of the operation
     */
    public MixedFraction multiplyBy(MixedFraction other) {
        Fraction temp = this.toFraction();
        return new MixedFraction(temp.multiplyBy(other.toFraction()));
    }

    /**
     * Adds this fraction to another fraction
     * (This Fraction) + (Other Fraction)
     *
     * @param other Fraction to add
     * @return Sum of the operation
     */
    public MixedFraction divideBy(MixedFraction other) {
        Fraction temp = this.toFraction();
        return new MixedFraction(temp.divideBy(other.toFraction()));
    }

    public MixedFraction reduce() {
        return new MixedFraction(this.toFraction().reduce());
    }

}
