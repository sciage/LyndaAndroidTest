package pg.safexpay.live.lyndaandroidtest.data;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {

    // pass water to Recipe from txt.
    @Test
    public void water() {
        InputStream inputStream = Recipe.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(inputStream);
        // Recipe should not be null and it should contain id, title and description
        assertNotEquals(recipe, Recipe.class);
        assertEquals("water", recipe.id);

    }
}