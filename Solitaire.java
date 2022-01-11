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
        Scanner scan = new Scanner(System.in);
        boolean winner = true;
        
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
        ArrayList<Card> stackDiscard = new ArrayList();
        printBoard(stackDiscard, one, two, three, four, five, six, seven, oneshow, twoshow, threeshow, fourshow, fiveshow, sixshow, sevenshow);
        
        int take = 0;
        int takeAmount=0;
        int place = 0;
        
        
        while(winner){
            if(stackDiscard.isEmpty()&&stack.isEmpty())
                winner=false;
            if(one.size()>=13){ //clear if full
                one.clear();
                oneshow = 0;
            }
            if(two.size()>=13){
                two.clear();
                twoshow = 0;
            }
            if(three.size()>=13){
                three.clear();
                threeshow = 0;
            }
            if(four.size()>=13){
                four.clear();
                fourshow = 0;
            }
            if(five.size()>=13){
                five.clear();
                fiveshow = 0;
            }
            if(six.size()>=13){
                six.clear();
                sixshow = 0;
            }
            if(seven.size()>=13){
                seven.clear();
                sevenshow = 0;
            }
            
            System.out.println("\n\n(0) = The stack\n(1-7) = the board\n(8) = draw three more cards\nplease select to draw or take: ");
            take = scan.nextInt();//option
            while(take>8||take<0){//out of bounds catch
                System.out.println("Please enter an option that is 0-8:");
                take = scan.nextInt();
            }
            while(stackDiscard.size()==0&&take==0){//try to take from empty discard catcher
                System.out.println("There is nothing in the stack you can play, please choose another option:");
                take = scan.nextInt();
            }
            if(take<=7&&take>=0){//if simple take and place
                if(take==0){
                    takeAmount=1;
                }
                else{//engine to check if you can take amount of cards from a stack
                    System.out.println("How many cards do you want to move from this pile?");
                    takeAmount=scan.nextInt();
                    while(take==1&&takeAmount>oneshow) {
                        System.out.println("You can only move up to "+oneshow+" cards from this pile; please choose a valid amount (0-"+oneshow+"):");
                        takeAmount=scan.nextInt();
                    }  
                    while(take==2&&takeAmount>twoshow) {
                        System.out.println("You can only move up to "+twoshow+" cards from this pile; please choose a valid amount (0-"+twoshow+"):");
                        takeAmount=scan.nextInt();
                    }
                    while(take==3&&takeAmount>threeshow) {
                        System.out.println("You can only move up to "+threeshow+" cards from this pile; please choose a valid amount (0-"+threeshow+"):");
                        takeAmount=scan.nextInt();
                    }
                    while(take==4&&takeAmount>fourshow) {
                        System.out.println("You can only move up to "+fourshow+" cards from this pile; please choose a valid amount (0-"+fourshow+"):");
                        takeAmount=scan.nextInt();
                    }
                    while(take==5&&takeAmount>fiveshow) {
                        System.out.println("You can only move up to "+fiveshow+" cards from this pile; please choose a valid amount (0-"+fiveshow+"):");
                        takeAmount=scan.nextInt();
                    }
                    while(take==6&&takeAmount>sixshow) {
                        System.out.println("You can only move up to "+sixshow+" cards from this pile; please choose a valid amount (0-"+sixshow+"):");
                        takeAmount=scan.nextInt();
                    }
                    while(take==7&&takeAmount>sevenshow) {
                        System.out.println("You can only move up to "+sevenshow+" cards from this pile; please choose a valid amount (0-"+sevenshow+"):");
                        takeAmount=scan.nextInt();
                    }
                }
                
                
                System.out.println("Please enter what pile (1-7) you want to move to: ");
                place = scan.nextInt();
                while(place>7||place<1){
                    System.out.println("Please enter a number that is 1-7:");
                    place = scan.nextInt();
                }
            }    
            else if(take==8){
                if(stack.size()==0){//if discard needs to go back to stack
                    for(int a = stackDiscard.size()-1;a>0;a--){
                        stack.add(stackDiscard.get(a));
                        stackDiscard.remove(a);
                    }
                }
                else if(stack.size()<3&&stack.size()>0){//if draw and nearly empty
                    for(int a = stack.size()-1; a>=0;a--){
                    stackDiscard.add(stack.get(a));
                    stack.remove(a);
                    }
                }
                
                else{ //if draw with room
                    for(int a = 3; a>0; a--){
                        stackDiscard.add(stack.get(stack.size()-1));
                    stack.remove(stack.size()-1);
                    }
                }
        }
        System.out.println();
        tempStack.clear();
        Card temp = new Card();
        if(isLegal(stackDiscard, one, two, three, four, five, six, seven, take, place, takeAmount)&&take!=8){//move the cards
            switch(take){
                case 0:
                    tempStack.add(stackDiscard.get(stackDiscard.size()-1));
                    stackDiscard.remove(stackDiscard.size()-1);
                    break;
                case 1:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(one.get(one.size()-1));
                    one.remove(one.size()-1);
                    }
                    oneshow=1;
                    break;
                case 2:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(two.get(two.size()-1));
                    two.remove(two.size()-1);
                    }
                    twoshow=1;
                    break;
                case 3:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(three.get(three.size()-1));
                    three.remove(three.size()-1);
                    }
                    threeshow=1;
                    break;
                case 4:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(four.get(four.size()-1));
                    four.remove(four.size()-1);
                    }
                    fourshow=1;
                    break;
                case 5:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(five.get(five.size()-1));
                    five.remove(five.size()-1);
                    }
                    fiveshow=1;
                    break;
                case 6:
                    for(int a = takeAmount;a>0;a--){
                    tempStack.add(six.get(six.size()-1));
                    six.remove(six.size()-1);
                    }
                    sixshow=1;
                    break;
                case 7:
                    for(int a = takeAmount;a>0;a--){
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
        else{
            if(take!=8&&!isLegal(stackDiscard, one, two, three, four, five, six, seven, take, place, takeAmount))
            System.out.println("\nThat is an illegal move");
            
        }
        
        
        printBoard(stackDiscard, one, two, three, four, five, six, seven, oneshow, twoshow, threeshow, fourshow, fiveshow, sixshow, sevenshow);
        
    }
        
        
        for(int a = 0; a<200; a++){
            
            System.out.println("YOU WON!! \n    YOU WON!! \n        YOU WON!!\n    YOU WON!!");
        }
        System.out.println("YOU WON!!");
        
        
        
        
    }
    public static boolean isLegal(ArrayList<Card> stackDiscard, ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three, 
            ArrayList<Card> four, ArrayList<Card> five, ArrayList<Card> six, ArrayList<Card> seven, int take, int place,
            int takeAmount){
        if(take==8)
            return false;
        Card tempTake = new Card();
        Card tempPlace = new Card();
        boolean legal = true;
        switch(take){
            case 0:
                tempTake = stackDiscard.get(stackDiscard.size()-1);
                break;
            case 1:
                tempTake= one.get(one.size()-takeAmount);
                break;
            case 2:
                tempTake= two.get(two.size()-takeAmount);
                break;
            case 3:
                tempTake= three.get(three.size()-takeAmount);
                break;
            case 4:
                tempTake= four.get(four.size()-takeAmount);
                break;
            case 5:
                tempTake= five.get(five.size()-takeAmount);
                break;
            case 6:
                tempTake= six.get(six.size()-takeAmount);
                break;
            case 7:
                tempTake= seven.get(seven.size()-takeAmount);
                break;
        }
        switch(place){
            case 1:
                if(one.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(one.size()==0)
                    return false;
                tempPlace= one.get(one.size()-1);
                break;
            case 2:
                if(two.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(two.size()==0)
                    return false;
                tempPlace= two.get(two.size()-1);
                break;
            case 3:
                if(three.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(three.size()==0)
                    return false;
                tempPlace= three.get(three.size()-1);
                break;
            case 4:
                if(four.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(four.size()==0)
                    return false;
                tempPlace= four.get(four.size()-1);
                break;
            case 5:
                if(five.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(five.size()==0)
                    return false;
                tempPlace= five.get(five.size()-1);
                break;
            case 6:
                if(six.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(six.size()==0)
                    return false;
                tempPlace= six.get(six.size()-1);
                break;
            case 7:
                if(seven.size()==0&&tempTake.getVal()==13)
                    return true;
                else if(seven.size()==0)
                    return false;
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
    
    
    
    
    public static void printBoard(ArrayList<Card> stackDiscard, ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three, 
            ArrayList<Card> four, ArrayList<Card> five, ArrayList<Card> six, ArrayList<Card> seven, 
            int oneshow, int twoshow, int threeshow, int fourshow, int fiveshow, int sixshow, int sevenshow){
        
        for(int a = 0; a<14; a++){
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
        if(stackDiscard.size()!=0)
        System.out.println(stackDiscard.get(stackDiscard.size()-1).getColor()+" "+stackDiscard.get(stackDiscard.size()-1).getVal()+"  ");
        else
            System.out.println("- - - - ");
    }
    
    
}
/*
1: make card class DONE
2: make randomized deck of cards DONE
3: fill board with cards DONE
4: display board per turn DONE
5: be able to move cards DONE
6: determine if card can be legally moved DONE
7: stack cards display + aside pile DONEE
*/
