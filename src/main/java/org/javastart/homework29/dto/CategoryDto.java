package org.javastart.homework29.dto;

import org.javastart.homework29.model.Recipe;

import java.util.List;

public class CategoryDto {

    private String name;
    private String description;
    private String url;
    private List<Recipe> recipies;

    public CategoryDto(String name, String description, String url, List<Recipe> recipies) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.recipies = recipies;
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

    public List<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<Recipe> recipies) {
        this.recipies = recipies;
    }
}
