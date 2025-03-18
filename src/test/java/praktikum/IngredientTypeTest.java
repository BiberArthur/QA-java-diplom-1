package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        // Проверка наличия всех значений перечисления
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};
        assertArrayEquals(expectedTypes, IngredientType.values());
    }

    @Test
    public void testIngredientTypeUsage() {
        // Создаем ингредиент и проверяем его тип
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("Проверка типа соуса", IngredientType.SAUCE, sauce.getType());

        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 150);
        assertEquals("Проверка типа начинки", IngredientType.FILLING, filling.getType());
    }

}