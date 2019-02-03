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
        System.out.println(new ComplexNumber(1,1).toStringAsCartesian());
        Assert.assertTrue(true);
    }

    @Test
    public void shouldShowAsPolar(){
        System.out.println(new ComplexNumber(1,1).toStringAspolar());
        Assert.assertTrue(true);
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

        ComplexMatrix b= a.transpose();
        System.out.println(b);
        System.out.println(a);

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

}
