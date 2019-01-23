package com.model;

import java.util.Objects;

public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
    public String toStringAsNotation() {
        return "("+realPart+","+imaginaryPart+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.realPart, realPart) == 0 &&
                Double.compare(that.imaginaryPart, imaginaryPart) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    /**
     * This method Returns the modulus of the ComplesNumber
     * @return Returns a double that is the modulus of the complex number.
     */
    public double modulus(){
        return Math.sqrt(Math.pow(realPart,2)+Math.pow(imaginaryPart,2));

    }

    /**
     * This Method conjugates the complex number
     * @return returns a ComplexNumber result of the Conjugation of the number.
     */
    public ComplexNumber conjugation(){
        return new ComplexNumber(realPart,imaginaryPart*-1);
    }


}
