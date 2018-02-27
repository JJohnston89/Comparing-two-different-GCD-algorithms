import java.math.BigInteger;
import java.util.Scanner;

public class EuclidGCD {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);		
		
		BigInteger number1, number2, gcd;
		long startTime, endTime;
		
		System.out.println("This program computes the GCD by using Euclid's Algorithm");  //printing welcome message		
		
		while(true){	       //repeats until user enter 0		
			
			startTime = 0;     //initialize startTime, endTime, numbers, and gcd to 0 at each iteration
			endTime = 0;
			number1 = BigInteger.ZERO;
			number2 = BigInteger.ZERO;
			gcd = BigInteger.ZERO;
			
			
			System.out.println("To exit press 0 <enter>");          //prompting the user for input
			System.out.println("Enter two numbers in the format: x y <enter> or x <enter> y <enter>:  ");			
			
			try{
				
				 number1 = input.nextBigInteger();
				 
				 if(number1.equals(BigInteger.ZERO)){              //checking to see if user enter 0 to exit
						System.out.println("0 was enter program is shutting down");
					    break; 
					    }
				 
				number2 = input.nextBigInteger();
				
			        startTime = System.currentTimeMillis();      //starting time
				gcd = euclid(number1, number2);              //Calling euclid to compute the gcd(number1, number2)
			        endTime = System.currentTimeMillis();        //end time
				
				System.out.println("The GCD is " + gcd.toString());   //print the gcd and the time it took to execute
				System.out.println("Time in milliseconds: " + (endTime - startTime));
		      
			}catch(NumberFormatException ex){
			       
		    	  System.out.println("ERROR: re-enter your numbers!");      //If exception occurs print error message
		    	  continue;		    	                                    //then go back to the top of the loop
		            
		      } //catch
		} //while		
		
		input.close();
		
	}//end of main	
//-----------------------------------------------------------------------------	
	public static BigInteger euclid(BigInteger a, BigInteger b){
					
		if(b.equals(BigInteger.ZERO))            //base case: if b == 0; return a
			return a;
		
		else 
			return euclid(b, a.mod(b));          //else call euclid again
		
	} //end of euclid	
//-----------------------------------------------------------------------------
}//end of EuclidGCD Class
///////////////////////////////////////////////////////////////////////////////
