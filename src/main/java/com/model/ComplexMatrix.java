package com.model;

import com.Exceptions.ComplexException;
import com.operator.ComplexCalculator;

import javax.sound.midi.SysexMessage;
import java.util.*;


public class ComplexMatrix  {

    private ComplexNumber[][] matrix;
    private int m=0;
    private int n=0;

    public ComplexMatrix(int m , int n) {
        this.m=m;
        this.n=n;
        this.matrix = new ComplexNumber[m][n];
    }


    /**
     *This method index a Given Complex Number into the given coordinates.
     * @param i int Row.
     * @param j int column.
     * @param c Complex number to Index.
     * @throws ComplexException Throws exception if the coordintaes are out of bounds.
     */
    public void put(int i, int j, ComplexNumber c) throws  ComplexException{
        checkBounds(i,j);
        matrix[i][j]=c;
    }

    /**
     * This Method gets a Certain Complex number in the given coordinates.
     * @param i int Row.
     * @param j int Column.
     * @return Complex Number indexed  in the given coordinates.
     * @throws ComplexException Throws exception if the coordintaes are out of bounds.
     */
    public ComplexNumber get(int i,int j) throws ComplexException {
        checkBounds(i,j);
        return matrix[i][j];
    }

    /**
     * This Method Returns The transposed current Matrix.
     * @return A Compled Matrix Transposed.
     */
    public ComplexMatrix transpose(){
         ComplexMatrix nmatrix= new ComplexMatrix(n,m);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                try {
                   nmatrix.put(j,i,matrix[i][j]);
                } catch (ComplexException e) {
                    e.printStackTrace();
                }
            }

        }
        return nmatrix;
    }

    /**
     * This Method conjugates every of the indexed ComplexNumbers
     * @return Returns a ComplexMatrix that is the given Matrix conjugated.
     */
    public ComplexMatrix conjugation(){
        ComplexMatrix nmatrix= new ComplexMatrix(m,n);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                try {
                    nmatrix.put(i,j,matrix[i][j].conjugation());
                } catch (ComplexException e) {
                    e.printStackTrace();
                }
            }

        }
        return nmatrix;

    }

    /**
     * This method Returns The adjoint of a Matrix
     * @return A Complex Matrix
     */
    public ComplexMatrix adjoint(){
        return this.conjugation().transpose();
    }


    /**
     * This Method returns the Inverse of the Matrix
     * @return a Complex Matrix that every index is inversed.
     */
    public ComplexMatrix inverse(){
        ComplexMatrix nmatrix= new ComplexMatrix(m,n);

        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                try {
                    nmatrix.put(i,j,matrix[i][j].inverse());
                } catch (ComplexException e) {
                    e.printStackTrace();
                }
            }

        }
        return nmatrix;
    }



    /**
     * This method Checks if the given coordinates are out of Bounds
     * @param i int row.
     * @param j int collumn.
     * @throws ComplexException Throws exception if the coordintaes are out of bounds.
     */
    private void checkBounds(int i,int j) throws ComplexException{
        if(i<0 || j<0 || i>=m || j>=n){
            System.out.println("i="+i+" j="+j);
            throw new ComplexException(ComplexException.OUT_OF_BOUNDS);
        }
    }

    /**
     * This method is used to know if the matrix is hermitian
     * @return a boolean true if is hermitian false if not.
     */
    public boolean isHermitian(){
        boolean bol =false;
        if(this.equals(this.adjoint())){
            bol=true;
        }
        return bol;
    }

    /**
     * This method is used to know if a given matrix is unitary
     * @return True if is unitary false if not.
     * @throws ComplexException Throws exception if the given matrix is not square.
     */
    public boolean isUnitary() throws ComplexException {
        if(this.n!=this.m){
            throw new ComplexException(ComplexException.NOT_SQUARE);
        }
        boolean bol=true;
        if(!ComplexCalculator.multiply(this,this.adjoint()).equals(ComplexCalculator.multiply(this.adjoint(),this))){
            bol=false;
        }
        ComplexMatrix nthis= ComplexCalculator.multiply(this,this.adjoint());
        if(bol){
            for(int i=0;i<m && bol;i++){
                for(int j=0;j<n && bol;j++){
                    if(i!=j){
                        if(!nthis.get(i,j).equals(new ComplexNumber(0,0))){
                            bol=false;
                            //System.out.println("false2");
                        }
                    }
                    else if(i==j){
                        if(!nthis.get(i,j).equals(new ComplexNumber(1,0))){
                            bol=false;
                            //System.out.println("false3");
                            System.out.println(nthis.get(i,j));
                        }
                    }
                }

            }

        }
        return bol;
    }

    /**
     * This method returns the norm of a vector.
     * @return A double that is the norm of a vector
     * @throws ComplexException Throws exception if is not a vector.
     */
    public double norm() throws ComplexException {
        isVector(this);
        double result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                result+=Math.pow(this.get(i,j).modulus(),2);
            }
        }
        return Math.sqrt(result);

    }
    private void isVector(ComplexMatrix v) throws ComplexException {
        if(!(v.getM()==1 && v.getN()>1 || v.getN()==1 && v.getM()>1)){
            throw  new ComplexException(ComplexException.NOT_A_VECTOR);
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexMatrix)) return false;
        ComplexMatrix that = (ComplexMatrix) o;

        Boolean bol=m == that.m && n == that.n ;
        if(bol) {
            for (int i = 0; i < m && bol; i++) {
                for(int j=0; j<n;j++){
                    try {
                        bol =this.get(i,j).equals(that.get(i,j));
                    } catch (ComplexException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return bol;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m, n);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    public ComplexNumber[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {

        String ma="";
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               // System.out.println("i= "+i+"j= "+j);
                ma+="["+matrix[i][j].toStringAsCartesian()+"],";
            }
            ma+="\n";
        }

        return ma;
    }
}
