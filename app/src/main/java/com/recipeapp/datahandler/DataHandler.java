package com.recipeapp.datahandler;
import com.recipeapp.model.Recipe;
import java.util.ArrayList;

public interface DataHandler {
    /*
     * getMode	String	なし	なし	現在のモードを返します。
readData	ArrayList<Recipe>	なし	IOException	レシピデータを読み込み、Recipeオブジェクトのリストとして返します。
writeData	void	Recipe recipe	IOException	指定されたRecipeオブジェクトを追加します。
searchData	ArrayList<Recipe>	String keyword	IOException	指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返します。

     */
    public String getMode();
    public ArrayList<Recipe> readData();

    public void writeData(Recipe recipe);
    public ArrayList<Recipe> searchData(String keyword);
    
}
