package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        // Проверка наличия всех значений перечисления
        IngredientType[] expectedTypes = { IngredientType.SAUCE, IngredientType.FILLING };
        assertArrayEquals(expectedTypes, IngredientType.values());
    }

    @Test
    public void testIngredientTypeUsage() {
        // Создаем ингредиент и проверяем его тип
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(IngredientType.SAUCE, sauce.getType());

        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 150);
        assertEquals(IngredientType.FILLING, filling.getType());
    }

}


