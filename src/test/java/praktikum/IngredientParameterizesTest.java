package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientParameterizesTest {

    private IngredientType type;
    private String name;
    private float price;

    private Ingredient ingredient;

    public IngredientParameterizesTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    // Метод для предоставления данных для параметризованных тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.SAUCE, "hot sauce", 150},
                {IngredientType.SAUCE, "sour cream", 250},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "sausage", 300}
        });
    }

    @Before
    public void setUp() {
        // Создаем объект Ingredient
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName()); // Проверяем, что имя соответствует ожидаемому
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0.01); // Проверяем, что цена соответствует ожидаемому
    }

    @Test
    public void testGetType() {
        assertEquals(type, ingredient.getType()); // Проверяем, что тип соответствует ожидаемому
    }
}





