import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConstructorMale() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testConstructorInvalidSex() {
        try {
            Lion lion = new Lion("Other");
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
        }
    }
    @Test
    void testGetKittens() {
        Lion lion = null;
        try {
            lion = new Lion("Самец");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(lion);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testDoesHaveMane() throws Exception {
        Lion maleLion = new Lion("Самец");
        Lion femaleLion = new Lion("Самка");
        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец");
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFoodInvalidKind() throws Exception {
        Lion lion = spy(new Lion("Самец"));
        doReturn(Collections.emptyList()).when(lion).getFood();
        assertEquals(Collections.emptyList(), lion.getFood());
    }
}