package me.calebeoliveira.spring5recipeapp.converters;

import lombok.Synchronized;
import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;
import me.calebeoliveira.spring5recipeapp.commands.UnitOfMeasureCommand;
import me.calebeoliveira.spring5recipeapp.domain.Ingredient;
import me.calebeoliveira.spring5recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if(source == null) {
            return null;
        }

        return Ingredient.builder()
                .id(source.getId())
                .amount(source.getAmount())
                .description(source.getDescription())
                .uom(uomConverter.convert(source.getUnitOfMeasure()))
                .build();
    }
}
