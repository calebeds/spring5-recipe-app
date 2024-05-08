package me.calebeoliveira.spring5recipeapp.controllers;

import me.calebeoliveira.spring5recipeapp.domain.Category;
import me.calebeoliveira.spring5recipeapp.domain.UnitOfMeasure;
import me.calebeoliveira.spring5recipeapp.repositories.CategoryRepository;
import me.calebeoliveira.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is " + categoryOptional.get().getId());
        System.out.println("UOM ID is " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
