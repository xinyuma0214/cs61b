import org.junit.Test;
import static org.junit.Assert.*;

public class testOffByN {
    OffByN offBy5 = new OffByN(5);
    @Test
    public void testOffByN(){
        assertTrue(offBy5.equalChars('b','g'));
    }
}
