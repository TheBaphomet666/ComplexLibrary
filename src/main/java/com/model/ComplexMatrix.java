package com.model;

import com.Exceptions.ComplexException;

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
         ComplexMatrix nmatrix= new ComplexMatrix(m,n);

        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                try {
                    nmatrix.put(i,j,matrix[j][i]);
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
            for(int j=0;i<n;j++){
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
     * This method Returns The Attached of a Matrix
     * @return A Complex Matrix
     */
    public ComplexMatrix attach(){
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
            throw new ComplexException(ComplexException.OUT_OF_BOUNDS);
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}
