package me.calebeoliveira.spring5recipeapp.converters;

import me.calebeoliveira.spring5recipeapp.commands.CategoryCommand;
import me.calebeoliveira.spring5recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {
    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;
    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void converterTestNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void converterTestEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convertTest() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}