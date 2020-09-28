package org.javastart.homework29.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String url;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    private Category category;

//    @OneToMany(mappedBy = "like", cascade = CascadeType.ALL,  orphanRemoval = true)
//    private Map<Long, LikeIt> likeBox = new HashMap<Long, LikeIt>();


    public Recipe() {
    }


    public Recipe(String name, String description, String url, List<Ingredient> ingredients, Category category) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.ingredients = ingredients;
        this.category = category;
    }

    public Recipe(String name, String description, String url, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.ingredients = ingredients;
    }

    public Recipe(Long id, String name) {
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
//
//    public Map<Long, LikeIt> getLikeBox() {
//        return likeBox;
//    }
//
//    public void setLikeBox(Map<Long, LikeIt> likeBox) {
//        this.likeBox = likeBox;
//    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}


