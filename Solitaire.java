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
                if(b==0||b==1){
                    if(a<10)
                    tempStack.add(new Card("black  ",a));
                    if(a>=10)
                        tempStack.add(new Card("black ",a));
                }
                else if(b==2||b==3){
                    if(a<10)
                    tempStack.add(new Card("red    ",a));
                    if(a>=10)
                        tempStack.add(new Card("red   ",a));
                }
                else
                    System.out.println("problem with cards in stack in order");
            }
        }
        ArrayList<Card> stack = new ArrayList<Card>();
        while(stack.size()<52){//shuffle into new deck 
            int index = (int)((Math.random())*tempStack.size());
            stack.add(tempStack.get(index));
            tempStack.remove(index);
        }
        System.out.println(stack.size());
        //fill board with cards
        
        ArrayList<Card> one = new ArrayList<Card>();
        int oneshow = 1;
        ArrayList<Card> two = new ArrayList<Card>();
        int twoshow = 1;
        ArrayList<Card> three = new ArrayList<Card>();
        int threeshow=1;
        ArrayList<Card> four = new ArrayList<Card>();
        int fourshow=1;
        ArrayList<Card> five = new ArrayList<Card>();
        int fiveshow=1;
        ArrayList<Card> six = new ArrayList<Card>();
        int sixshow = 1;
        ArrayList<Card> seven = new ArrayList<Card>();
        int sevenshow = 1;
        for(int a = 0; a<7; a++){
            for(int b = 6;b>a-1;b--){
                switch(b){
                    case 6:
                        seven.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 5:
                        six.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 4:
                        five.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 3:
                        four.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 2:
                        three.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 1:
                        two.add(stack.get(0));
                        stack.remove(0);
                        break;
                    case 0:
                        one.add((Card)stack.get(0));
                        stack.remove(0);
                        break;
                }
                
            }
        }
        
        System.out.println(stack.size());
        printBoard(one, two, three, four, five, six, seven, oneshow, twoshow, threeshow, fourshow, fiveshow, sixshow, sevenshow);
        
        
        
        
        
        
        
        
        
        
    }
    public static void printCard(Card temp){
        System.out.print(temp.getColor()+" "+temp.getVal()+"  ");
    }
    public static void printBoard(ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three, 
            ArrayList<Card> four, ArrayList<Card> five, ArrayList<Card> six, ArrayList<Card> seven, 
            int oneshow, int twoshow, int threeshow, int fourshow, int fiveshow, int sixshow, int sevenshow){
        
        for(int a = 0; a<10; a++){
            if(one.size()-oneshow>a)
                System.out.print("- - - - -  ");
            else if(one.size()-1<a)
                System.out.print("           ");
            else
                printCard(one.get(a));
            
            if(two.size()-twoshow>a)
                System.out.print("- - - - -  ");
            else if(two.size()-1<a)
                System.out.print("           ");
            else
                printCard(two.get(a));
            
            if(three.size()-threeshow>a)
                System.out.print("- - - - -  ");
            else if(three.size()-1<a)
                System.out.print("           ");
            else
                printCard(three.get(a));
            
            if(four.size()-fourshow>a)
                System.out.print("- - - - -  ");
            else if(four.size()-1<a)
                System.out.print("           ");
            else
                printCard(four.get(a));
            
            if(five.size()-fiveshow>a)
                System.out.print("- - - - -  ");
            else if(five.size()-1<a)
                System.out.print("           ");
            else
                printCard(five.get(a));
            
            if(six.size()-sixshow>a)
                System.out.print("- - - - -  ");
            else if(six.size()-1<a)
                System.out.print("           ");
            else
                printCard(six.get(a));
            
           if(seven.size()-sevenshow>a)
                System.out.print("- - - - -  ");
            else if(seven.size()-1<a)
                System.out.print("           ");
            else 
                printCard(seven.get(a));
           System.out.println(); 
        }
        
        
        
        
    }
    public static void printBoardTest(ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three,ArrayList<Card> four,
            ArrayList<Card> five, ArrayList<Card> six, ArrayList<Card> seven){
        for(int a = 0; a<10; a++){
            if(one.size()>a)
            printCard(one.get(a)); 
            else
                System.out.print("           ");
            if(two.size()>a)
            printCard(two.get(a)); 
            else
                System.out.print("           ");
            if(three.size()>a)
            printCard(three.get(a)); 
            else
                System.out.print("           ");
            if(four.size()>a)
            printCard(four.get(a)); 
            else
                System.out.print("           ");
            if(five.size()>a)
            printCard(five.get(a)); 
            else
                System.out.print("           ");
            if(six.size()>a)
            printCard(six.get(a)); 
            else
                System.out.print("           ");
            if(seven.size()>a)
            printCard(seven.get(a)); 
            else
                System.out.print("           ");
            
           System.out.println(); 
        }
    }
    
}
/*
1: make card class DONE
2: make randomized deck of cards DONE
3: fill board with cards DONE
4: display board per turn DONE
5: be able to move cards






*/
