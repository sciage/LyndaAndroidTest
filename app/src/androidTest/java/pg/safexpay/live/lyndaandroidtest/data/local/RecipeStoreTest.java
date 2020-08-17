package pg.safexpay.live.lyndaandroidtest.data.local;

import android.content.Context;

import androidx.test.espresso.internal.inject.InstrumentationContext;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import pg.safexpay.live.lyndaandroidtest.data.model.Recipe;

import static org.junit.Assert.*;

public class RecipeStoreTest {

    @Test
    public void nullDirectory() {
//        InstrumentationRegistry.getInstrumentation().getContext(); Returns context of the test
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());

    }
    @Test
    public void count() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(2, store.recipes.size());

    }

    @Test
    public void getCholcatePudding() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding", recipe.id);
        assertEquals("Chocolate Pudding", recipe.title);

    }
}