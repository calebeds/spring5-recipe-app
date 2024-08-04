package me.calebeoliveira.spring5recipeapp.services;

import me.calebeoliveira.spring5recipeapp.converters.RecipeCommandToRecipe;
import me.calebeoliveira.spring5recipeapp.converters.RecipeToRecipeCommand;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import me.calebeoliveira.spring5recipeapp.exceptions.NotFoundException;
import me.calebeoliveira.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }
    @Test
    public void testGetRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void testGetRecipeByIdTest() throws Exception {
        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        //should go boom
    }

    @Test
    public void testGetRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(eq(1L));
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void testDeleteById() throws Exception {
        //given
        Long idToDelete = 2L;

        //when
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type
        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}