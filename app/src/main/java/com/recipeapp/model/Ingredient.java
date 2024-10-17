package com.recipeapp.model;
public class Ingredient {
    /*
     * フィールドはprivateで、コンストラクタ・メソッドはpublicで定義すること。
     * name	String	材料の名前
     */

     private String name;
     //コンストラクタ		String name	nameフィールドに、同名の引数を代入する
     public Ingredient(String name){
            this.name = name;
     }
    //getName	String	なし	nameフィールドを返す
    public String getName(){
        return name;
    }
}
