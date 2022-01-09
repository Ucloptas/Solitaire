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
        
        Scanner scan = new Scanner(System.in);
        
        
        //make array with all cards in random order
        
         ArrayList<Card> tempStack = new ArrayList<>();
         for(int a = 1; a<14;a++){  //stack of cards in order
            for(int b = 0;b<4;b++){
                switch (b) {
                    case 0:
                    case 1:
                        if(a<10)
                            tempStack.add(new Card("black  ",a));
                        if(a>=10)
                            tempStack.add(new Card("black ",a));
                        break;
                    case 2:
                    case 3:
                        if(a<10)
                            tempStack.add(new Card("red    ",a));
                        if(a>=10)
                            tempStack.add(new Card("red   ",a));
                        break;
                    default:
                        System.out.println("problem with cards in stack in order");
                        break;
                }
            }
        }
        ArrayList<Card> stack = new ArrayList<>();
        while(stack.size()<52){//shuffle into new deck 
            int index = (int)((Math.random())*tempStack.size());
            stack.add(tempStack.get(index));
            tempStack.remove(index);
        }
        System.out.println(stack.size());
        //fill board with cards
        
        ArrayList<Card> one = new ArrayList<>();
        int oneshow = 1;
        ArrayList<Card> two = new ArrayList<>();
        int twoshow = 1;
        ArrayList<Card> three = new ArrayList<>();
        int threeshow=1;
        ArrayList<Card> four = new ArrayList<>();
        int fourshow=1;
        ArrayList<Card> five = new ArrayList<>();
        int fiveshow=1;
        ArrayList<Card> six = new ArrayList<>();
        int sixshow = 1;
        ArrayList<Card> seven = new ArrayList<>();
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
        
        int take = 0;
        int place = 0;
        
        
        while(true){
        System.out.println("\n\n\nTop of loop. please enter what pile (1-7) you want to move from: ");
        take = scan.nextInt();
        while(take>7||take<1){
            System.out.println("Please enter a number that is 1-7:");
            take = scan.nextInt();
        }
        System.out.println("Please enter what pile (1-7) you want to move to: ");
        place = scan.nextInt();
        while(place>7||place<1){
            System.out.println("Please enter a number that is 1-7:");
            place = scan.nextInt();
        }
        tempStack.clear();
        Card temp = new Card();
        if(isLegal(one, two, three, four, five, six, seven, take, place, oneshow, twoshow, threeshow, fourshow, fiveshow, sixshow, sevenshow)){//move the cards
            switch(take){
                case 1:
                    for(int a = oneshow;a>0;a--){
                    tempStack.add(one.get(one.size()-1));
                    one.remove(one.size()-1);
                    }
                    oneshow=1;
                    break;
                case 2:
                    for(int a = twoshow;a>0;a--){
                    tempStack.add(two.get(two.size()-1));
                    two.remove(two.size()-1);
                    }
                    oneshow=1;
                    break;
                case 3:
                    for(int a = threeshow;a>0;a--){
                    tempStack.add(three.get(three.size()-1));
                    three.remove(three.size()-1);
                    }
                    oneshow=1;
                    break;
                case 4:
                    for(int a = fourshow;a>0;a--){
                    tempStack.add(four.get(four.size()-1));
                    four.remove(four.size()-1);
                    }
                    fourshow=1;
                    break;
                case 5:
                    for(int a = fiveshow;a>0;a--){
                    tempStack.add(five.get(five.size()-1));
                    five.remove(five.size()-1);
                    }
                    fiveshow=1;
                    break;
                case 6:
                    for(int a = sixshow;a>0;a--){
                    tempStack.add(six.get(six.size()-1));
                    six.remove(six.size()-1);
                    }
                    sixshow=1;
                    break;
                case 7:
                    for(int a = sevenshow;a>0;a--){
                    tempStack.add(seven.get(seven.size()-1));
                    seven.remove(seven.size()-1);
                    }
                    sevenshow=1;
                    break;     
            }
            switch(place){
                case 1:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    one.add(tempStack.get(a));
                    oneshow++;
                    }
                    break;
                case 2:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    two.add(tempStack.get(a));
                    twoshow++;
                    }
                    break;
                case 3:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    three.add(tempStack.get(a));
                    threeshow++;
                    }
                    break;
                case 4:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    four.add(tempStack.get(a));
                    fourshow++;
                    }
                    break;
                case 5:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    five.add(tempStack.get(a));
                    fiveshow++;
                    }
                    break;
                case 6:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    six.add(tempStack.get(a));
                    sixshow++;
                    }
                    break;
                case 7:
                    for(int a = tempStack.size()-1;a>=0;a--){
                    seven.add(tempStack.get(a));
                    sevenshow++;
                    }
                    break;   


            }
            tempStack.clear();
        }
        else
            System.out.println("That is an illegal move");
        printBoard(one, two, three, four, five, six, seven, oneshow, twoshow, threeshow, fourshow, fiveshow, sixshow, sevenshow);
        
    }
        
        
        
        
        
        
        
        
    }
    public static boolean isLegal(ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three, 
            ArrayList<Card> four, ArrayList<Card> five, ArrayList<Card> six, ArrayList<Card> seven, int take, int place,
            int oneshow, int twoshow, int threeshow, int fourshow, int fiveshow, int sixshow, int sevenshow){
        Card tempTake = new Card();
        Card tempPlace = new Card();
        boolean legal = true;
        switch(take){
            case 1:
                tempTake= one.get(one.size()-oneshow);
                break;
            case 2:
                tempTake= two.get(two.size()-twoshow);
                break;
            case 3:
                tempTake= three.get(three.size()-threeshow);
                break;
            case 4:
                tempTake= four.get(four.size()-fourshow);
                break;
            case 5:
                tempTake= five.get(five.size()-fiveshow);
                break;
            case 6:
                tempTake= six.get(six.size()-sixshow);
                break;
            case 7:
                tempTake= seven.get(seven.size()-sevenshow);
                break;
        }
        switch(place){
            case 1:
                tempPlace= one.get(one.size()-1);
                break;
            case 2:
                tempPlace= two.get(two.size()-1);
                break;
            case 3:
                tempPlace= three.get(three.size()-1);
                break;
            case 4:
                tempPlace= four.get(four.size()-1);
                break;
            case 5:
                tempPlace= five.get(five.size()-1);
                break;
            case 6:
                tempPlace= six.get(six.size()-1);
                break;
            case 7:
                tempPlace= seven.get(seven.size()-1);
                break;
        }
        if(tempTake.getColor().compareTo(tempPlace.getColor())==0)
            legal = false;
        if(tempTake.getVal()+1!=tempPlace.getVal())
            legal = false;
        
        return legal;
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
    
    
}
/*
1: make card class DONE
2: make randomized deck of cards DONE
3: fill board with cards DONE
4: display board per turn DONE
5: be able to move cards DONE
6: determine if card can be legally moved DONE
7: stack cards display + aside pile






*/
