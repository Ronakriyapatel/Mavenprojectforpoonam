package com.cuneiform.Mavenprojectforpoonam;

public class Mergearray
{
	 public void merge() 
	    {
	    	
		 	int [] a= {10, 20, 30};
	        int [] b = {40, 50, 60}; 
	        
	        int al=a.length;
	        int bl=b.length;
	        int cl=a.length + b.length;
	        
	        int []c=new int [cl];
	        
	    		    
	        // Add elements of both arrays	        
	        for (int i = 0; i < al; i++)
	        {
	        	c[i]=a[i];
	        }	        
	                	
	        for (int i=0; i < bl ; i++)
	        {
	        	c[a.length+i]=b[i];
	        }
	        
	        for (int i=0;i<cl;i++)	        
	        {	        	
	        System.out.println(c[i]);
	        }
	  }
	       
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		Mergearray obj = new Mergearray();
	     obj.merge();
	}

	}


