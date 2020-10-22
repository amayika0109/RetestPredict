

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DP_Strategy3{
  
    public static void main(String args[])  
    { 

    	Calculate cal = new Calculate();
		
		Number n1 = new Number(10);
		Number n2 = new Number(40);
		
		cal.addItem(n1);
		cal.addItem(n2);

		cal.check(new SubAlgorithmStrategy());
		cal.check(new AddAlgorithmStrategy());    

    } 


}

interface AlgorithmStrategy {

	public void addsub(int amount);
}

class AddAlgorithmStrategy implements AlgorithmStrategy {
	
	public AddAlgorithmStrategy(){

	}
	@Override
	public void addsub(int amount) {
		System.out.println(amount +" is the added value");
	}

}

class SubAlgorithmStrategy implements AlgorithmStrategy {

	
	public SubAlgorithmStrategy(){
	}
	
	@Override
	public void addsub(int amount) {
		System.out.println(amount + " is the substracted value");
	}

}

class Number {

	private int price;
	
	public Number(int cost){
		this.price=cost;
	}

	public int getPrice() {
		return price;
	}
	
}
 
class Calculate {

	//List of items
	List<Number> ns;
	
	public Calculate(){
		this.ns=new ArrayList<Number>();
	}
	
	
	public void addItem(Number n){
		this.ns.add(n);
	}
	
	public void removeItem(Number n){
		this.ns.remove(n);
	}
	
	public int calculateTotal(){
		int sum = 0;
		for(Number n : ns){
			sum += n.getPrice();
		}
		return sum;
	}
	
	public void check(AlgorithmStrategy algoMethod){
		int amount = calculateTotal();
		algoMethod.addsub(amount);
	}
}
