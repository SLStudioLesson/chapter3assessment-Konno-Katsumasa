package com.recipeapp.datahandler;
import java.util.ArrayList;
import com.recipeapp.model.Recipe;
public class JSONDataHandler implements DataHandler{
    /*メソッド
     * getMode	文字列JSONを返してください。
     * readData	処理の実装は行わないので定義し、nullをreturnしてください。
     * writeData	処理の実装は行わないので定義のみ行います。
     * searchData	処理の実装は行わないので定義し、nullをreturnしてください。
     */
    @Override
    public String getMode(){
        return "JSON";
    }
    @Override
    public ArrayList<Recipe> readData(){
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
