package com.Exceptions;

public class ComplexException extends Exception {

    public static String OUT_OF_BOUNDS="INDEX OUT OF BOUNDS";
    public static String NOT_MATCHING_MATRICES="MATRICES DOESN'T MATCH THEIR SIZES TO OPERATE";
    public static String NOT_MATCHING_MULTIPLICATION="MATRICES DOESN'T MATCH THEIR DIMENTIONS TO MULTIPLY";

    public ComplexException(String message){
        super(message);

    }
}
