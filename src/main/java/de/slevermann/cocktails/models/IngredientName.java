package de.slevermann.cocktails.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class IngredientName {

    private Long id;

    private String name;

    private String locale;

    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @ToString.Exclude
    private Ingredient ingredient;
}
