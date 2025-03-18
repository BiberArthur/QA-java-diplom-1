package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock1;
    private Ingredient ingredientMock2;

    @Before
    public void setUp() {
        burger = new Burger();
        bunMock = mock(Bun.class);
        ingredientMock1 = mock(Ingredient.class);
        ingredientMock2 = mock(Ingredient.class);

        // Настройка поведения мока булки
        when(bunMock.getName()).thenReturn("Mock Bun");
        when(bunMock.getPrice()).thenReturn(100f);
        burger.setBuns(bunMock);

        // Настройка поведения ингредиентов
        when(ingredientMock1.getName()).thenReturn("Ketchup");
        when(ingredientMock1.getPrice()).thenReturn(20f);
        when(ingredientMock1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock2.getName()).thenReturn("Cutlet");
        when(ingredientMock2.getPrice()).thenReturn(50f);
        when(ingredientMock2.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testAddIngredientWithMocks() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        assertEquals("Проверка, что два ингредиента добавлены", 2, burger.ingredients.size());
        assertEquals("Проверка первого ингредиента", ingredientMock1, burger.ingredients.get(0));
        assertEquals("Проверка второго ингредиента", ingredientMock2, burger.ingredients.get(1));
    }

    @Test
    public void testRemoveIngredientWithMocks() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.removeIngredient(1); // Удаляем второй ингредиент

        assertEquals("Проверка, что остался только один ингредиент", 1, burger.ingredients.size());
        assertEquals("Проверка, что остался правильный ингредиент", ingredientMock1, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredientWithMocks() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0, 1); // Перемещаем ingredientMock1 на вторую позицию

        assertEquals("Проверка, что первый ингредиент перемещен на вторую позицию", ingredientMock2, burger.ingredients.get(0));
        assertEquals("Проверка, что второй ингредиент теперь первый", ingredientMock1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPriceWithMocks() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        float expectedPrice = bunMock.getPrice() * 2 + ingredientMock1.getPrice() + ingredientMock2.getPrice();

        assertEquals("Проверка итоговой цены", expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceiptWithMocks() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        String expectedReceipt =
                String.format("(==== %s ====)%n", bunMock.getName()) +
                        String.format("= sauce %s =%n", ingredientMock1.getName()) +
                        String.format("= filling %s =%n", ingredientMock2.getName()) +
                        String.format("(==== %s ====)%n", bunMock.getName()) +
                        String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals("Проверка чека", expectedReceipt, burger.getReceipt());
    }
}