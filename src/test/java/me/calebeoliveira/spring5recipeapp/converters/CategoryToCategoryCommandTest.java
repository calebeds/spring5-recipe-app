package me.calebeoliveira.spring5recipeapp.converters;

import me.calebeoliveira.spring5recipeapp.commands.CategoryCommand;
import me.calebeoliveira.spring5recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {
    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void convertTestNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertTestEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convertTest() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}