import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    @Test
    public void testGetSound() {
        Cat cat = new Cat(mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(mockFeline);
        List<String> food = cat.getFood();

        assertEquals(3, food.size());
        assertEquals("Животные", food.get(0));
        assertEquals("Птицы", food.get(1));
        assertEquals("Рыба", food.get(2));
    }
}
