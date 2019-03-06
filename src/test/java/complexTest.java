import com.Exceptions.ComplexException;
import com.model.ComplexMatrix;
import com.model.ComplexNumber;
import com.operator.ComplexCalculator;
import org.junit.Assert;
import org.junit.Test;


public class complexTest {

    @Test
    public void shouldSum(){
        Assert.assertTrue(ComplexCalculator.sum(new ComplexNumber(1,1),new ComplexNumber(-1,-1)).equals(new ComplexNumber(0,0)));
    }
    @Test
    public void shouldSubs(){
        Assert.assertTrue(ComplexCalculator.substract(new ComplexNumber(1,1),new ComplexNumber(-1,-1)).equals(new ComplexNumber(2,2)));

    }

    @Test
    public void shouldMultiply(){
        Assert.assertTrue(ComplexCalculator.multiply(new ComplexNumber(0,1),new ComplexNumber(0,1)).equals(new ComplexNumber(-1,0)));

    }

    @Test
    public void shouldDivide(){
        Assert.assertTrue(ComplexCalculator.divide(new ComplexNumber(-2,1),new ComplexNumber(1,2)).equals(new ComplexNumber(0,1)));

    }
    @Test
    public void shouldModulus(){
       // System.out.println(new ComplexNumber(1,-1).modulus()+"   "+Math.sqrt(2));
        Assert.assertEquals(new ComplexNumber(1,-1).modulus(),Math.sqrt(2),0);

    }

    @Test
    public void shouldConjugate(){
        Assert.assertTrue(new ComplexNumber(1,-8).conjugation().equals(new ComplexNumber(1,8)));
    }

    @Test
    public void shouldShowAsCartesian(){
       // System.out.println(new ComplexNumber(1,1).toStringAsCartesian());
        String result ="(1.0,1.0)";
        Assert.assertEquals(new ComplexNumber(1,1).toStringAsCartesian(),result);
    }

    @Test
    public void shouldShowAsPolar(){
        //System.out.println(new ComplexNumber(1,1).toStringAspolar());
        String result ="(1.4142135623730951,0.7853981633974483)";
        Assert.assertEquals(new ComplexNumber(1,1).toStringAspolar(),result);
    }

    @Test
    public void ShouldTransponseMatrices(){
        ComplexMatrix a= new ComplexMatrix(4,2);
        try {
            for(int i=0;i<4;i++){
                for(int j=0;j<2;j++){
                    a.put(i,j,new ComplexNumber(i%2+j,j));
                }

            }

        } catch (ComplexException e) {
            e.printStackTrace();
        }
        ComplexMatrix result= new ComplexMatrix(2,4);
        try {
            for(int i=0;i<2;i++){
                for(int j=0;j<4;j++){
                    result.put(i,j,new ComplexNumber(a.get(j,i).getRealPart(),a.get(j,i).getImaginaryPart()));
                }

            }

        } catch (ComplexException e) {
            e.printStackTrace();
        }
        ComplexMatrix b= a.transpose();
        //System.out.println(result);
        //System.out.println(b);
        Assert.assertTrue(a.transpose().equals(result));


    }

    @Test
    public void shouldMutiplyMatrices(){
        ComplexMatrix a= new ComplexMatrix(2,2);
        ComplexMatrix b= new ComplexMatrix(2,2);
        ComplexMatrix result= new ComplexMatrix(2,2);
        try {
            a.put(0,0,new ComplexNumber(1,0));
            a.put(0,1,new ComplexNumber(0,-1));
            a.put(1,0,new ComplexNumber(1,1));
            a.put(1,1,new ComplexNumber(4,-1));

            b.put(0,0,new ComplexNumber(0,1));
            b.put(0,1,new ComplexNumber(1,-1));
            b.put(1,0,new ComplexNumber(2,-3));
            b.put(1,1,new ComplexNumber(4,0));

            result.put(0,0,new ComplexNumber(-3,-1));
            result.put(0,1,new ComplexNumber(1,-5));
            result.put(1,0,new ComplexNumber(4,-13));
            result.put(1,1,new ComplexNumber(18,-4));
        } catch (ComplexException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(ComplexCalculator.multiply(a,b).equals(result));
        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldSumMatrices(){

        ComplexMatrix a= new ComplexMatrix(2,2);

        ComplexMatrix result = new ComplexMatrix(2,2);

        try {
            a.put(0,0,new ComplexNumber(1,4));
            a.put(0,1,new ComplexNumber(2,3));
            a.put(1,0,new ComplexNumber(3,2));
            a.put(1,1,new ComplexNumber(4,1));
            result.put(0,0, new ComplexNumber(a.get(0,0).getRealPart()*2,a.get(0,0).getImaginaryPart()*2));
            result.put(0,1, new ComplexNumber(a.get(0,1).getRealPart()*2,a.get(0,1).getImaginaryPart()*2));
            result.put(1,0, new ComplexNumber(a.get(1,0).getRealPart()*2,a.get(1,0).getImaginaryPart()*2));
            result.put(1,1, new ComplexNumber(a.get(1,1).getRealPart()*2,a.get(1,1).getImaginaryPart()*2));

        } catch (ComplexException e) {
            e.printStackTrace();
        }

        try {
            Assert.assertEquals(ComplexCalculator.sum(a,a),result);
        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldTensor(){
        ComplexMatrix a= new ComplexMatrix(2,2);
        ComplexMatrix b= new ComplexMatrix(3,2);
        ComplexMatrix result= new ComplexMatrix(6,4);
        try {
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    a.put(i,j,new ComplexNumber(0,1));
                }

            }
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    b.put(i,j,new ComplexNumber(0,1));
                }

            }
            for(int i=0;i<6;i++){
                for(int j=0;j<4;j++){
                    result.put(i,j,new ComplexNumber(-1,0));
                }

            }


        } catch (ComplexException e) {
            e.printStackTrace();
        }
        //System.out.println(result);
        //System.out.println(ComplexCalculator.tensor(a,b));
        Assert.assertEquals(ComplexCalculator.tensor(a,b),result);
    }

    @Test
    public void shouldSubMatrices() {

        ComplexMatrix a = new ComplexMatrix(2, 2);

        ComplexMatrix result = new ComplexMatrix(2, 2);

        try {
            a.put(0, 0, new ComplexNumber(1, 4));
            a.put(0, 1, new ComplexNumber(2, 3));
            a.put(1, 0, new ComplexNumber(3, 2));
            a.put(1, 1, new ComplexNumber(4, 1));
            result.put(0, 0, new ComplexNumber(0, 0));
            result.put(0, 1, new ComplexNumber(0, 0));
            result.put(1, 0, new ComplexNumber(0, 0));
            result.put(1, 1, new ComplexNumber(0, 0));

        } catch (ComplexException e) {
            e.printStackTrace();
        }

        try {
            Assert.assertEquals(ComplexCalculator.substract(a, a), result);
        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCheckUnitary(){
        ComplexMatrix a = new ComplexMatrix(2,2);

        try {
            a.put(0,0,new ComplexNumber(1,1));
            a.put(0,1,new ComplexNumber(1,-1));
            a.put(1,0,new ComplexNumber(1,-1));
            a.put(1,1,new ComplexNumber(1,1));
            a= ComplexCalculator.scalarProduct(0.5,a);
            Assert.assertTrue(a.isUnitary());

        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldNorm(){
        ComplexMatrix a= new ComplexMatrix(1,4);
        try {
            a.put(0,0,new ComplexNumber(3,2));
            a.put(0,1,new ComplexNumber(-1,3));
            a.put(0,2,new ComplexNumber(-10,-7));
            a.put(0,3,new ComplexNumber(9,-8));
            Assert.assertEquals(a.norm(),Math.sqrt(317),0);

        } catch (ComplexException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void shouldDistance(){
        ComplexMatrix a= new ComplexMatrix(1,2);
        ComplexMatrix b= new ComplexMatrix(1,2);

        try {
            a.put(0,0,new ComplexNumber(1,2));
            a.put(0,1,new ComplexNumber(1,2));
            b.put(0,0,new ComplexNumber(6,3));
            b.put(0,1,new ComplexNumber(5,1));
            Assert.assertEquals(6.557438524302,ComplexCalculator.substract(a,b).norm(),0);

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Marble(){
        ComplexMatrix a= new ComplexMatrix(6,6);
        ComplexMatrix b= new ComplexMatrix(6,1);
        ComplexMatrix result= new ComplexMatrix(6,1);
        for(int i=0; i< a.getM();i++){
            for(int j=0; j<a.getN();j++){
                try {
                    a.put(i,j,new ComplexNumber(0,0));
                } catch (ComplexException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            a.put(2,1,new ComplexNumber(1,0));
            a.put(2,5,new ComplexNumber(1,0));
            a.put(3,3,new ComplexNumber(1,0));
            a.put(4,2,new ComplexNumber(1,0));
            a.put(5,0,new ComplexNumber(1,0));
            a.put(5,4,new ComplexNumber(1,0));

            b.put(0,0, new ComplexNumber(6,0));
            b.put(1,0, new ComplexNumber(2,0));
            b.put(2,0, new ComplexNumber(1,0));
            b.put(3,0, new ComplexNumber(5,0));
            b.put(4,0, new ComplexNumber(3,0));
            b.put(5,0, new ComplexNumber(10,0));

            result.put(0,0, new ComplexNumber(0,0));
            result.put(1,0, new ComplexNumber(0,0));
            result.put(2,0, new ComplexNumber(12,0));
            result.put(3,0, new ComplexNumber(5,0));
            result.put(4,0, new ComplexNumber(1,0));
            result.put(5,0, new ComplexNumber(9,0));
        } catch (ComplexException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(ComplexCalculator.Marble(a,b,1),result);
        } catch (ComplexException e) {
            e.printStackTrace();
        }
        //System.out.println(a);
       // System.out.println(b);
        /*try {
            System.out.println(ComplexCalculator.Marble(a,b,1));
        } catch (ComplexException e) {
            e.printStackTrace();
        }*/

    }



}
