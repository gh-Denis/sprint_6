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
    private String sex;
    private boolean hasMane;
    private int kittensCount;

    public LionTestParam(String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Before
    public void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] setLionSex() {
        return new Object[][] {
                {"Самец", true, 1},
                {"Самка", false, 1}
        };
    }

    @Test
    public void testLionHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,sex);
        boolean lionHaveMane = hasMane;
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",lionHaveMane,lion.doesHaveMane());
    }

    @Test
    public void testLionGetKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline,sex);
        int lionKittens = kittensCount;
        Assert.assertEquals("У львов 1 львенок",lionKittens,lion.getKittens());
    }
}
