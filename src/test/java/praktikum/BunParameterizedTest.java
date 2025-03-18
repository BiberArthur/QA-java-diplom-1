package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final int price;

    public BunParameterizedTest(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
              //  {"invalid bun, 20}
        });
    }
    @Test
    public void testBunName() {
        Bun bun = new Bun(name, price);
        assertEquals("Имя булочки.", name, bun.getName());
    }
    @Test
    public void testBunPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булочки.", price, bun.getPrice(), 0.01);
    }

    }