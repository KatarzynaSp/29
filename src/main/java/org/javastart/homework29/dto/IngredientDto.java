package org.javastart.homework29.dto;

import javax.persistence.ManyToOne;

public class IngredientDto {
    private Long id;
    private String name;
    private String amount;

    @ManyToOne
    private RecipeDto recipeDto;


    public IngredientDto(Long id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
