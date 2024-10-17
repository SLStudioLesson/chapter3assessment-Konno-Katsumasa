package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    // filePath String レシピデータを格納するCSVファイルのパス。
    private String filePath;

    /*
     * コンストラクタ
     * CSVDataHandler() フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
     * CSVDataHandler(String filePath) フィールドfilePathに引数を代入する
     */
    public CSVDataHandler() {
        filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {

    }

    /*
     * めそっど
     * getMode 文字列CSVを返してください。
     * readData 以降の設問で処理を実装するため定義し、nullをreturnしてください。
     * writeData 以降の設問で処理を実装するため定義のみ行います。
     * searchData 以降の設問で処理を実装するため定義し、nullをreturnしてください。
     */
    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() {
        // recipes.csvからレシピデータを読み込み、それをリスト形式で返します。
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(",", 2);
                // String[] str = line[1];
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] ingredientsArray = str[1].split(",");
                for (int i = 0; i < ingredientsArray.length; i++) {
                    Ingredient ig1 = new Ingredient(ingredientsArray[i]);
                    ingredients.add(ig1);
                }

                Recipe r1 = new Recipe(str[0], ingredients);
                recipes.add(r1);

                // r1.add(line[0]);
                // recipes.add(line);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipes;
        // return null;
    }

    @Override
    public void writeData(Recipe recipe) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            
            String str = recipe.getName()+",";
            for(Ingredient ing :recipe.getIngredients()){
                str += ing.getName()+",";
            }
            writer.write(str);
            writer.newLine();
        }catch(IOException e){

        }

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }

}
