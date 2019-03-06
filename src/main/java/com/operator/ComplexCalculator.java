package com.operator;


import com.Exceptions.ComplexException;
import com.model.ComplexMatrix;
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

    /**
     * This Method Sums Two ComplexMatrices
     * @param a First Matrix
     * @param b Second Matrix
     * @return Returns a ComplexMatrix That is the result of a+b
     * @throws ComplexException Throws Exception if dimention of the Two Matrices doesn't match.
     */
    public static ComplexMatrix sum(ComplexMatrix a, ComplexMatrix b) throws ComplexException {
        checkMatricesSameDimention(a,b);
        ComplexMatrix nmatrix = new ComplexMatrix(a.getM(),a.getN());
        for(int i=0; i<a.getM();i++){
            for(int j=0;j<a.getN();j++){
                nmatrix.put(i,j,sum(a.get(i,j),b.get(i,j)));
            }

        }

        return nmatrix;
    }

    /**
     * This Method Sums Two ComplexMatrices
     * @param a First Matrix
     * @param b Second Matrix
     * @return Returns a ComplexMatrix That is the result of a-b
     * @throws ComplexException Throws Exception if dimention of the Two Matrices doesn't match.
     */
    public static ComplexMatrix substract(ComplexMatrix a, ComplexMatrix b) throws ComplexException {
        checkMatricesSameDimention(a,b);
        ComplexMatrix nmatrix = new ComplexMatrix(a.getM(),a.getN());
        for(int i=0; i<a.getM();i++){
            for(int j=0;j<a.getN();j++){
                nmatrix.put(i,j,substract(a.get(i,j),b.get(i,j)));
            }

        }

        return nmatrix;
    }

    /**
     * This method Multiplies the Complex Number by a Scalar.
     * @param scalar Scalar quotient.
     * @param c The complexNumber
     * @return A new ComplexNumber Result of the Scalar product.
     */
    public static ComplexNumber scalarProduct(double scalar, ComplexNumber c){

        return new ComplexNumber(c.getRealPart()*scalar,c.getImaginaryPart()*scalar);

    }

    /**
     * This method Multiplies the matrix by an scalar.
     * @param scalar int Scalar about to be applied to the matrix.
     * @param  c The ComplexMatrix
     * @return A complex Matrix resulted by the scalar product.
     */
    public static ComplexMatrix scalarProduct(double scalar, ComplexMatrix c){

        ComplexMatrix nmatrix= new ComplexMatrix(c.getM(),c.getN());
        for(int i=0;i<c.getM();i++){
            for(int j=0;j<c.getN();j++){
                try {
                    nmatrix.put(i,j,scalarProduct(scalar,c.get(i,j)));
                } catch (ComplexException e) {
                    e.printStackTrace();
                }
            }
        }
        return nmatrix;
    }

    /**
     * This method multiplies two matrices
     * @param a First Matrix
     * @param b Second Matrix
     * @return A ComplexMatrix result of AXB
     * @throws ComplexException throws exception if the Dimention of the matrices doesn't match for the multiplication.
     */
    public static ComplexMatrix multiply(ComplexMatrix a, ComplexMatrix b) throws ComplexException{
        if(a.getN()!=b.getM()){
            throw new ComplexException(ComplexException.NOT_MATCHING_MULTIPLICATION);
        }
        ComplexMatrix nmatrix = new ComplexMatrix(a.getM(),b.getN());
        for(int i=0;i<a.getM();i++){
            for(int k=0;k<b.getN();k++){
                ComplexNumber value = new ComplexNumber(0,0);
                for(int j=0;j<a.getN();j++){
                    value= sum(value,multiply(a.get(i,j),b.get(j,k)));
                }
                nmatrix.put(i,k,value);

            }

        }
        return nmatrix;
    }

    /**
     * This method is the Tensor product beetwen two matrices
     * @param a first matrix
     * @param b second matrix
     * @return Returns the result of a tensor b
     */
    public static ComplexMatrix tensor(ComplexMatrix a, ComplexMatrix b){
        ComplexMatrix res = new ComplexMatrix(a.getM()*b.getM(),a.getN()*b.getN());
        for(int i=0;i<a.getM();i++){
            for(int j=0;j<a.getN();j++){
                //Recorriendo A
                for(int k=0;k<b.getM();k++){
                    for(int l=0;l<b.getN();l++){
                        //tengo indice b
                        try {
                            //System.out.println("I= "+(i*b.getM()+k)+"J= "+(j*b.getN()+l));
                            res.put((i*b.getM()+k),(j*b.getN()+l),ComplexCalculator.multiply(a.get(i,j),b.get(k,l)));
                        } catch (ComplexException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }

        }

        return res;

    }

    /**
     * This method Calculates the distance between two vectors
     * @param a First vector.
     * @param b Second Vector.
     * @return A double that is the distance.
     * @throws ComplexException If any of the given are not vectors.
     */
    public static double distance(ComplexMatrix a, ComplexMatrix b) throws ComplexException {
        if(!(isVector(a) && isVector(b))){
            throw new ComplexException(ComplexException.NOT_A_VECTOR);
        }
        return ComplexCalculator.substract(a,b).norm();
    }


    /**
     * Checks if two matrices have the same dimention
     * @param a First ComplexMatrix
     * @param b Second ComplexMatrix
     * @throws ComplexException Throws exception if the matrices doesn't have the same dimention.
     */
    private static void checkMatricesSameDimention(ComplexMatrix a, ComplexMatrix b) throws  ComplexException{
        if(a.getN() != b.getN() || a.getM()!= b.getM()){
            throw new ComplexException(ComplexException.NOT_MATCHING_MATRICES);
        }
    }

    private static boolean isVector(ComplexMatrix v){
        if(!(v.getM()==1 && v.getN()>1 || v.getN()==1 && v.getM()>1)){
            return false;
        }
        return true;
    }

    /**
     * This Method changes the state of the Marbles.
     * @param bool
     * @param marble
     * @param clicks
     * @return
     * @throws ComplexException
     */
    public static ComplexMatrix Marble(ComplexMatrix bool,ComplexMatrix marble,int clicks)throws ComplexException{
        for(int i=0;i<bool.getM();i++){
            for(int j=0;j<bool.getN();j++) {
                    if(!(bool.get(i,j).equals(new ComplexNumber(1,0)) || bool.get(i,j).equals(new ComplexNumber(0,0) ))){
                        throw new ComplexException(ComplexException.NOT_A_BOOLEAN);
                    }
                }
            }
        if(!isVector(marble) || marble.getN()!=1){
            throw new ComplexException(ComplexException.NOT_MATCHING_VECTOR);
        }
        if(clicks<=0){
            throw new ComplexException(ComplexException.INVALID_ARGUMENT);
        }
        ComplexMatrix current= bool;
        if(clicks>1) {
            current = ComplexCalculator.multiply(bool, bool);
            clicks--;

            while (clicks > 1) {
                current = ComplexCalculator.multiply(current, bool);
                clicks--;
            }
        }
        ComplexMatrix result = ComplexCalculator.multiply(current,marble);
        return result;
    }

}
