package me.calebeoliveira.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import me.calebeoliveira.spring5recipeapp.commands.IngredientCommand;
import me.calebeoliveira.spring5recipeapp.converters.IngredientToIngredientCommand;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import me.calebeoliveira.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@Slf4j
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        Recipe recipe = recipeOptional.orElseThrow(() -> new RuntimeException("No Recipe Found"));

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();



        return ingredientCommandOptional.orElseThrow(() -> new RuntimeException("No Ingredient Found"));
    }
}
