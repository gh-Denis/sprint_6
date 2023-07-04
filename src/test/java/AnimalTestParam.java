import com.example.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import java.util.List;


@RunWith(Parameterized.class)
public class AnimalTestParam {
    private String animalKind;
    private List<String> listOfFood;

    public AnimalTestParam(String animalKind, List<String> listOfFood) {
        this.animalKind = animalKind;
        this.listOfFood = listOfFood;
    }
    @Before
    public void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public  static Object[][] setAnimalKind() {
        return new Object[][] {
                {"Травоядное",List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void testAnimalGetFood() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",listOfFood,animal.getFood(animalKind));
    }
}
