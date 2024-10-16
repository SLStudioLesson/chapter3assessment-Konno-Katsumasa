package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler{
    //filePath	String	レシピデータを格納するCSVファイルのパス。
    private String filePath;

    /*コンストラクタ
     * CSVDataHandler()	フィールドfilePathにapp/src/main/resources/recipes.csvを代入する
     * CSVDataHandler(String filePath)	フィールドfilePathに引数を代入する
     */
    public CSVDataHandler(){
        filePath = "app/src/main/resources/recipes.csv";
    }
    
    public CSVDataHandler(String filePath){

    }
    /*めそっど
     * getMode	文字列CSVを返してください。
     * readData	以降の設問で処理を実装するため定義し、nullをreturnしてください。
     * writeData	以降の設問で処理を実装するため定義のみ行います。
     * searchData	以降の設問で処理を実装するため定義し、nullをreturnしてください。
     */
    @Override
    public String getMode(){
        return "CSV";
    }
    @Override
    public ArrayList<Recipe> readData(){
        //recipes.csvからレシピデータを読み込み、それをリスト形式で返します。
        // try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        //     ArrayList<Recipe> recipes = new ArrayList<>();
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         // recipes.add(line);
        //         return ArrayList<>;
                
        //     }
        // }catch(IOException e){
        //     e.printStackTrace();
        // }
        return null;
    }
    @Override
    public void writeData(Recipe recipe){
        
    }
    @Override
    public ArrayList<Recipe> searchData(String keyword){
        return null;
    }

}
