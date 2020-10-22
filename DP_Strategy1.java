
import java.io.*;
import java.awt.Graphics;
import java.awt.Point;

public class DP_Strategy1{
    public static void main(String args[])  
    { 
    	int[] var = {1, 2, 3, 4, 5 }; 
    	Context2 ctx = new Context2(new Addition()); 
    	ctx.arrange(var); 
    	
    	Context2 ctx2 = new Context2(new Substraction()); 
    	ctx2.arrange(var); 
    }

}    
    interface Strategy2 { 
    	public void calculate(int[] numbers); 
    } 
    class Addition implements Strategy2 
    { 
    	public void calculate(int[] numbers) 
    	{ System.out.println("Add the numbers"); 
    	} 
    }

    class Substraction implements Strategy2 
    { 
    	 public void calculate(int[] numbers) 
    	{ System.out.println("Substract the numbers"); 
    	} 
    } 
    
    class Context2 
    { 
    	private final Strategy2 strategy; 
    	public Context2(Strategy2 strategy) 
    	{ this.strategy = strategy; } 
    	
    	public void arrange(int[] input) 
    	{ strategy.calculate(input); } 
    }

   

   
    
    

