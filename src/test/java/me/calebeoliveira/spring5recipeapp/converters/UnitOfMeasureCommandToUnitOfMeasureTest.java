package me.calebeoliveira.spring5recipeapp.converters;

import me.calebeoliveira.spring5recipeapp.commands.UnitOfMeasureCommand;
import me.calebeoliveira.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {
    private static final Long LONG_VALUE = 1L;
    private static final String DESCRIPTION = "description";
    UnitOfMeasureCommandToUnitOfMeasure converter;
    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void convertTestNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convertTestEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}