import java.io.*;
import java.text.DecimalFormat;

public class DP_Strategy2 {
	  
    public static void main(String args[])  
    {
    	Calculate2 cal = new Calculate2(50, 15);
    	cal.check(new SubAlgorithmStrategy2());
    	cal.check(new AddAlgorithmStrategy2());    	
    }

}

interface AlgorithmStrategy2 {

	public void addsub(int n1, int n2);
}

class AddAlgorithmStrategy2 implements AlgorithmStrategy2 {
	
	public AddAlgorithmStrategy2(){

	}
	@Override
	public void addsub(int n1, int n2) {
		int add = n1 + n2 ;
		System.out.println(n1  + n2  +" is the added value");
	}

}

class SubAlgorithmStrategy2 implements AlgorithmStrategy2 {

	
	public SubAlgorithmStrategy2(){
	}
	
	@Override
	public void addsub(int n1, int n2) {
		int sub = n1 - n2 ;
		System.out.println(sub + " is the substracted value");
	}

}


class Calculate2 {


	int n1;
	int n2;
	

	public Calculate2(int n11, int n22){
		this.n1 = n11;
		this.n2 = n22;	
	}
	
	public void check(AlgorithmStrategy2 algoMethod){
		algoMethod.addsub(n1, n2);
	}
}





