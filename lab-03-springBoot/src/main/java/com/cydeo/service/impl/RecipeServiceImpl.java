package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Setter
//@AllArgsConstructor
@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;//constructor injection
    private final ShareService shareService;
    private final Faker faker;//to generate data and to test the program

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }

    @Override
    public boolean prepareRecipe() {

        for (int i = 0; i < 20; i++) { // 7  * 20 = 140

            Arrays.stream(RecipeType.values()).forEach(recipeType -> {  //Arrays - recipe type will be arrays
//create recipe for each recipe type
                Recipe recipe = new Recipe();
                recipe.setRecipeId(UUID.randomUUID());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
                recipe.setIngredients(prepareIngredient());
                recipe.setRecipeType(recipeType); //inside recipe variable
                recipeRepository.save(recipe);
                shareService.share(recipe);

            });
        }
        return true;
    }

    private List<Ingredient> prepareIngredient() {
        //create list of quantity type
        List<QuantityType> quantityTypeList = List.of(QuantityType.values());

        //for ingredients
        List<Ingredient> ingredientList = new ArrayList<>();

        for (int i = 0; i < generateRandomValue(); i++) {//add all ingredients in the list

            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));//3 value of QuantityType with Random will give randon

            ingredientList.add(ingredient);//to recipe.setIngredients(prepareIngredient());
        }
        return ingredientList;
    }

    private int generateRandomValue() {
        return new Random().nextInt(20);//create random number
    }


}
