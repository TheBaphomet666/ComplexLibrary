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


    public void put(int i, int j, ComplexNumber c) throws  ComplexException{
        checkBounds(i,j);
        matrix[i][j]=c;
    }

    public ComplexNumber get(int i,int j) throws ComplexException {
        checkBounds(i,j);
        return matrix[i][j];
    }

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

    public ComplexMatrix attach(){
        return this.conjugation().transpose();
    }

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

    private void checkBounds(int i,int j) throws ComplexException{
        if(i<0 || j<0 || i>=m || j>=n){
            throw new ComplexException(ComplexException.OUT_OF_BOUNDS);
        }
    }
}
