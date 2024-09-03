package me.calebeoliveira.spring5recipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import me.calebeoliveira.spring5recipeapp.domain.Category;
import me.calebeoliveira.spring5recipeapp.domain.Difficulty;
import me.calebeoliveira.spring5recipeapp.domain.Ingredient;
import me.calebeoliveira.spring5recipeapp.domain.Notes;
import me.calebeoliveira.spring5recipeapp.domain.Recipe;
import me.calebeoliveira.spring5recipeapp.domain.UnitOfMeasure;
import me.calebeoliveira.spring5recipeapp.repositories.CategoryRepository;
import me.calebeoliveira.spring5recipeapp.repositories.RecipeRepository;
import me.calebeoliveira.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@Profile({"dev", "prod"})
public class MysqlBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public MysqlBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(categoryRepository.count() == 0L) {
            log.debug("Loading categories");
            loadCategories();
        }

        if(unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUOMs();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat3.setDescription("Fast Food");
        categoryRepository.save(cat4);
    }

    private void loadUOMs() {
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Teaspoon");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Table spoon");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setDescription("Cup");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom4.setDescription("Pinch");
        unitOfMeasureRepository.save(uom4);

        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom5.setDescription("Ounce");
        unitOfMeasureRepository.save(uom5);

        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom6.setDescription("Each");
        unitOfMeasureRepository.save(uom6);

        UnitOfMeasure uom7 = new UnitOfMeasure();
        uom7.setDescription("Pint");
        unitOfMeasureRepository.save(uom7);

        UnitOfMeasure uom8 = new UnitOfMeasure();
        uom8.setDescription("Dash");
        unitOfMeasureRepository.save(uom8);

    }
}
