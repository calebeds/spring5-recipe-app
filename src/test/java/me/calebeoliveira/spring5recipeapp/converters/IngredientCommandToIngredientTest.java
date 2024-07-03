package me.calebeoliveira.spring5recipeapp.converters;

import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;
import me.calebeoliveira.spring5recipeapp.commands.UnitOfMeasureCommand;
import me.calebeoliveira.spring5recipeapp.domain.Ingredient;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private static final Recipe RECIPE = new Recipe();
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String DESCRIPTION = "Cheeseburger";
    private static final Long ID_VALUE = 1L;
    private static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void convertTestNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertTestNotNull() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convertTest() {
        //given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);

        IngredientCommand command = IngredientCommand.builder()
                .id(ID_VALUE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .unitOfMeasure(unitOfMeasureCommand)
                .build();

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        //given
        IngredientCommand command = IngredientCommand.builder()
                .id(ID_VALUE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .build();

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }
}