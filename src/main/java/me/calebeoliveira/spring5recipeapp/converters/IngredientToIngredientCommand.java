package me.calebeoliveira.spring5recipeapp.converters;

import lombok.Synchronized;
import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;
import me.calebeoliveira.spring5recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if(source == null) {
            return null;
        }

        return IngredientCommand.builder()
                .id(source.getId())
                .amount(source.getAmount())
                .description(source.getDescription())
                .uom(uomConverter.convert(source.getUom()))
                .build();
    }
}
