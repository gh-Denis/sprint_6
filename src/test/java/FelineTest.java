import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошачьи - хищники",expectedFelineFood, feline.eatMeat());
    }

    @Test
    public void testGetFood() throws Exception {
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testNotFelineGetFood() throws Exception {
        feline.getFood("Травоядное");
        Mockito.verify(feline).getFood("Травоядное");
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String felineAnimal = "Заячьи";
        Assert.assertNotEquals("Это семейство Кошачьи",felineAnimal, feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int felineKittens = 1;
        Assert.assertEquals("У кошачьх 1 котенок",felineKittens, feline.getKittens());
    }

    @Test
    public void testGetFamilyMock() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Это семейство Кошачьи","Кошачьи", feline.getFamily());
    }
}
