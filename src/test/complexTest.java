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

}
