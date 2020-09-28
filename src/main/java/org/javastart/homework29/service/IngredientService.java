package org.javastart.homework29.service;

import org.javastart.homework29.dto.IngredientDto;
import org.javastart.homework29.model.Ingredient;
import org.javastart.homework29.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDto> findAll() {
        List<Ingredient> list = ingredientRepository.findAll();
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private IngredientDto toDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.getAmount());
    }


    public void saveAll(List<Ingredient> ingredients) {
        saveAll(ingredients);
    }
}
