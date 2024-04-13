import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Feline feline;

    public LionTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConstructorMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testConstructorInvalidSex() {
        try {
            Lion lion = new Lion("Other", feline);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
        }
    }

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testDoesHaveMane() throws Exception {
        Lion maleLion = new Lion("Самец", feline);
        Lion femaleLion = new Lion("Самка", feline);
        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> food = lion.getFood();
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFoodInvalidKind() throws Exception {
        Lion lion = new Lion("Самец", feline);
        doReturn(Collections.emptyList()).when(feline).getFood("Хищник");
        assertEquals(Collections.emptyList(), lion.getFood());
    }
}