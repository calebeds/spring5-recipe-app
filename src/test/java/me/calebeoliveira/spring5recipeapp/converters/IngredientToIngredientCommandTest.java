package me.calebeoliveira.spring5recipeapp.converters;

import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;
import me.calebeoliveira.spring5recipeapp.domain.Ingredient;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import me.calebeoliveira.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {
    private static final Recipe RECIPE = new Recipe();
    private static final BigDecimal AMOUNT = new BigDecimal("1");
    private static final String DESCRIPTION = "Cheeseburger";
    private static final Long ID_VALUE = 1L;
    private static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void convertTestNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertTestEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convertNullUOM() {
        //given
        Ingredient ingredient = Ingredient.builder()
                .id(ID_VALUE)
                .recipe(RECIPE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .uom(null)
                .build();

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertNull(ingredientCommand.getUom());
        assertEquals(ID_VALUE, ingredientCommand.getId());
    }

    @Test
    public void convertWithUom() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);

        Ingredient ingredient = Ingredient.builder()
                .id(ID_VALUE)
                .recipe(RECIPE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .uom(unitOfMeasure)
                .build();

        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUom());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());
    }
}