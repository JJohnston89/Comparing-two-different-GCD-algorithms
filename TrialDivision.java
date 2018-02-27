import java.util.ArrayList;
import java.util.Scanner;


public class TrialDivision {
	
	public static void main(String[] args){
		
		long startTime, endTime, number1, number2, gcd;		
		
		Scanner input = new Scanner(System.in);	
		
		System.out.println("This program computes the GCD by using Trial Division");
		
		while(true){           //repeats until user enter 0			
			
			startTime = 0;     //initialize startTime and endTime to 0 at each iteration
			endTime = 0;
			
			System.out.println("To exit press 0 <enter>");    //prompting the user for input
			System.out.println("Enter two numbers in the format: x y <enter> or x <enter> y <enter>:  ");			
			
			try{
				
				 number1 = input.nextLong();
				 
				 if(number1 == 0){                //checking to see if user enter 0 to exit
						System.out.println("0 was enter program is shutting down");
					    break; 
					    }
				 
				number2 = input.nextLong();
				
			        startTime = System.currentTimeMillis();     //starting time
				gcd = GCD(number1, number2);               //Calling GCD to compute the gcd(number1, number2)
			        endTime = System.currentTimeMillis();      //end time
				
				System.out.println("The GCD is " + gcd);    //print the gcd and the time it took to execute 
				System.out.println("Time in milliseconds: " + (endTime - startTime));
		      
			}catch(NumberFormatException ex){
			       
		    	  System.out.println("ERROR: re-enter your numbers!");    //If exception occurs print error message
		    	  continue;		    	                                 //then go back to the top of the loop
		            
		      } //catch
		} //while		
		
		input.close();		
		
	}//end of main()
//-----------------------------------------------------------------------------	
	public static long GCD(long number1, long number2){
		ArrayList<Long> arr1, arr2, arr3;
		long gcd = 0;
		
		arr1 = trialDivision(number1);          //call trialDivision to get sets of factors 
		arr2 = trialDivision(number2);
		
		arr3 = intersection(arr1, arr2);        //take the intersection of the two sets from above
		
		if(arr3.isEmpty())                      //if the intersection is the empty set then gcd must be 1
			return 1;
		
		gcd = maxOut(arr3);                     //else take the max of the intersection 
		                                        //then return gcd
		return gcd;
		
	}// end of GCD()
//-----------------------------------------------------------------------------
	public static ArrayList<Long> trialDivision(long n){
		
		ArrayList<Long> arr = new ArrayList<>();     //making new list to hold the sets of factors
		
		if(n % 1 == 0){                              
			arr.add((long)1);                       
			arr.add(n);
		}//if
		
		for(long i = 2; i < Math.floor(Math.sqrt(n)); i++){    //starting at 2 to the square root of n
			
			if(n % i == 0){                                   //if n is composite 
				arr.add(i);                                   //then add pair of nontrivial factors to the list
				arr.add((long)Math.floor(n/i));			
			}//if				
		}//for
		
		if(arr.isEmpty()){                                   //if the list is empty then n must be prime
			arr.add(n);                                     //then add n and 1 to the list
			arr.add((long)1);
		}//if
		
		return arr;	
	}//end of trialDivision()
//-----------------------------------------------------------------------------	
	public static ArrayList<Long> intersection(ArrayList<Long> arr1, ArrayList<Long> arr2){
		
		ArrayList<Long> arr3 = new ArrayList<>();            //making new list 
		
		for(int i = 0; i < arr1.size(); i++){               //comparing one element at a time in the first list
			for(int j = 0; j < arr2.size(); j++){           //to the the whole 2nd list
				
				if(arr1.get(i).equals(arr2.get(j)))         //if a element is in both lists
					arr3.add(arr1.get(i));                  //then add it to the new list
			}//inner for
		}//outer for
		
		return arr3;
	}//end of intersection()
//-----------------------------------------------------------------------------
	public static long maxOut(ArrayList<Long> x){	
		
		long max = Long.MIN_VALUE;                   //setting the max to the lowest value   
		
		for(int i = 0; i < x.size(); i++){     
			
			if(x.get(i) > max){                      //if a element is bigger then the max
				max = x.get(i);                      //that element becomes the max
			}//if
			
		}//for
		return max;
	}//end of maxOut()
//-----------------------------------------------------------------------------
}//end of TrialDivision Class
///////////////////////////////////////////////////////////////////////////////


