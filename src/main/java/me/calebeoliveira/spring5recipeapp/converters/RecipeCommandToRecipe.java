package me.calebeoliveira.spring5recipeapp.converters;

import lombok.Synchronized;
import me.calebeoliveira.spring5recipeapp.commands.RecipeCommand;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        final Recipe recipe = Recipe.builder()
                .id(source.getId())
                .description(source.getDescription())
                .difficulty(source.getDifficulty())
                .notes(notesConverter.convert(source.getNotes()))
                .url(source.getUrl())
                .image(source.getImage())
                .cookTime(source.getCookTime())
                .prepTime(source.getPrepTime())
                .directions(source.getDirections())
                .servings(source.getServings())
                .source(source.getSource())
                .build();

        if(source.getCategories() != null && !source.getCategories().isEmpty()) {
            recipe.setCategories(new HashSet<>());
            source.getCategories()
                    .forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }

        if(source.getIngredients() != null && !source.getIngredients().isEmpty()) {
            recipe.setIngredients(new HashSet<>());
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
