/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire;
import java.util.*;
/**
 *
 * @author ethan
 */
public class Solitaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test card
        Card jack_red = new Card("red", 11);
        System.out.println(jack_red.getVal());
        
        
        
        
        //make array with all cards in random order
        
         ArrayList<Card> tempStack = new ArrayList<Card>();
         for(int a = 1; a<14;a++){  //stack of cards in order
            for(int b = 0;b<4;b++){
                if(b==0||b==1)
                    tempStack.add(new Card("black",a));
                else if(b==2||b==3)
                    tempStack.add(new Card("red",a));
                else
                    System.out.println("problem with cards in stack in order");
            }
        }
        ArrayList<Card> stack = new ArrayList<Card>();
        while(stack.size()>0){//shuffle into new deck 
            int index = (int)((Math.random())*tempStack.size());
            stack.add(tempStack.get(index));
            tempStack.remove(index);
        }
         
        //fill board with cards
        
        ArrayList<Card> one = new ArrayList<Card>();
        ArrayList<Card> two = new ArrayList<Card>();
        ArrayList<Card> three = new ArrayList<Card>();
        ArrayList<Card> four = new ArrayList<Card>();
        ArrayList<Card> five = new ArrayList<Card>();
        ArrayList<Card> six = new ArrayList<Card>();
        ArrayList<Card> seven = new ArrayList<Card>();
        for(int a = 0; a<7; a++){
            for(int b = 6;b>0;b++){
                
                
            }
        }
     
    }
    public static void printCard(Card temp){
        System.out.print(temp.getColor()+" "+temp.getVal());
    }
}
/*
1: make card class DONE
2: make randomized deck of cards DONE
3: fill board with cards 
4: display board per turn
5: be able to move cards






*/