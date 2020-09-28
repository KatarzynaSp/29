package org.javastart.homework29.service;

import org.javastart.homework29.dto.RecipeDto;
import org.javastart.homework29.form.RecipeForm;
import org.javastart.homework29.model.Category;
import org.javastart.homework29.model.Ingredient;
import org.javastart.homework29.model.Recipe;
import org.javastart.homework29.repository.IngredientRepository;
import org.javastart.homework29.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeDto> findAll() {
        List<Recipe> list = recipeRepository.findAll();
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RecipeDto toDto(Recipe recipe) {
        return new RecipeDto(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getUrl(), recipe.getCategory().getName(), recipe.getIngredients());
    }

    public RecipeDto findById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return toDto(recipe);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<RecipeDto> findByCategoryId(Long categoryId) {
        List<Recipe> recipes = recipeRepository.findRecipesByCategoryId(categoryId);
        return recipes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

//    public List<Recipe> findRecipesByCategoryId(Long categoryId) {
//        return recipeRepository.findRecipesByCategoryId(categoryId);
//    }


    //    public Recipe findById(Long id) {
//        return Optional.ofNullable(findById(id)).orElseThrow();
//    }

    //
    public void save(RecipeForm recipeForm) {
        Category categoryName = recipeForm.getCategory();
        Category category = recipeRepository.findCategoryByName(categoryName);

        List<Ingredient> ingredients = recipeForm.getIngredients();
        List<Ingredient> ingredients1 = ingredientRepository.saveAll(ingredients);

        Recipe recipe = new Recipe(recipeForm.getName(), recipeForm.getDescription(), recipeForm.getUrl(), ingredients1, category);
        recipeRepository.save(recipe);
    }
}
