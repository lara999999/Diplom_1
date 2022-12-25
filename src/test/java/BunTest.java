import praktikum.Bun;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getBunNameCorrect() {

        Bun bun = new Bun("Бессмертный", 7.5f);
        String expectedBunName = "Бессмертный";

        String actualBunName = bun.getName();

        Assert.assertEquals("Another bun", expectedBunName, actualBunName);
    }
    @Test
    public void getBunPriceCorrect() {

        Bun bun = new Bun("Бессмертный", 7.5f);
        float expectedBunPrice = 7.5f;

        float actualBunPrice = bun.getPrice();

        Assert.assertEquals(expectedBunPrice, actualBunPrice,0.0f);
    }
}
