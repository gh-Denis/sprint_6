import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Mock
    Cat cat;

    @Test
    public void testCatGetSound() {
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        Assert.assertEquals("Кошка должна говорить - Мяу", "Мяу", catSound);
    }

    @Test
    public void testCatGetSoundMock() {
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        Assert.assertEquals("Кошка должна говорить - Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void negativeTestGetFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedCatFood = List.of("Трава", "Различные растения");
        Assert.assertNotEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void testGetFoodMock() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void testGetFoodMock2() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertNotEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }
}
