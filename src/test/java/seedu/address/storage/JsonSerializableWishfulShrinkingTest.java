package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.WishfulShrinking;
import seedu.address.testutil.TypicalConsumption;
import seedu.address.testutil.TypicalIngredients;
import seedu.address.testutil.TypicalRecipes;

public class JsonSerializableWishfulShrinkingTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test",
            "data", "JsonSerializableWishfulShrinkingTest");
    private static final Path TYPICAL_RECIPES_FILE = TEST_DATA_FOLDER.resolve("typicalRecipesWishfulShrinking.json");
    private static final Path INVALID_RECIPE_FILE = TEST_DATA_FOLDER.resolve("invalidRecipeWishfulShrinking.json");
    private static final Path DUPLICATE_RECIPE_FILE = TEST_DATA_FOLDER.resolve("duplicateRecipeWishfulShrinking.json");
    private static final Path TYPICAL_INGREDIENTS_FILE =
            TEST_DATA_FOLDER.resolve("typicalIngredientsWishfulShrinking.json");
    private static final Path INVALID_INGREDIENT_FILE =
            TEST_DATA_FOLDER.resolve("invalidIngredientWishfulShrinking.json");
    private static final Path DUPLICATE_INGREDIENT_FILE =
            TEST_DATA_FOLDER.resolve("duplicateIngredientWishfulShrinking.json");
    private static final Path TYPICAL_CONSUMPTION_FILE =
            TEST_DATA_FOLDER.resolve("typicalConsumptionWishfulShrinking.json");
    private static final Path INVALID_CONSUMPTION_FILE =
            TEST_DATA_FOLDER.resolve("invalidConsumptionWishfulShrinking.json");

    @Test
    public void toModelType_typicalRecipesFile_success() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(TYPICAL_RECIPES_FILE,
                JsonSerializableWishfulShrinking.class).get();
        WishfulShrinking wishfulShrinkingFromFile = dataFromFile.toModelType();
        WishfulShrinking typicalRecipesWishfulShrinking = TypicalRecipes.getTypicalWishfulShrinking();
        assertEquals(wishfulShrinkingFromFile, typicalRecipesWishfulShrinking);
    }

    @Test
    public void toModelType_invalidRecipeFile_throwsIllegalValueException() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(INVALID_RECIPE_FILE,
                JsonSerializableWishfulShrinking.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateRecipes_throwsIllegalValueException() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(DUPLICATE_RECIPE_FILE,
                JsonSerializableWishfulShrinking.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableWishfulShrinking.MESSAGE_DUPLICATE_RECIPE,
                dataFromFile::toModelType);
    }

    @Test
    public void toModelType_typicalIngredientsFile_success() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(TYPICAL_INGREDIENTS_FILE,
                JsonSerializableWishfulShrinking.class).get();
        WishfulShrinking wishfulShrinkingFromFile = dataFromFile.toModelType();
        WishfulShrinking typicalIngredientsWishfulShrinking = TypicalIngredients.getTypicalWishfulShrinking();
        assertEquals(wishfulShrinkingFromFile, typicalIngredientsWishfulShrinking);
    }

    @Test
    public void toModelType_invalidIngredientFile_throwsIllegalValueException() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(INVALID_INGREDIENT_FILE,
                JsonSerializableWishfulShrinking.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateIngredients_throwsIllegalValueException() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(DUPLICATE_INGREDIENT_FILE,
                JsonSerializableWishfulShrinking.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableWishfulShrinking.MESSAGE_DUPLICATE_INGREDIENT,
                dataFromFile::toModelType);
    }

    @Test
    public void toModelType_typicalConsumptionFile_success() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(TYPICAL_CONSUMPTION_FILE,
                JsonSerializableWishfulShrinking.class).get();
        WishfulShrinking wishfulShrinkingFromFile = dataFromFile.toModelType();
        WishfulShrinking typicalConsumptionWishfulShrinking = TypicalConsumption.getTypicalWishfulShrinking();
        assertEquals(wishfulShrinkingFromFile, typicalConsumptionWishfulShrinking);
    }

    @Test
    public void toModelType_invalidConsumptionFile_throwsIllegalValueException() throws Exception {
        JsonSerializableWishfulShrinking dataFromFile = JsonUtil.readJsonFile(INVALID_CONSUMPTION_FILE,
                JsonSerializableWishfulShrinking.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

}
