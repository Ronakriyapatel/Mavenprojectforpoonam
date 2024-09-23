package com.cuneiform.Mavenprojectforpoonam;

public class Arrayadd
{
    public void add() 
    {
    	
    	 	int a[] = {10, 20, 30};
    	    int b[] = {10, 20, 30};  
    	    int[] results = new int[3];
    	    int i;
    	   
    	    
        // Create an array to hold the results
       

        // Add elements of both arrays
        for (i = 0; i < a.length; i++)
        {
        	
            results[i] = a[i] + b[i]; // Sum corresponding elements
        }

        // Print the results
        System.out.println("Results of adding the two arrays:");
      
        
        for (int result : results) 
        {
            System.out.println(result);
        }
    }

    public static void main(String[] args) 
    {
        Arrayadd obj = new Arrayadd();
        obj.add();
    }
}
