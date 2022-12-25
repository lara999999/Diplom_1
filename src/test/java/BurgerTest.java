import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {
    @Test
    public void getPriceCorrect() {

        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        Bun bun = Mockito.mock(Bun.class);
        buns.add(bun);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Ingredient ingredient= Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        burger.ingredients.add(ingredient);
        burger.setBuns(buns.get(0));
        float actualPrice= burger.getPrice();
        assertEquals("Another price", 6, actualPrice, 0.0f);


    }
    @Test
    public void getReceiptCorrect() {

        Burger burger = new Burger();
        List<Bun> buns = new ArrayList<>();
        Bun bun = Mockito.mock(Bun.class);
        buns.add(bun);
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(bun.getName()).thenReturn("Test");
        Ingredient ingredient= Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);
        Mockito.when(ingredient.getName()).thenReturn("Test");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        burger.ingredients.add(ingredient);

        burger.setBuns(buns.get(0));

        String actualReceipt= burger.getReceipt();
        String upBun ="(==== Test ====)";
        String inBurger="= sauce Test =";
        String downBun="(==== Test ====)";
        String priceBurger="Price: 6,000000";
        MatcherAssert.assertThat(actualReceipt, allOf(startsWith(upBun), containsString(inBurger), containsString(downBun),containsString(priceBurger)));
    }
    @Mock
    Bun bun;
    Ingredient ingredient;

    @Test
    public void setBunsCorrect() {
        List<Bun> buns = new ArrayList<>();
        Burger burger = new Burger();
        burger.setBuns(bun);
        buns.add(bun);
        assertEquals(false, buns.isEmpty());

    }
    @Test
    public void addIngredientCorrect() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(false, burger.ingredients.isEmpty());

    }

    @Test
    public void removeIngredientCorrect() {

        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals(true, burger.ingredients.isEmpty());
    }

    @Mock
    Ingredient ingredientTwo;


    @Test
    public void moveIngredientCorrect() {

        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredientTwo);
        burger.moveIngredient(0, 1);
        int actualIndex = burger.ingredients.indexOf(ingredient);
        assertEquals(0, actualIndex);
    }
}
