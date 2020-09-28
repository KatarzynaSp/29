package org.javastart.homework29.dto;


import org.javastart.homework29.model.Ingredient;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {
    private Long id;

    private String name;
    private String description;
    private String url;
    private String category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Ingredient> ingredientsDto = new ArrayList<>();


    public RecipeDto(Long id, String name, String description, String url, String category, List<Ingredient> ingredientsDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.ingredientsDto = ingredientsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Ingredient> getIngredientsDto() {
        return ingredientsDto;
    }

    public void setIngredientsDto(List<Ingredient> ingredientsDto) {
        this.ingredientsDto = ingredientsDto;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
