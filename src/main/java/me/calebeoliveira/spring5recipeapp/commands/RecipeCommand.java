package me.calebeoliveira.spring5recipeapp.commands;

import lombok.*;
import me.calebeoliveira.spring5recipeapp.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private NotesCommand notes;
    private Byte[] image;
    private Difficulty difficulty;
    private Set<CategoryCommand> categories = new HashSet<>();
}
