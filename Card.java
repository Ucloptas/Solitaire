/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire;

/**
 *
 * @author ethan
 */
public class Card {
    
    
    private String color = "blank"; 
    private int value = 0;
    public Card(){
        
        color=null;
        value=0;
    }
    public Card(String col, int val){
        color = col;
        value = val;
    }
    
    public int getVal(){
        return value;
    }
    public String getColor (){
        return color;
    }
}
