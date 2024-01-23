package project;


import java.util.Random;
import java.util.Scanner;


public class Game{ 
	
    
    private Player p;
    private static final  int numberOfChances=5;
    private static final int max=10;
    private int currentChance;
    private int computerNum ;
    private  Scanner input ;
    
    
    public Game() { 
     input = new Scanner(System.in);
    System.out.println("Please enter your name: ");
    p= new Player(input.nextLine());
     System.out.printf("Guess the inetger between 1-10 \nyou have only %d chances#n",getNumberOfChances());
     System.out.println("your current points are 10 for each wrong quess you'll lose 2 points");
    
  }  //end method
    
    private void setCoumputerNum() {
    	Random rand= new Random();
    	computerNum= 1+rand.nextInt(getMax());
    } //end method
    
    
    
    private int getNumberOfChances() {
  	  return numberOfChances ;
    } //end method
    
    
    private int getMax() {
  	  return max ;
    } //end method
    
    
    public int getCurrentChance() {
  	  return currentChance;
    } //end method
    
    
    public int getComputerNum() {
    return computerNum;
    } //end method
  
   
    
    public void incrementCurrentChance() {
    	currentChance++;
    } //end method
    
    

  
  
   public void guessing() {
	   setCoumputerNum();
	   p.setPoints(10);
   System.out.println("Please enter your guess: ");
   for ( currentChance=0; getCurrentChance() < numberOfChances;incrementCurrentChance()) {
	   
	 try {
     int userGuess =input.nextInt();
     checkingValityOfTheGuess(userGuess);
     int check = compare(userGuess);
     
     if (check == -1) 
       break;}// end try
	 catch(IllegalArgumentException a) {
		 System.out.println(a.getMessage());
	 }// end chatch 
     
   }//end for 
   lossingCheck();
   
   } //end method
  
	   
   public void checkingValityOfTheGuess(int userGuess) {
		  if (userGuess>getMax()||userGuess<1) {
			  throw new IllegalArgumentException("you entered an invalid number");}
	  } //end method
  

   
   private int compare(int userGuess) { 
  
  if (userGuess < getComputerNum()) {
   lessThanComputerNum() ;
   return 0; }
  
  else if (userGuess > getComputerNum()) {
   higherThanComputerNum();
   return 0; }
  
  else {
   equalComputerNum();
   return -1; }

  
 } //end method
   
   
  
   private void lessThanComputerNum() {
	  
   System.out.printf("TOOO LOWWWW!!!!!, your left chances are %d\n ",getNumberOfChances()-(getCurrentChance()+1));
   p.subPoints();
 }//end method

   
   
  private void higherThanComputerNum(){
	
  System.out.printf("TOOO FARRRR!!! your left chances %d\n ",getNumberOfChances()-(getCurrentChance()+1));
  p.subPoints(); 
 }//end method
  
  
 
  private void equalComputerNum() {
  System.out.printf("you won at attempt %d your points are %d\n ",getCurrentChance()+1,p.getPoints());
 }//end method
  

  
  private void lossingCheck() {
	     if (getCurrentChance()==numberOfChances) {
	    	System.out.printf("you lost and your points = %d\n",p.getPoints());
	     System.out.printf("Computer guess was  %d\n",getComputerNum() );}
	  
	   } //end method

  
    
}//end of class Game