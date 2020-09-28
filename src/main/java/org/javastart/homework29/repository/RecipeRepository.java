package org.javastart.homework29.repository;

import org.javastart.homework29.model.Category;
import org.javastart.homework29.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipesByCategoryId(Long categoryId);

    Category findCategoryByName(Category categoryName);


}