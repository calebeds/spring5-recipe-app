package me.calebeoliveira.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import me.calebeoliveira.spring5recipeapp.commands.RecipeCommand;
import me.calebeoliveira.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String getRecipe(Model model, @PathVariable("id") String id) {
        log.debug("Getting recipe");

        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));

        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.parseLong(id)));
        return "recipe/recipeform";
    }

    @PostMapping( "/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return String.format("redirect:/recipe/%d/show/", savedCommand.getId());
    }

    @GetMapping("/recipe/{id}/delete")
    public String delete(@PathVariable String id) {
        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.parseLong(id));

        return "redirect:/";
    }
}
