package com.jasonv.portfolio.interviewquestions;

import junit.framework.TestCase;

/**
 * <p>What does it mean when you compare two objects with the equals-equals operator?</p>
 * 
 * You are checking that both variables point to the same underlying object.
 */
public class Question_06_Test extends TestCase {
	
	/**
	 * Variables point to objects on the heap.
	 */
	public void test_both_variables_should_point_to_same_object()
	{
		String a = new String("Hello");
		String b = a;
		
		// compares objects rather than values
		assertEquals(a==b,true);	
		
		// to compare values use the equals method.
		assertEquals(a.equals(b),true);			
	}
}
