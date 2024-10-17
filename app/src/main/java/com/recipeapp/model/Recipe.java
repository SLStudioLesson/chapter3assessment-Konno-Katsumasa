package com.recipeapp.model;
import java.util.ArrayList;

// import com.recipeapp.model;

public class Recipe {
    /*
     * name	String	レシピの名前
     * ingredients	ArrayList<Ingredient>	レシピの材料リスト
     */
    private String name;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String name,ArrayList<Ingredient> ingredients){
        this.name = name;
        this.ingredients = ingredients;
        
    }
    
    
    /*メソッド
    * getName	String	なし	nameフィールドを返す
    * getIngredients	ArrayList<Ingredient>	なし	ingredientsフィールドを返す
    */
    public String getName(){
        return name;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    
    
    
}
