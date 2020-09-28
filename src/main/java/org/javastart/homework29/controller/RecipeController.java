package org.javastart.homework29.controller;

import org.javastart.homework29.dto.CategoryDto;
import org.javastart.homework29.dto.RecipeDto;
import org.javastart.homework29.form.RecipeForm;
import org.javastart.homework29.model.Category;
import org.javastart.homework29.model.Ingredient;
import org.javastart.homework29.model.Recipe;
import org.javastart.homework29.service.CategoryService;
import org.javastart.homework29.service.IngredientService;
import org.javastart.homework29.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RecipeController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    private CategoryService categoryService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.categoryService = categoryService;
    }

    @Autowired
    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipe/{id}")
    public String findById(@PathVariable Long id, Model model) {
        RecipeDto recipeDto = recipeService.findById(id);

        List<Ingredient> ingredientsDto = recipeDto.getIngredientsDto();
        model.addAttribute("recipe", recipeDto);
        model.addAttribute("ingredients", ingredientsDto);
        model.addAttribute("category", categoryService.findAll());
        return "recipe";
    }

    @GetMapping("/allRecipies")
    public String findAll(Model model) {
        List<RecipeDto> allRecipies = recipeService.findAll();
        model.addAttribute("allRecipies", allRecipies);
        model.addAttribute("category", categoryService.findAll());
        return "allRecipies";
    }

    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable Long id) {
        recipeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/category/{categoryId}")
    public String recipiesBycategory(@PathVariable Long categoryId, Model model) {
        CategoryDto categoryDto = categoryService.findCategoryById(categoryId);
        List<RecipeDto> recipiesDto = recipeService.findByCategoryId(categoryId);
        model.addAttribute("categoryDto", categoryDto);
        model.addAttribute("recipiesDto", recipiesDto);
        return "category";
    }

    @GetMapping("/recipe/add")
    public String addRecipe(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ingredients.add(new Ingredient());
        }
        List<Category> categories = categoryService.findAll();
        Recipe recipe = new Recipe();
        recipe.setIngredients(ingredients);

        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("categories", categories);
        model.addAttribute("category", categoryService.findAll());
        return "add";
    }

    @PostMapping("/recipe/save")
    public void saveRecipe(@RequestBody RecipeForm recipeForm, BindingResult bindingResult) {

        recipeService.save(recipeForm);

//        ingredientService.saveAll(recipe.getIngredients());
//        recipe.getIngredients()
//                .forEach(ingredient -> ingredient.setRecipe(recipe));
//        recipeService.save(recipe);

//        model.addAttribute("allRecipies", recipeService.findAll());
    }
}