package me.calebeoliveira.spring5recipeapp.services;

import me.calebeoliveira.spring5recipeapp.commands.RecipeCommand;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
