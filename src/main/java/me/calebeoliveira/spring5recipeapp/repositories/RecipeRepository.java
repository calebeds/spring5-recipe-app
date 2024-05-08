package me.calebeoliveira.spring5recipeapp.repositories;

import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
