import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class LionTestParam {
    private final String sex;
    private final boolean hasMane;
    private final int kittensCount;

    public LionTestParam(String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Парамерты: Пол животного = {0}; Наличие гривы = {1}; Количество детенышей = {2}")
    public static Object[][] setLionSex() {
        return new Object[][]{
                {"Самец", true, 1},
                {"Самка", false, 1}
        };
    }

    @Before
    public void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLionHaveMane() {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        boolean lionHaveMane = hasMane;
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", lionHaveMane, lion.doesHaveMane());
    }

    @Test
    public void testLionGetKittens() {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);
        int lionKittens = kittensCount;
        Assert.assertEquals("У львов 1 детеныш", lionKittens, lion.getKittens());
    }
}
