package com.operator;


import com.model.ComplexNumber;

public class ComplexCalculator {


    /**
     * This Method sums two Complex Numbers
     * @param a First Complex Number
     * @param b Second Complex number
     * @return Returns The Summation of the two complex numbers.
     */
    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealPart()+b.getRealPart(),a.getImaginaryPart()+b.getImaginaryPart());
    }
    /**
     * This Method substracts two Complex Numbers
     * @param a First Complex Number
     * @param b Second Complex number
     * @return Returns a ComplexNumber as the result of substracting b from a.
     */
    public static ComplexNumber substract(ComplexNumber a,ComplexNumber b){
        return new ComplexNumber(a.getRealPart()-b.getRealPart(),a.getImaginaryPart()-b.getImaginaryPart());
    }

    /**
     *
     * @param a First Complex Number
     * @param b Second Complex Number
     * @return Returns a ComplexNumber as the result of Multiplying the two complex numbers.
     */
    public static ComplexNumber multiply(ComplexNumber a,ComplexNumber b){

        return new ComplexNumber(a.getRealPart()*b.getRealPart()-a.getImaginaryPart()*b.getImaginaryPart(),a.getRealPart()*b.getImaginaryPart()+a.getImaginaryPart()*b.getRealPart());
    }

    /**
     * This Method Divides a by b.
     * @param a Dividend.
     * @param b Divisor
     * @return Returns a ComplexNumber as the result of dividing a by b.
     */
    public static ComplexNumber divide(ComplexNumber a,ComplexNumber b){
        double x = (a.getRealPart()*b.getRealPart()+a.getImaginaryPart()*b.getImaginaryPart())/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImaginaryPart(),2));
        double y = (b.getRealPart()*a.getImaginaryPart()-a.getRealPart()*b.getImaginaryPart())/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImaginaryPart(),2));
        return  new ComplexNumber(x,y);
    }


}
