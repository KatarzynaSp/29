package org.javastart.homework29.controller;

import org.javastart.homework29.repository.CategoryRepository;
import org.javastart.homework29.repository.IngredientRepository;
import org.javastart.homework29.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private CategoryRepository categoryRepository;

    @Autowired

    public HomeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recipies", recipeRepository.findAll().stream().limit(8).collect(Collectors.toList()));
        model.addAttribute("category", categoryRepository.findAll());
        return "home";
    }
}