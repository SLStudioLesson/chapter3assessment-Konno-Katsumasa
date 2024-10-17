package com.recipeapp.ui;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;
    
    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();
                /*
                 * displayRecipes void 引数なし なし - DataHandlerから読み込んだレシピデータを整形してコンソールに表示します。
                 * IOExceptionを受け取った場合はError reading file: 例外のメッセージとコンソールに表示します
                 * 表示形式は以下の出力例を再現してください。
                 */

                switch (choice) {
                    case "1":
                        displayRecipes();

                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() throws IOException {
        if (dataHandler.readData().size() > 1) {

            // Recipe型のリスト（空）を作成
            ArrayList<Recipe> recipesUi = new ArrayList<Recipe>();
            // recipesUi = dataHandler.readData();//ここにはレシピの名前と材料のIngedientのリストが含まれている
            CSVDataHandler csvDataHandler = new CSVDataHandler();
            recipesUi = csvDataHandler.readData();
            // Recipe recipe = dataHandler.readData();
            // リストにDataHandlerのreadDataメソッドで読み込んだ値を代入
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for (Recipe recipe : recipesUi) {
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Main Ingredients: ");
                ArrayList<Ingredient> ingredients = recipe.getIngredients();
                for (Ingredient ingredient : ingredients) {
                    System.err.print(ingredient.getName() + ",");
                }
                System.out.println();
                System.out.println("-----------------------------------");
                // for(Recipe inRecipe : recipesUi){
                // // ArrayList<Ingredient> ingredients = inRecipe.getIngredients();
                // // ingredients = new ArrayList<>();
                // //System.out.print(ingredients.getName());
                // System.out.println(inRecipe.getIngredients().getName());
                // }
                // System.out.println(recipe.getIngredients());
                // System.out.println(ingredients.getName());

            }
        } else {
            System.out.println("No recipes available.");
        }

        // if(recipesUi.size() > 0){
        // System.out.println("Recipes:");//レシピの中身があるなら表示する

        // }}
        // private void displayRecipes() throws IOException{
        // CSVDataHandler csvDataHandler = new CSVDataHandler();
        // ArrayList<Recipe> recipes = csvDataHandler.readData();

        // if (recipes.size() > 0) {
        // System.out.println("Recipes:");
        // for(int i = 0 ;i < recipes.size() ; i++){
        // System.out.println("-----------------------------------");
        // Recipe recipe = recipes.get(i).getName();
        // System.out.println("Recipe Name: "+ recipe.getName());
        // System.out.print("Main Ingredients: ");
        // for (int j = 0 ; j < recipe.getIngredients().size() ; j++){
        // System.out.print(recipe.getIngredients().get(j));
        // if (j == recipe.getIngredients().size()-1){
        // System.out.println();
        // } else {
        // System.out.print(", ");
        // }
        // }
        // }
        // } else {
        // System.out.println("No recipes available.");
        // }
        // }

        // recipesUi = csvDataHandler.readData();
        // for(int i = 0;i <recipesUi.size();i++){
        // }

        // for(String re :recipesUi){
        // System.out.println(re);
        // }

    }

    private void addNewRecipe() {
        try {
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String input = reader.readLine();
            System.out.print("Enter ingredients (type 'done' when finished):");
            ArrayList<Ingredient> ingredients = new ArrayList<>();

            
            while (true) {
                // ingredients.add(input2);
                System.out.print("Ingredient: ");
                String input2 = reader.readLine();
                // ingredients = ingredient.add(input2);
                
                if (input2.equals("done")) {
                    System.out.print("Recipe added successfully.");
                    break;
                }
                Ingredient ingredient = new Ingredient(input2);
                ingredients.add(ingredient);
            }

            // if (input2.equals("done")) {
            // System.out.print("Recipe added successfully.");

            // }else{
            // Recipe recipe = new Recipe(input,input2);
            // System.out.print("Ingredient: ");

            // }
            // ArrayList<Ingredient> i = new ArrayList<>();
            // i = input2;
            // Recipe mix = new Recipe(input, i);
            // String mix = input+input2;
            Recipe recipe = new Recipe(input, ingredients);
            dataHandler.writeData(recipe);

        } catch (IOException e) {

        }

    }
}
