package project;

public class Player{
    
    private int points=10;
    private String name;
    
    
    
    public Player(String n){
        setName(n); 
    }//end method


    
    public void setName(String name){ 
        this.name = name;
    }//end method
    
    
    public void setPoints(int points){
        
        this.points = (points > 0) ? points : 0;
   }//end method
    
       
    
    public String getName(){
        
        return name;
    }//end method
    
    
    public int getPoints(){
        
        return points;
    }//end method
    
    
    public void subPoints() {
        
    setPoints(getPoints()-2);

   }//end method
    
    
    public String toString(){
    
    return String.format("The name is %s\n The points are %d", getName(), getPoints() );
}//end method
      
    
    
} // end of class player