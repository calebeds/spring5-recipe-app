package me.calebeoliveira.spring5recipeapp.repositories;

import me.calebeoliveira.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
