import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Mock
    Animal animal;

    @Test
    public void testGetFood() throws Exception {
        animal.getFood("Хищник");
        Mockito.verify(animal).getFood("Хищник");
    }

    @Test
    public void testNotFelineGetFood() throws Exception {
        animal.getFood("Травоядное");
        Mockito.verify(animal).getFood("Травоядное");
    }

    @Test
    public void testAnimalClassException() {
        try {
            animal.getFood("Нечто");
        } catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного","Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expected,actual);
    }
}
