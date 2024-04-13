import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class FelineTest {
    @MethodSource("provideFelineFood")
    public void testEatMeat(String foodType) throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(3, food.size());
        for (String f : food) {
            assertEquals(foodType, f);
        }
    }

    private static List<String> provideFelineFood() {
        return Arrays.asList("Животные", "Птицы", "Рыба");
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

}
