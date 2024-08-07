package me.calebeoliveira.spring5recipeapp.services;

import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(long recipeId, long ingredientId);
}
