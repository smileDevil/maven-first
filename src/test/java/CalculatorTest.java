import com.jyb.jdbc.junit.Calculator;
import org.junit.Test;

public class CalculatorTest {
    private Calculator cal = new Calculator();
    @Test
    public  void add(){
        System.out.println(cal.add(1,2));
    }
    @Test
    public void substract(){
        System.out.println(cal.substract(3,2));
    }
}
