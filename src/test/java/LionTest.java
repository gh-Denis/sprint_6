import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void testLionGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLionClassException() {
        new Lion(feline, "Некто");
    }

    @Test
    public void testLionGetKittens() {
        Lion lion = new Lion(feline, "Самка");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testPositiveLionHaveMane() {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testNegativeLionHaveMane() {
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }
}
